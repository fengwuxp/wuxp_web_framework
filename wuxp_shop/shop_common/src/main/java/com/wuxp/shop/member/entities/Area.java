package com.wuxp.shop.member.entities;

import com.wuxp.common.annotation.Desc;
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
@Entity
@Desc("地区信息")
@Table(name = "t_area")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"parent", "children"})
public class Area implements java.io.Serializable {

    @Desc("地区编码")
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 50)
    private String id;

    @Desc("地区父ID")
    @Column(name = "parent_id", length = 50)
    private String parentId;

    @Desc("地区名称")
    @Column(name = "`name`", nullable = false, length = 200)
    private String name;

    @Desc("地区简称")
    @Column(name = "short_name", nullable = false, length = 200)
    private String shortName;

    @Desc("经度")
    @Column(name = "`longitude`", nullable = false, precision = 12)
    private Float longitude;

    @Desc("纬度")
    @Column(name = "`latitude`", nullable = false, precision = 12)
    private Float latitude;

    @Desc("地区深度，从1开始")
    @Column(name = "`level`", nullable = false)
    private Integer level;

    @Desc("排序")
    @Column(name = "`sort`", nullable = false)
    private Short sort;

    @Desc("地区启用状态")
    @Column(name = "`status`", nullable = false)
    private Boolean status;

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


}
