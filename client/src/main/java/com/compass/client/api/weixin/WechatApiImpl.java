package com.compass.client.api.weixin;

import cn.hutool.core.util.URLUtil;
import com.compass.client.api.weixin.dto.WechatCallBackDTO;
import com.compass.client.api.weixin.dto.WechatConfigDTO;
import com.compass.client.api.weixin.tools.WXBizMsgCrypt;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 微信回调 API 实现
 *
 * @author itsaxon
 * @date 2022/08/11
 */
@Service
@RestController
public class WechatApiImpl implements WechatApi {


    /**
     * url检查
     *
     * @param msgSignature 信息签名
     * @param timestamp    时间戳
     * @param nonce        现时标志
     * @param echostr      echostr
     * @param response     响应
     */
    @Override
    @SneakyThrows
    public void urlCheck(@RequestParam(name = "msgSignature") final String msgSignature,
                         @RequestParam(name = "timestamp") final String timestamp,
                         @RequestParam(name = "nonce") final String nonce,
                         @RequestParam(name = "echostr") final String echostr,
                         HttpServletResponse response) {

        // 企微消息配置
        WechatConfigDTO wechatConfig = getWechatConfig();

        // 企微加解密工具
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(wechatConfig.getToken(),
                wechatConfig.getEncodingAesKey(),
                wechatConfig.getReceiveId());

        // 对请求 URL 进行解密

        // 企微加密签名
        String msgSignatureParse = URLUtil.decode(msgSignature);
        // 时间戳
        String timestampParse = URLUtil.decode(timestamp);
        // 随机数
        String nonceParse = URLUtil.decode(nonce);
        // 包含消息内容的加密字符串
        String echostrParse = URLUtil.decode(echostr);

        // 解密后的明文
        String echosrt= wxBizMsgCrypt.VerifyURL(msgSignatureParse,
                timestampParse,
                nonceParse,
                echostrParse);
        System.out.println("解密后的信息为：==========="+echosrt+"===========");

        PrintWriter writer = response.getWriter();
        writer.write(echosrt);
        writer.flush();
    }

    /**
     * 微信回调
     *
     * @param wechatCallBackDTO 微信回调请求
     * @return {@link String}
     */
    @Override
    public String callBack(WechatCallBackDTO wechatCallBackDTO) {
        return "success";
    }

    /**
     * 得到微信配置
     *
     * @return {@link WechatConfigDTO}
     */
    public WechatConfigDTO getWechatConfig() {
        WechatConfigDTO wechatConfigDTO = new WechatConfigDTO();
        wechatConfigDTO.setToken("");
        wechatConfigDTO.setEncodingAesKey("");
        wechatConfigDTO.setReceiveId("");
        return wechatConfigDTO;
    }

}
