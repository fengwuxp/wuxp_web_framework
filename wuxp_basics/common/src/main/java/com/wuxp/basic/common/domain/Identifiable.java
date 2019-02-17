package com.wuxp.basic.common.domain;

import java.io.Serializable;

/**
 * 可标识的对象
 *
 * @param <ID>
 * @author wxup
 * @create 2018-06-10 14:05
 **/
public interface Identifiable<ID extends Serializable> extends
        Serializable,
        Cloneable{

    /**
     * 获取对象标识
     *
     * @return id
     */
    ID getId();
}
