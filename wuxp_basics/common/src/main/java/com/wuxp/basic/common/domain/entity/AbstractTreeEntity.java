package com.wuxp.basic.common.domain.entity;

import com.wuxp.basic.common.domain.Identifiable;
import com.wuxp.basic.common.domain.SortableObject;
import com.wuxp.basic.common.domain.TreeObject;
import com.wuxp.common.annotation.Desc;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 抽象的树形实体
 *
 * @author wxup
 * @create 2018-06-10 14:43
 **/
@Data
@Desc("抽象的树形实体")
@MappedSuperclass
public abstract class AbstractTreeEntity<ID extends Serializable, T extends Identifiable<ID>>
        extends AbstractDateVersionEntity<ID>
        implements TreeObject<ID, T>, SortableObject<Integer> {

    private static final long serialVersionUID = -123456789L;

    @Column(name = "parent_id")
    protected ID parentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    protected T parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    @OrderBy(value = "orderIndex DESC,name ASC")
    protected Set<T> children;


    @Desc("id路径，使用自定义分符号包围，如|1|3|15|")
    @Column(name = "id_path", length = 1024)
    protected String idPath;

    @Desc("排序索引")
    @Column(name = "order_index")
    protected Integer orderIndex;

    protected AbstractTreeEntity() {
    }

    protected AbstractTreeEntity( ID parentId) {
        this.parentId = parentId;
    }

    public ID getParentId() {
        return parentId;
    }

    public void setParentId(ID parentId) {
        this.parentId = parentId;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        if (parent == null) {
            this.parent = null;
            this.parentId = null;
        } else {

            if (this.equals(parent))
                throw new IllegalArgumentException("parent is self");

            this.parent = parent;
            this.parentId = parent.getId();
        }
    }

    public void setChildren(Set<T> children) {
        this.children = children;
    }

    public Set<T> getChildren() {
        return children;
    }


    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }
}
