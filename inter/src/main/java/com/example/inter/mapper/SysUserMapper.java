package com.example.inter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.inter.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
}
