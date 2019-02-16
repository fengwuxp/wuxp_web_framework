package com.wuxp.shop.member.entities;

import com.wuxp.common.annotation.Desc;
import com.wuxp.shop.common.domain.entity.AbstractDateVersionEntity;
import com.wuxp.shop.member.enums.Gender;
import com.wuxp.shop.member.enums.MemberVerifyStatus;
import com.wuxp.shop.system.entities.Area;
import com.wuxp.shop.system.entities.ClientChannel;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户
 *
 * @author wxup
 * @create 2018-06-09 18:17
 **/

@Desc("用户信息")
@Data
@ToString(exclude = {"memberSecure"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Accessors(chain = true)
@Entity
@Table(name = "t_member")
public class Member extends AbstractDateVersionEntity<Long> {


    private static final long serialVersionUID = 5776744718384493872L;

    @Desc("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Desc("真实姓名")
    @Column(name = "real_name")
    private String realName;

    @Desc("用户名")
    @Column(name = "user_name", nullable = false, length = 32)
    private String userName;

    @Desc("昵称")
    @Column(name = "nick_name", length = 64)
    private String nickName;

    @Desc("手机号码")
    @Column(name = "mobile_phone", nullable = false, length = 11)
    private String mobilePhone;

    @Desc("邮箱")
    @Column(name = "email", length = 64)
    private String email;

    @Desc("头像")
    @Column(name = "avatar_url", length = 64)
    private String avatarUrl;

    @Desc("age")
    @Column(name = "age", length = 3)
    private Short age;

    @Desc("性别")
    @Column(name = "gender", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Desc("所在区域行政编码")
    @Column(name = "area_id", length = 50)
    private String areaId;

    @Desc("所在区域")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", insertable = false, updatable = false)
    private Area area;

    @Desc("地址")
    @Column(name = "address", length = 128)
    private String address;

    @Desc("手机认证")
    @Column(name = "mobile_auth", nullable = false)
    private Boolean mobileAuth;

    @Desc("实名认证")
    @Column(name = "id_auth", nullable = false)
    private Boolean idAuth;


    @Desc("注册来源")
    @JoinColumn(name = "reg_source", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ClientChannel regSource;

    @Desc("审核状态")
    @Enumerated(EnumType.STRING)
    @Column(name = "verify", nullable = false, length = 16)
    private MemberVerifyStatus verify;

    @Desc("是否启用")
    @Column(name = "enable", nullable = false)
    private Boolean enable;

    @Desc("封闭到期时间")
    @Column(name = "frozen_date", length = 19)
    @Temporal(TemporalType.TIMESTAMP)
    private Date frozenDate;

    @Desc("注册时间")
    @Column(name = "reg_date_time", nullable = false, length = 19)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDateTime;

    @Desc("安全信息")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
    private MemberSecure memberSecure;
}
