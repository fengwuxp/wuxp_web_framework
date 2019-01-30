package com.wuxp.common.core.condition;

/**
 * 运行时的bean是否有被启用
 */
public interface BeanRunTimeCondition {

    /**
     * 是否启用
     *
     * @return
     */
    boolean enabled();
}
