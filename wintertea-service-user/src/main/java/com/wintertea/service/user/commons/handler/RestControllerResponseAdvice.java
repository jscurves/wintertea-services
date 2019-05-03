package com.wintertea.service.user.commons.handler;

import com.wintertea.service.user.commons.result.ResultEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;

/**
 * 统一数据返回结果
 * @author woody
 */
@RestControllerAdvice
public class RestControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 排除swagger配置项信息
     * @param body
     * @return
     */
    private Object excludeSwagger(Object body) {
        if (body instanceof List) {
            Object object = ((List) body).get(0);
            if (object instanceof SwaggerResource) {
                return body;
            }
        }

        if (body instanceof Json) {
            return body;
        }

        return null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        System.out.println(body);
        Object object = this.excludeSwagger(body);
        if (object != null) {
            return object;
        }


        // 防止对异常信息二次封装
        if (body instanceof ResultEntity) {
            return body;
        }
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(200);
        resultEntity.setEntity(body);
        return resultEntity;
    }
}
