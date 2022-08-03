package com.compass.mpg.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户信息表
 *
 * @author itsaxon
 * @date 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("compass_sys_user")
@ApiModel(value = "CompassSysUserEntity对象", description = "用户信息表")
public class CompassSysUserEntity extends Model<CompassSysUserEntity> {

    private static final long serialVersionUID = 1L;

     /**
      * 用户ID
      */
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

     /**
      * 部门ID
      */
    @ApiModelProperty(value = "部门ID")
    @TableField("dept_id")
    private Long deptId;

     /**
      * 用户账号
      */
    @ApiModelProperty(value = "用户账号")
    @TableField("user_name")
    private String userName;

     /**
      * 用户昵称
      */
    @ApiModelProperty(value = "用户昵称")
    @TableField("nick_name")
    private String nickName;

     /**
      * 用户类型（00系统用户）
      */
    @ApiModelProperty(value = "用户类型（00系统用户）")
    @TableField("user_type")
    private String userType;

     /**
      * 用户邮箱
      */
    @ApiModelProperty(value = "用户邮箱")
    @TableField("email")
    private String email;

     /**
      * 手机号码
      */
    @ApiModelProperty(value = "手机号码")
    @TableField("phonenumber")
    private String phonenumber;

     /**
      * 用户性别（0男 1女 2未知）
      */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
    @TableField("sex")
    private String sex;

     /**
      * 头像地址
      */
    @ApiModelProperty(value = "头像地址")
    @TableField("avatar")
    private String avatar;

     /**
      * 密码
      */
    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

     /**
      * 帐号状态（0正常 1停用）
      */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    @TableField("status")
    private String status;

     /**
      * 删除标志（0代表存在 2代表删除）
      */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    @TableField("del_flag")
    @TableLogic
    private String delFlag;

     /**
      * 最后登录IP
      */
    @ApiModelProperty(value = "最后登录IP")
    @TableField("login_ip")
    private String loginIp;

     /**
      * 最后登录时间
      */
    @ApiModelProperty(value = "最后登录时间")
    @TableField("login_date")
    private Date loginDate;

     /**
      * 创建者
      */
    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private String createBy;

     /**
      * 创建时间
      */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

     /**
      * 更新者
      */
    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private String updateBy;

     /**
      * 更新时间
      */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

     /**
      * 备注
      */
    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
