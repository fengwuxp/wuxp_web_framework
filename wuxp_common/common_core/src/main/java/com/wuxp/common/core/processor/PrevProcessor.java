package com.wuxp.common.core.processor;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.condition.BeanRunTimeCondition;

/**
 * 前置处理
 *
 * @param <T>
 */
@Desc("预处理者")
public interface PrevProcessor<T> extends BeanRunTimeCondition {

    /**
     * 前置处理
     *
     * @param t
     */
    void prevProcess(T t);
}
