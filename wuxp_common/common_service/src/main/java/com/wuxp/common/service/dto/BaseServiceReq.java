package com.wuxp.common.service.dto;

import com.wuxp.common.annotation.Desc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Desc("基础的服务器请求对象")
public abstract class BaseServiceReq {


    @Desc("appId")
    protected String appId;

    @Desc("app secret")
    protected String appSecret;

    @Desc("客户端渠道")
    protected String clientChannel;
}
