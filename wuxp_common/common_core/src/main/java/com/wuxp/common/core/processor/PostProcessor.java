package com.wuxp.common.core.processor;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.condition.BeanRunTimeCondition;
import org.springframework.core.Ordered;


/**
 * 后置处理者
 *
 * @param <T>
 */
@Desc("后置处理者")
public interface PostProcessor<T> extends BeanRunTimeCondition, Ordered {

    /**
     * 后置处理
     *
     * @param t
     */
    void postProcessor(T t);
}
