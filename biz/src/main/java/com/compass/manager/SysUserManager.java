package com.compass.manager;

import com.compass.mpg.service.CompassSysUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 系统用户管理
 *
 * @author itsaxon
 * @date 2022/08/03
 */
@Component
public class SysUserManager {

    @Resource
    private CompassSysUserService compassSysUserService;





}
