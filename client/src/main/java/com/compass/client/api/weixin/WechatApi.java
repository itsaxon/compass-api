package com.compass.client.api.weixin;

import com.compass.client.api.weixin.dto.WechatCallBackDTO;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
     * url检查
     *
     * @param msgSignature 信息签名
     * @param timestamp    时间戳
     * @param nonce        现时标志
     * @param echostr      echostr
     * @param response     响应
     */
    @GetMapping("/back")
    @ApiOperation(value = "URL验证")
    void urlCheck(@RequestParam(name = "msgSignature") final String msgSignature,
                  @RequestParam(name = "timestamp") final String timestamp,
                  @RequestParam(name = "nonce") final String nonce,
                  @RequestParam(name = "echostr") final String echostr,
                  HttpServletResponse response);

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
