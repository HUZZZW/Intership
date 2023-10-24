package com.example.inter.controller;

import com.example.inter.req.SysUserLoginReq;
import com.example.inter.req.SysUserSaveReq;
import com.example.inter.resp.CommonResp;
import com.example.inter.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("register")
    public CommonResp register(SysUserSaveReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        sysUserService.register(req);
        return resp;
    }

//    @PostMapping("Login")
//    public CommonResp login(SysUserLoginReq req){
//
//    }
}
