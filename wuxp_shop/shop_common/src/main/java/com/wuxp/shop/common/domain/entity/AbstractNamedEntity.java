package com.wuxp.shop.common.domain.entity;

import com.wuxp.common.annotation.Desc;
import com.wuxp.shop.common.domain.Identifiable;
import com.wuxp.shop.common.domain.NamedObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 抽象的命名实体
 *
 * @param <ID>
 * @author wxup
 * @create 2018-06-10 14:45
 **/
@Data
@Desc("抽象的命名实体")
@MappedSuperclass
public abstract class AbstractNamedEntity<ID extends Serializable>
        implements Identifiable<ID>, NamedObject {


    private static final long serialVersionUID = 1617724711820794672L;

    @Desc("名称")
    @Column(name = "name", nullable = false)
    protected String name;


    @Override
    public AbstractNamedEntity<ID> clone() throws CloneNotSupportedException {
        return (AbstractNamedEntity<ID>) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
