package com.wuxp.shop.common.domain;

/**
 * 可编辑的对象
 *
 * @author wxup
 * @create 2018-06-10 14:14
 **/
public interface EditableObject {

    /**
     * 获取编辑状态
     *
     * @return
     */
    boolean isEditable();
}
