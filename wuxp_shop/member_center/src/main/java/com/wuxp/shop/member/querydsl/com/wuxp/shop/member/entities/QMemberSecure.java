package com.wuxp.shop.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberSecure is a Querydsl query type for MemberSecure
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberSecure extends EntityPathBase<MemberSecure> {

    private static final long serialVersionUID = -1473059081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberSecure memberSecure = new QMemberSecure("memberSecure");

    public final com.wuxp.shop.common.domain.entity.QAbstractBaseEntity _super = new com.wuxp.shop.common.domain.entity.QAbstractBaseEntity(this);

    public final StringPath commonLoginArea = createString("commonLoginArea");

    public final StringPath commonLoginIp = createString("commonLoginIp");

    //inherited
    public final DateTimePath<java.util.Date> createTime = _super.createTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastLoginIp = createString("lastLoginIp");

    public final DateTimePath<java.util.Date> lastLoginTime = createDateTime("lastLoginTime", java.util.Date.class);

    //inherited
    public final DateTimePath<java.util.Date> lastUpdateTime = _super.lastUpdateTime;

    public final StringPath loginPassword = createString("loginPassword");

    public final QMember member;

    public final StringPath passwordKey = createString("passwordKey");

    public final StringPath payPassword = createString("payPassword");

    public QMemberSecure(String variable) {
        this(MemberSecure.class, forVariable(variable), INITS);
    }

    public QMemberSecure(Path<? extends MemberSecure> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberSecure(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberSecure(PathMetadata metadata, PathInits inits) {
        this(MemberSecure.class, metadata, inits);
    }

    public QMemberSecure(Class<? extends MemberSecure> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

