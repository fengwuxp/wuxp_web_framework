package com.wuxp.basic.common.domain.entity;

import com.wuxp.basic.common.domain.Identifiable;
import com.wuxp.common.annotation.Desc;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * 抽象的基本实体
 *
 * @param <ID>
 * @author wxup
 * @create 2018-06-10 14:24
 **/
@Data
@Desc("带时间版本的实体")
@MappedSuperclass
public abstract class AbstractDateVersionEntity<ID extends Serializable> implements Identifiable<ID> {


    private static final long serialVersionUID = 5673808672278538401L;

    @Desc("创建时间")
    @Column(name = "create_time",nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date createTime = new Date();

    @Desc("最后更新时间")
    @Column(name = "last_update_time",nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date lastUpdateTime;




    @Override
    public boolean equals(Object target) {

        if (this == target) return true;

        //如果比较对象为null或是，类定义不相同，则视为不相等
        //必须是同一个类加裁器加载的类
        if (target == null || this.getClass() != target.getClass()) return false;

        Identifiable<ID> that = (Identifiable<ID>) target;

        //如果有一个对象的ID为null或ID不相等，就认为对象不相等
        if (this.getId() == null || that.getId() == null || !this.getId().equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        ID entityId = getId();
        return entityId != null ? entityId.hashCode() : super.hashCode();
    }

}
