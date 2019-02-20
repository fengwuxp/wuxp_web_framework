package com.wuxp.basic.member.strategy;

import com.wuxp.basic.member.dto.BaseCreateMemberReq;
import com.wuxp.basic.member.dto.MemberInfo;
import com.wuxp.common.annotation.Desc;

/**
 * 创建用户策略
 *
 * @param <M>
 * @param <T>
 */
public interface CreateMemberStrategy<M extends MemberInfo, T extends BaseCreateMemberReq> {

    /**
     * 创建用户
     *
     * @param request
     * @return
     */
    M create(T request);
}
