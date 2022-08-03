package com.compass.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回实体基类
 *
 * @author itsaxon
 * @date 2022/08/03
 */
@Data
@ApiModel(value = "返回实体", description = "返回实体")
public class CompassResponse<T> implements Serializable {

    @ApiModelProperty(value = "返回状态码，10000代表成功", example = "10000")
    private int bizCode;

    @ApiModelProperty(value = "返回消息，当状态码为非10000，该字段为异常信息", example = "")
    private String bizMsg;

    @ApiModelProperty(value = "返回的数据", example = "")
    private T data;
    private String sign;
    private long timestamp;
    private String postToken;

    public CompassResponse(String bizMsg, T data, int bizCode) {
        this(bizCode, bizMsg, data, null);
    }

    public CompassResponse(int bizCode, String bizMsg, T data, String postToken) {
        this.bizCode = CompassResponseEnum.SUCCESS.getBizCode();
        this.bizMsg = "操作成功";
        this.timestamp = System.currentTimeMillis();
        this.bizCode = bizCode;
        this.bizMsg = bizMsg;
        this.data = data;
        this.postToken = postToken;
        this.timestamp = System.currentTimeMillis();
    }

    public CompassResponse(T data) {
        this("", data, CompassResponseEnum.SUCCESS.getBizCode());
    }

    public static <T> CompassResponse<T> ok(T data) {
        return new CompassResponse<>(data);
    }

    public static <T> CompassResponse<T> ok(String msg, T data) {
        return new CompassResponse<>(msg, data, CompassResponseEnum.SUCCESS.getBizCode());
    }

    public static CompassResponse<?> error() {
        return new CompassResponse<>("操作失败", null, CompassResponseEnum.ERROR.getBizCode());
    }

    public static CompassResponse<?> error(String msg) {
        return new CompassResponse<>(msg, null, CompassResponseEnum.ERROR.getBizCode());
    }

    public static CompassResponse<?> error(String msg, int bizCode) {
        return new CompassResponse<>(msg, null, bizCode);
    }

}
