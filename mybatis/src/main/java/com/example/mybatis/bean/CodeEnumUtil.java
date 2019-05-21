package com.example.mybatis.bean;

/**
 * @Desc : .....
 * @Author : lufy
 * @Date : 2019/5/21 14:45
 */
public class CodeEnumUtil {
    public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getKey() == code)
                return e;
        }
        return null;
    }
}
