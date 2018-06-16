package com.wuxp.shop.system.entities;

import com.wuxp.common.annotation.Desc;
import com.wuxp.shop.common.domain.EnabledObject;
import com.wuxp.shop.common.domain.entity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * 地区信息
 *
 * @author wxup
 * @create 2018-06-09 20:23
 **/
@Desc("地区信息")
@Entity
@Table(name = "t_area")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"parent", "children"})
public class Area extends AbstractBaseEntity<String, Short> implements EnabledObject {

    @Desc("地区编码")
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 64)
    private String id;

    @Desc("地区父ID")
    @Column(name = "parent_id", length = 64)
    private String parentId;

    @Desc("地区简称")
    @Column(name = "short_name", nullable = false, length = 128)
    private String shortName;

    @Desc("经度")
    @Column(name = "longitude", nullable = false, precision = 16)
    private Float longitude;

    @Desc("纬度")
    @Column(name = "latitude", nullable = false, precision = 16)
    private Float latitude;

    @Desc("地区深度，从1开始")
    @Column(name = "level", nullable = false)
    private Short level;

    @Desc("地区启用状态")
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Desc("第三方地区编码")
    @Column(name = "third_code")
    private String thirdCode;

    @Desc(value = "上级地区")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Area parent;

    @Desc("下级地区列表")
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    private Set<Area> children;


    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
