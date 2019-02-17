package com.wuxp.basic.common.domain.entity;

import com.wuxp.basic.common.domain.SortableObject;
import com.wuxp.common.annotation.Desc;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static java.lang.Integer.compare;

/**
 * 抽象的带排序的实体
 *
 * @param <ID>
 * @param <SORT_INDEX> 排序索引
 * @author wxup
 * @create 2018-06-10 14:24
 **/
@Data
@Desc("抽象的带排序的实体")
@MappedSuperclass
public abstract class AbstractSortEntity<ID extends Serializable, SORT_INDEX extends Number>
        extends AbstractDateVersionEntity<ID>
        implements SortableObject<SORT_INDEX> {


    @Desc("排序索引")
    @Column(name = "sort_index")
    protected SORT_INDEX sortIndex;


    @Override
    public AbstractDateVersionEntity<ID> clone() throws CloneNotSupportedException {
        return (AbstractDateVersionEntity<ID>) super.clone();
    }

    @Override
    public int compareTo(SortableObject o) {
        //比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
        return compare(this.getSortIndex().intValue(), o.getSortIndex().intValue());
    }

}
