package com.example.inter.controller;

import com.example.inter.req.SysUserLoginReq;
import com.example.inter.req.SysUserSaveReq;
import com.example.inter.resp.CommonResp;
import com.example.inter.resp.SysUserLoginResp;
import com.example.inter.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("register")
    public CommonResp register(@RequestBody SysUserSaveReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        sysUserService.register(req);
        System.out.println("注册成功");
        System.out.println(req.toString());
        return resp;
    }
    @PostMapping("login")
    public CommonResp login(@RequestBody SysUserSaveReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        SysUserLoginResp userLoginResp = sysUserService.login(req);
        resp.setContent(userLoginResp);
        return resp;
    }
}
