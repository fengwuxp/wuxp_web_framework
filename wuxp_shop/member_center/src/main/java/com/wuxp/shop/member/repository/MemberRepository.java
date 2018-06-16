package com.wuxp.shop.member.repository;

import com.wuxp.shop.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;

/**
 * member reository
 *
 * @author wxup
 * @create 2018-06-16 12:03
 **/
public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Long> {
}
