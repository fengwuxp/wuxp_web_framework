package com.wuxp.common.core.processor;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.condition.BeanRunTimeCondition;
import org.springframework.core.Ordered;


/**
 * 前置处理
 *
 * @param <T>
 */
@Desc("前置预处理者")
public interface PrevProcessor<T> extends BeanRunTimeCondition, Ordered {

    /**
     * 前置处理
     *
     * @param t
     */
    void prevProcess(T t);
}
