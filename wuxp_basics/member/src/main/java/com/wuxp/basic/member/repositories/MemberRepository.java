package com.wuxp.basic.member.repositories;

import com.wuxp.basic.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


/**
 * member repositories
 *
 * @author wxup
 * @create 2018-06-16 12:03
 **/
public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Long> {

}
