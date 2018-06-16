package com.wuxp.shop.system.entities;

import com.wuxp.common.annotation.Desc;
import com.wuxp.shop.common.domain.entity.AbstractNamedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


/**
 * 客户端渠道信息
 *
 * @author wxup
 * @create 2018-06-09 20:23
 **/

@Entity
@Desc("客户端渠道信息")
@Table(name = "t_client_channel")
@Data
@EqualsAndHashCode(of = {"code"})
public class ClientChannel extends AbstractNamedEntity<Long> {

    @Desc("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Desc("渠道编号")
    @Column(name = "code", length = 64,unique = true)
    private String code;

    @Desc("渠道名称")
    @Column(name = "`name`", nullable = false, length = 128)
    private String name;

    @Desc("排序")
    @Column(name = "`sort`", nullable = false)
    private Short sort;

    @Desc("是否启用")
    @Column(name = "`enabled`", nullable = false)
    private Boolean enabled;

    @Desc("创建日期")
    @Column(name = "add_time", nullable = false, length = 19)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;

    public ClientChannel(String code) {
        this.code = code;
    }
}
