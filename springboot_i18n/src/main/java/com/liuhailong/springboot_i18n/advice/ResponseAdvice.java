package com.liuhailong.springboot_i18n.advice;

import com.liuhailong.springboot_i18n.common.MsgData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.support.RequestContext;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ResponseAdvice
 * @Description
 * @Author Liuhailong
 * @Date 2020/1/10 10:05
 **/
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse response) {
        if(returnValue instanceof MsgData){
            ServletServerHttpRequest sshr= (ServletServerHttpRequest) serverHttpRequest;
            HttpServletRequest request=   sshr.getServletRequest();
            MsgData msg=(MsgData)returnValue;
            String msgCode=msg.getMsgCode();
            msg.setMsgInfo(getMessage(request, msgCode));
            System.out.println("--------msg-----:\n"+msg);
            return msg;
        }
        return null;
    }

    /**
     * 从国际化资源配置文件中根据key获取value
     * @param request
     * @param key
     * @return
     */
    public static String getMessage(HttpServletRequest request, String key){
        RequestContext requestContext = new RequestContext(request);
        String value = requestContext.getMessage(key);
        return value;
    }
}
