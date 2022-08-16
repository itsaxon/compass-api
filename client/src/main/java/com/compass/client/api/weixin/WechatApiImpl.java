package com.compass.client.api.weixin;

import cn.hutool.core.util.URLUtil;
import com.compass.client.api.weixin.dto.WechatCallBackDTO;
import com.compass.client.api.weixin.dto.WechatConfigDTO;
import com.compass.client.api.weixin.dto.WechatUrlCheckDTO;
import com.compass.client.api.weixin.tools.WXBizMsgCrypt;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
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
     * URL验证
     *
     * @param wechatUrlCheckDTO URL验证请求
     * @param response          响应
     */
    @Override
    @SneakyThrows
    public void urlCheck(WechatUrlCheckDTO wechatUrlCheckDTO, HttpServletResponse response) {

        // 企微加密签名
        String msgSignatureParse = URLUtil.decode(wechatUrlCheckDTO.getMsgSignature());
        // 时间戳
        String timestampParse = URLUtil.decode(wechatUrlCheckDTO.getTimestamp());
        // 随机数
        String nonceParse = URLUtil.decode(wechatUrlCheckDTO.getNonce());
        // 包含消息内容的加密字符串
        String echostrParse = URLUtil.decode(wechatUrlCheckDTO.getEchostr());
        // 企微消息配置
        WechatConfigDTO wechatConfig = getWechatConfig();

        // 企微加解密工具
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(wechatConfig.getToken(),
                wechatConfig.getEncodingAesKey(),
                wechatConfig.getReceiveId());

        // 解密后的明文
        String echosrt = wxBizMsgCrypt.VerifyURL(msgSignatureParse,
                timestampParse,
                nonceParse,
                echostrParse);
        System.out.println("解密后的信息为：===========" + echosrt + "===========");

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
        wechatConfigDTO.setToken("789jkdjueiklokijikiasfghjureasdfghjnvbhfre3");
        wechatConfigDTO.setEncodingAesKey("789jkdjueiklokijikiasfghjureasdfghjnvbhfre3");
        wechatConfigDTO.setReceiveId("temjsjfkdjkfhkh12312");
        return wechatConfigDTO;
    }

}
