package com.wuxp.basic.common.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 树形对象
 *
 * @param <ID>
 * @param <P>
 * @author wxup
 * @create 2018-06-10 14:09
 **/
public interface TreeObject<ID extends Serializable, P extends Identifiable<ID>> extends Identifiable<ID> {


    /**
     * 获取父结点id
     *
     * @return parentId
     */
    ID getParentId();

    /**
     * 获取父对象
     *
     * @return parent
     */
    P getParent();

    /**
     * 获取所有的孩子对象
     *
     * @return children
     */
    <C extends P> Set<C> getChildren();
}
