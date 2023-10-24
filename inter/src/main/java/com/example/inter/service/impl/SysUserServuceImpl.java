package com.example.inter.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.inter.entity.SysUserEntity;
import com.example.inter.mapper.SysUserMapper;
import com.example.inter.req.SysUserSaveReq;
import com.example.inter.service.SysUserService;
import com.example.inter.utils.CopyUtil;
import com.example.inter.utils.SnowFlake;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
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
        if(ObjectUtils.isEmpty(req.getId())){
            SysUserEntity userDb = selectByLoginEmail(req.getEmail());
            if(ObjectUtils.isEmpty(userDb)){
                user.setId(snowFlake.nextId());
                sysUserMapper.insert(user);
            }
        }
    }

    //查询loginName是否被注册
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
