package com.compass.client.api.weixin;

import com.compass.client.api.weixin.dto.WechatCallBackDTO;
import com.compass.client.api.weixin.dto.WechatUrlCheckDTO;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 微信回调 API
 *
 * @author itsaxon
 * @date 2022/08/11
 */
@RestController
@RequestMapping(value = "/wechat")
@Api(tags = "印章卫士提供给企业微信调用接口")
@ApiSort(8)
public interface WechatApi {


    /**
     * URL验证
     *
     * @param wechatUrlCheckDTO URL验证请求
     * @param response          响应
     */
    @GetMapping("/back")
    @ApiOperation(value = "URL验证")
    void urlCheck(WechatUrlCheckDTO wechatUrlCheckDTO, HttpServletResponse response);

    /**
     * 微信回调
     *
     * @param wechatCallBackDTO 微信回调请求
     * @return {@link String}
     */
    @PostMapping("/back")
    @ApiOperation(value = "URL验证")
    String callBack(WechatCallBackDTO wechatCallBackDTO);

}
