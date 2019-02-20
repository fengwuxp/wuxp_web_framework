package com.wuxp.basic.member.processors;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.processor.PrevProcessor;


@Desc("用户创建前置处理")
public interface CreateMemberPrevProcessor<T> extends PrevProcessor<T> {
}
