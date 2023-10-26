package com.example.inter.service;

import com.example.inter.req.SysUserSaveReq;
import com.example.inter.resp.SysUserLoginResp;


public interface SysUserService {
    void register(SysUserSaveReq req);

    SysUserLoginResp login(SysUserSaveReq req);
}
