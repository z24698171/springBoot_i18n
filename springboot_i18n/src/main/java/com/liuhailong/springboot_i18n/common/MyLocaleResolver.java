package com.liuhailong.springboot_i18n.common;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 在链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");//得到l参数值
        Locale locale = Locale.getDefault();//得到默认语言资源内容
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");//分割参数内容,
            locale = new Locale(split[0], split[1]);//根据传入参数内容选择不同语言
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}