package com.compass.model.request;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 基本列表请求
 *
 * @author itsaxon
 * @date 2022/08/04
 */
@Data
public class BasePageRequest {

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    @Min(value = 1, message = "当前页不能小于1")
    @NotNull
    private final Integer pageNum = 1;

    /**
     * 每页大小
     */
    @ApiModelProperty("每页大小")
    @Min(value = 1, message = "每页大小不能小于1")
    @Max(value = 100, message = "每页大小不能大于100")
    @NotNull
    private final Integer pageSize = 10;

    /**
     * 排序字段
     */
    @ApiModelProperty("排序字段")
    private final String sortName = "id";

    /**
     * 排序方式
     */
    @ApiModelProperty("排序方式,是否升序")
    private final Boolean isAsc = false;

    /**
     * 启用
     */
    @ApiModelProperty("状态 1正常 0停用")
    private Integer enable;

    /**
     * 关键字
     */
    @ApiModelProperty("关键字")
    @Size(max = 80, message = "搜索条件长度非法")
    private String q;

    /**
     * 最小创建时间
     */
    @ApiModelProperty("最小创建时间")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date minCreateTime;

    /**
     * 最大创建时间
     */
    @ApiModelProperty("最大创建时间")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date maxCreateTime;

    /**
     * 最小更新时间
     */
    @ApiModelProperty("最小更新时间")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date minUpdateTime;

    /**
     * 最大更新时间
     */
    @ApiModelProperty("最大更新时间")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date maxUpdateTime;

}
