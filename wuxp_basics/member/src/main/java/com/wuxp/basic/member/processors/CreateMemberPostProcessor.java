package com.wuxp.basic.member.processors;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.processor.PostProcessor;

@Desc("用户创建后置处理")
public interface CreateMemberPostProcessor<T> extends PostProcessor<T> {
}
