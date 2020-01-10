package com.liuhailong.springboot_i18n.controller;

import com.liuhailong.springboot_i18n.common.MsgData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description
 * @Author Liuhailong
 * @Date 2020/1/10 10:12
 **/
@Controller
@ResponseBody
public class TestController {
    @RequestMapping("/test")
    public MsgData test(String t){
        MsgData msg=new MsgData();
        if("200".equals(t)) {
            msg.setMsgCode("200");
            return msg;
        }
        msg.setMsgCode("500");
        return msg;
    }
}
