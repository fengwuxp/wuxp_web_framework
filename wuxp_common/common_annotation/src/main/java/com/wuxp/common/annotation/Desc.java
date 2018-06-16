package com.wuxp.common.annotation;

import java.lang.annotation.*;

/**
 * 用于描述类、方法、属性的作用
 *
 *  <p>被该注解标记的类可以用作文档输出，代码生成等</p>
 *
 * @author wxup
 * @create 2018-06-08 21:56
 **/
@Target({ElementType.PACKAGE, ElementType.TYPE,
        ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD,
        ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Desc {

    /**
     * 描述内容
     *
     * @return String
     */
    String value() default "";


}
