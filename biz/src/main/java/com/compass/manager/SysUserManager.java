package com.compass.manager;

import cn.hutool.extra.cglib.CglibUtil;
import com.compass.common.constant.CompassConstants;
import com.compass.model.request.SysUserPageRequest;
import com.compass.model.vo.SysUserPageVO;
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

    /**
     * 得到系统用户列表
     *
     * @param request 请求
     * @return {@link PageInfo}<{@link SysUserPageVO}>
     */
    public PageInfo<SysUserPageVO> selectSysUserList(SysUserPageRequest request) {

        PageHelper.startPage(request.getPageNum(), request.getPageSize());

        // 获取系统用户列表
        List<CompassSysUserEntity> compassSysUserEntityList = compassSysUserService.lambdaQuery()
                .eq(CompassSysUserEntity::getDelFlag, CompassConstants.DelFlag.FALSE)
                .list();
        return new PageInfo<>(CglibUtil.copyList(compassSysUserEntityList, SysUserPageVO::new));
    }
}
