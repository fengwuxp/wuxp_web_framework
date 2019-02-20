package com.wuxp.basic.member.dto;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.service.dto.BaseServiceReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Desc("基础创建用户req")
public class BaseCreateMemberReq extends BaseServiceReq {

    @Desc("用户名")
    protected String userName;

    @Desc("密码")
    protected String password;


    @Desc("昵称")
    protected String nickName;

    @Desc("手机号码")
    protected String mobilePhone;
}
