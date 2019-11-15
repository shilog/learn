package cn.jxufe.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    /****
     * 获取用户名
     * @return
     */
    @RequestMapping(value = "/name")
    public String getUerName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
