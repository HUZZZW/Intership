package com.example.inter.service;

import com.example.inter.req.SysUserSaveReq;
import org.springframework.stereotype.Component;


public interface SysUserService {
    void register(SysUserSaveReq req);
}
