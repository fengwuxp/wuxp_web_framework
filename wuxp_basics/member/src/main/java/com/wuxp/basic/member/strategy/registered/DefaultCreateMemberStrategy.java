package com.wuxp.basic.member.strategy.registered;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wuxp.basic.member.dto.DefaultCreateMemberReq;
import com.wuxp.basic.member.dto.MemberInfo;
import com.wuxp.basic.member.entities.Member;
import com.wuxp.basic.member.entities.QMember;
import com.wuxp.basic.member.repositories.MemberRepository;
import com.wuxp.basic.member.strategy.CreateMemberStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 默认的用户创建策略
 */
@Component
@Slf4j
@Transactional
public class DefaultCreateMemberStrategy implements CreateMemberStrategy<MemberInfo, DefaultCreateMemberReq> {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public MemberInfo create(DefaultCreateMemberReq request) {


        QMember qMember = QMember.member;

        //查询用户是否存在
        Member fetchOne = jpaQueryFactory.selectFrom(qMember)
                .where(
                        qMember.mobilePhone.eq(request.getMobilePhone())
                ).fetchOne();

        Member member = new Member();

        Member result = memberRepository.save(member);

        return null;
    }
}
