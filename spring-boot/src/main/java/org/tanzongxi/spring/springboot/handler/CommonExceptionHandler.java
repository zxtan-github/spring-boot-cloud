package org.tanzongxi.spring.springboot.handler;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> errorMsg() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("errorCode", "500");
        objectMap.put("errorMsg", "系统异常");
        return objectMap;
    }


    /**
     * 配置默认错误页面（仅用于内嵌tomcat启动时）
     * 使用这种方式，在打包为war后不起作用
     *
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
            container.addErrorPages(error404Page, error500Page);
        };
    }
}