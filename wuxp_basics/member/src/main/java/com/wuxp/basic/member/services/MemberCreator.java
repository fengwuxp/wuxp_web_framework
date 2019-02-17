package com.wuxp.basic.member.services;


/**
 * 用户创建者
 */
public interface MemberCreator<M, T> {

    /**
     * 注册用户
     *
     * @param request
     * @return
     */
    M register(T request);
}

/**
 * 会员注册之前的一些处理器
 **/
interface MemberCreatePrevProcessor<T> {

    /**
     * 注册之前的处理
     * 可以对注册参数进行一些处理
     * @param request 注册请求参数
     */
    void process(T request);


}


/**
 * 会员注册之后的一些处理器
 **/
interface MemberCreatePostProcessor<M>{

    /**
     * 注册之后的一些处理
     * @param member
     */
    void postProcess(M member);
}