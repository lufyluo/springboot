package com.example.dubbo.consumer.filter;

import com.example.dubbo.consumer.bean.Response;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/6/12
 */
@RestController
public class GlobalErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public Response<Void> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        if (statusCode == 401) {
            return new Response(exception,401,requestUri);
        } else if (statusCode == 404) {
            return new Response(exception,404,requestUri);
        } else if (statusCode == 403) {
            return new Response(exception,403,requestUri);
        } else {
            String msg = null;
            if (exception != null && exception.getMessage() != null) {
                String[] str = exception.getMessage().split(":");
                if (str.length == 2)
                    msg = str[1];
                else
                    msg = "500";
            }

            return new Response(exception,500,msg);
        }

    }
}
