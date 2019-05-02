package com.wintertea.service.user.commons.handler;

import com.wintertea.service.user.commons.result.ResultEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

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

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
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
