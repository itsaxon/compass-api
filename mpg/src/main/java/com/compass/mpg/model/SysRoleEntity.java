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
 * 角色信息表
 *
 * @author itsaxon
 * @date 2022-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
@ApiModel(value = "SysRoleEntity对象", description = "角色信息表")
public class SysRoleEntity extends Model<SysRoleEntity> {

    private static final long serialVersionUID = 1L;

     /**
      * 角色ID
      */
    @ApiModelProperty(value = "角色ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

     /**
      * 角色名称
      */
    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private String roleName;

     /**
      * 角色权限字符串
      */
    @ApiModelProperty(value = "角色权限字符串")
    @TableField("role_key")
    private String roleKey;

     /**
      * 显示顺序
      */
    @ApiModelProperty(value = "显示顺序")
    @TableField("role_sort")
    private Integer roleSort;

     /**
      * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
      */
    @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    @TableField("data_scope")
    private String dataScope;

     /**
      * 菜单树选择项是否关联显示
      */
    @ApiModelProperty(value = "菜单树选择项是否关联显示")
    @TableField("menu_check_strictly")
    private Boolean menuCheckStrictly;

     /**
      * 部门树选择项是否关联显示
      */
    @ApiModelProperty(value = "部门树选择项是否关联显示")
    @TableField("dept_check_strictly")
    private Boolean deptCheckStrictly;

     /**
      * 角色状态（0正常 1停用）
      */
    @ApiModelProperty(value = "角色状态（0正常 1停用）")
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
        return this.roleId;
    }

}