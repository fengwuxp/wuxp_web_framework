package com.wuxp.shop.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1368762208L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final com.wuxp.shop.common.domain.entity.QAbstractBaseEntity _super = new com.wuxp.shop.common.domain.entity.QAbstractBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Short> age = createNumber("age", Short.class);

    public final com.wuxp.shop.system.entities.QArea area;

    public final StringPath areaId = createString("areaId");

    public final StringPath avatarUrl = createString("avatarUrl");

    //inherited
    public final DateTimePath<java.util.Date> createTime = _super.createTime;

    public final StringPath email = createString("email");

    public final BooleanPath enable = createBoolean("enable");

    public final DateTimePath<java.util.Date> frozenDate = createDateTime("frozenDate", java.util.Date.class);

    public final EnumPath<com.wuxp.shop.member.enums.Gender> gender = createEnum("gender", com.wuxp.shop.member.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath idAuth = createBoolean("idAuth");

    //inherited
    public final DateTimePath<java.util.Date> lastUpdateTime = _super.lastUpdateTime;

    public final QMemberSecure memberSecure;

    public final BooleanPath mobileAuth = createBoolean("mobileAuth");

    public final StringPath mobilePhone = createString("mobilePhone");

    public final StringPath nickName = createString("nickName");

    public final StringPath realName = createString("realName");

    public final DateTimePath<java.util.Date> regDateTime = createDateTime("regDateTime", java.util.Date.class);

    public final com.wuxp.shop.system.entities.QClientChannel regSource;

    public final StringPath userName = createString("userName");

    public final EnumPath<com.wuxp.shop.member.enums.MemberVerifyStatus> verify = createEnum("verify", com.wuxp.shop.member.enums.MemberVerifyStatus.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new com.wuxp.shop.system.entities.QArea(forProperty("area"), inits.get("area")) : null;
        this.memberSecure = inits.isInitialized("memberSecure") ? new QMemberSecure(forProperty("memberSecure"), inits.get("memberSecure")) : null;
        this.regSource = inits.isInitialized("regSource") ? new com.wuxp.shop.system.entities.QClientChannel(forProperty("regSource")) : null;
    }

}

