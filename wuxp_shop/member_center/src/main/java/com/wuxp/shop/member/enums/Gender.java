package com.wuxp.shop.member.enums;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.enums.DescriptiveEnum;

/**
 * 性别
 *
 * @author wxup
 * @create 2018-06-09 18:12
 **/
@Desc("性别")
public enum Gender implements DescriptiveEnum {

    @Desc("男")
    MALE,

    @Desc("女")
    FEMALE,

    @Desc("保密")
    SECRET
}
