package com.example.inter.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.inter.entity.SysUserEntity;
import com.example.inter.mapper.SysUserMapper;
import com.example.inter.req.SysUserSaveReq;
import com.example.inter.resp.SysUserLoginResp;
import com.example.inter.service.SysUserService;
import com.example.inter.utils.CopyUtil;
import com.example.inter.utils.SnowFlake;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class SysUserServuceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {
   @Resource
    private SysUserMapper sysUserMapper;
   @Autowired
    private SnowFlake snowFlake;

   //注册账号
    @Override
    public void register(SysUserSaveReq req) {
        SysUserEntity user = CopyUtil.copy(req, SysUserEntity.class);
        if(req.getId() == 0){
            SysUserEntity userDb = selectByLoginEmail(req.getEmail());
            if(ObjectUtils.isEmpty(userDb)){
                user.setId(snowFlake.nextId());
                sysUserMapper.insert(user);
            }
        }
    }

    @Override
    public SysUserLoginResp login(SysUserSaveReq req) {
        SysUserEntity userDB = selectByLoginEmail(req.getEmail());
        if(ObjectUtils.isEmpty(userDB)){
            //用户不存在
            return null;
        }else{
            SysUserLoginResp userLoginResp = CopyUtil.copy(userDB, SysUserLoginResp.class);
            return userLoginResp;
        }
    }

    //查询loginName是否被注册,查询账号的方法
    public SysUserEntity selectByLoginEmail(String loginEmail){
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getEmail,loginEmail);
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(userEntityList)){ return null;}
        else {
            return userEntityList.get(0);
        }

    }
}
