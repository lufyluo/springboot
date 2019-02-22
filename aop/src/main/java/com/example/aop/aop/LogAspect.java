package com.example.aop.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Order(4)
@Component
public class LogAspect {
    @Pointcut("execution(public * com.example.aop.service..*(..))")
    public void declearJoinPointExpression(){}

    @Around(value = "declearJoinPointExpression()")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around :---before");
        Object result =  joinPoint.proceed();
        System.out.println("Around :---after");
        return result;
    }
    @Around(value="declearJoinPointExpression()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String signatureName = joinPoint.getSignature().getName();
        Class<? extends Object> invokeClass = joinPoint.getTarget().getClass();
        if (isTagged(invokeClass, signatureName)) {
            System.out.println(signatureName + " is tagged");
            return joinPoint.proceed();
        }else{
            System.out.println(signatureName + " is not tagged!!");
            return joinPoint.proceed();
        }
    }
    private String getLog(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = joinPoint.getSignature().getName();
        String controller = joinPoint.getTarget().getClass().getName();
        String args = mapper.writeValueAsString(joinPoint.getArgs());
        String response = mapper.writeValueAsString(result);
        return "locate： "+controller+"/"+methodName+" params: "+args+" retruns: " + response;
    }

    /**
     * 异常通知（方法发生异常执行的代码）
     * 可以访问到异常对象；且可以指定在出现特定异常时执行的代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value="declearJoinPointExpression()",throwing="ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        try {
            String log = getLog(joinPoint, ex);
            System.out.println("ERROR: " + log);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    //扫描父类是否被打上标签,或者父类中的这个方法是否被打伤标签
    private boolean isTagged(Class invokeClass, String signatureName) {
        if (isTaggedInInterfaceOf(invokeClass, signatureName)) {
            return true;
        }
        if (!invokeClass.equals(Object.class)) {
            return isTaggedInClassOf(invokeClass, signatureName) ? true :
                    isTagged(invokeClass.getSuperclass(), signatureName);
        }
        return false;
    }

    //扫描当前类的接口
    private boolean isTaggedInInterfaceOf(Class invokeClass, String signatureName) {
        Class[] interfaces = invokeClass.getInterfaces();
        for (Class cas : interfaces) {
            return isTaggedInClassOf(cas, signatureName) ? true :
                    isTaggedInInterfaceOf(cas, signatureName);
        }
        return false;
    }

    //方法名为signatureName的方法tagged有两种情况:方法本身被taged或者方法所在的类被taged
    private boolean isTaggedInClassOf(Class cas, String signatureName) {
        return Arrays.stream(cas.getDeclaredMethods()).anyMatch(method ->
                isMethodWithName(method, signatureName) && isMethodTagged(method)
                        || isMethodWithName(method, signatureName) && isClassTagged(cas));
    }

    private boolean isClassTagged(Class invokeClass) {
        return invokeClass.getAnnotation(LogAnnotation.class) != null;
    }

    private boolean isMethodTagged(Method method) {
        return method.getAnnotation(LogAnnotation.class) != null;
    }

    private boolean isMethodWithName(Method method, String name) {
        return method.getName().equals(name);
    }
}
