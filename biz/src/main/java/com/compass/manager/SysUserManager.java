package com.compass.manager;

import com.compass.common.constant.CompassConstants;
import com.compass.mpg.model.CompassSysUserEntity;
import com.compass.mpg.service.CompassSysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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

    public void selectSysUserList(){

        PageHelper.startPage(1,10);

        // 获取系统用户列表
        List<CompassSysUserEntity> compassSysUserEntityList = compassSysUserService.lambdaQuery()
                .eq(CompassSysUserEntity::getDelFlag, CompassConstants.DelFlag.FALSE)
                .list();
        PageInfo<CompassSysUserEntity> compassSysUserEntityPageInfo = new PageInfo<>(compassSysUserEntityList);





    }






}
