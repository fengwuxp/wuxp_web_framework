package com.wuxp.shop.member.enums;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.enums.DescriptiveEnum;

/**
 * @author wxup
 * @create 2018-06-09 20:28
 **/
@Desc("用户审核状态")
public enum MemberVerifyStatus implements DescriptiveEnum {

    @Desc("待审核")
    PENDING,

    @Desc("审核通过")
    APPROVED,//审核通过

    @Desc("审核拒绝")
    REFUSE;//拒绝
}
