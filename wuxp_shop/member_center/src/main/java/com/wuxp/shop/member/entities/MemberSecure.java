package com.wuxp.shop.member.entities;


import com.wuxp.common.annotation.Desc;
import com.wuxp.shop.common.domain.entity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * 用户安全信息
 *
 * @author wxup
 * @create 2018-06-09 18:17
 **/
@Desc("用户安全信息")
@Data
@ToString(exclude = {"member"})
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "t_member_secure")
public class MemberSecure extends AbstractBaseEntity<Long> {

    private static final long serialVersionUID = -7638863164373869181L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Desc("会员ID")
    private Long id;

    @Desc("登录密码")
    @Column(name = "login_password", nullable = false, length = 128)
    private String loginPassword;

    @Desc("加密key")
    @Column(name = "password_key", length = 64)
    private String passwordKey;


    @Desc("支付密码")
    @Column(name = "pay_password", length = 128)
    private String payPassword;

    @Desc("最后登录时间")
    @Column(name = "last_login_time", length = 19)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;


    @Desc("最后登录IP")
    @Column(name = "last_login_ip", length = 16)
    private String lastLoginIp;

    @Desc("常用登录ip")
    @Column(name = "common_login_ip", length = 128)
    private String commonLoginIp;

    @Desc("常用登录地区")
    @Column(name = "common_login_area", length = 16)
    private String commonLoginArea;

    @Desc("会员")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Member member;


}
