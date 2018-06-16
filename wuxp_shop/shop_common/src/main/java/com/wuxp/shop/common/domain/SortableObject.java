package com.wuxp.shop.common.domain;

/**
 * 可排序的对象
 *
 * @param <T>
 * @author wxup
 * @create 2018-06-10 14:06
 **/
public interface SortableObject<T extends Number> extends Comparable<SortableObject> {

    /**
     * 获取排序索引
     *
     * @return T
     */
    T getSortIndex();
}
