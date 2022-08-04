package com.compass.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户列表请求
 *
 * @author itsaxon
 * @date 2022/08/03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserPageRequest extends BasePageRequest{

    @ApiModelProperty("用户信息")
    private String userName;

    @ApiModelProperty("时间")
    private String time;

}
