package com.wuxp.basic.system.entities;

import com.wuxp.basic.common.domain.entity.AbstractNamedEntity;
import com.wuxp.common.annotation.Desc;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;


/**
 * 客户端渠道信息
 *
 * @author wxup
 * @create 2018-06-09 20:23
 **/


@Data
@EqualsAndHashCode(of = {"code"}, callSuper = false)
@Desc("客户端渠道信息")
@Accessors(chain = true)
@ToString()
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_client_channel")
public class ClientChannel extends AbstractNamedEntity<Long> {

    private static final long serialVersionUID = -2401779926286284665L;
    @Desc("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Desc("渠道编号")
    @Column(name = "code", length = 64,unique = true)
    private String code;

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
