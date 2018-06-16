package com.wuxp.common.core.enums;

import com.wuxp.common.annotation.Desc;
import javafx.util.Pair;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 可描述枚举的的帮助者，用于获取枚举注解上的值
 *
 * @author wxup
 * @create 2018-06-08 22:39
 **/
public final class DescriptiveEnumHelper {

    private static final Map<Class<? extends Enum>, Pair<String/*enum value*/, String/*enum desc*/>[]> ENUM_DESC_MAP = new ConcurrentHashMap<>();

    static {

        //TODO 通过包扫描的方式在spring 初始化的后将所有的枚举put到Map中

    }

    /**
     * 获取枚举的描述信息
     *
     * @param e 枚举对象实例
     * @return 枚举描述
     */
    public static String getEnumDesc(Enum<?> e) {
        Pair<String, String>[] pairs = ENUM_DESC_MAP.get(e.getClass());
        if (pairs == null) {
            pairs = DescriptiveEnumHelper.putEnum(e);
        }
        for (Pair<String, String> pair : pairs) {
            if (pair.getKey().equals(e.name())) {
                return pair.getValue();
            }
        }
        return null;
    }


    /**
     * put 一个枚举到map中
     *
     * @param e 枚举实例
     * @return Pair<String ,   String>[]
     */
    private static Pair<String, String>[] putEnum(Enum<?> e) {
        Class<? extends Enum> clazz = e.getClass();
        Enum[] enumConstants = clazz.getEnumConstants();
        int length = enumConstants.length;
        final Pair<String, String>[] pairs = new Pair[length];

        for (int i = 0; i < length; i++) {
            Enum en = enumConstants[i];
            String name = en.name();
            Field field = null;
            try {
                field = clazz.getField(name);
            } catch (NoSuchFieldException e1) {
                throw new RuntimeException("枚举" + clazz.getName() + "上未存在" + name + "属性", e1);
            }
            Desc desc = field.getAnnotation(Desc.class);
            assert desc != null;
            Pair<String, String> pair = new Pair<>(name, desc.value());
            pairs[i] = pair;
        }
        ENUM_DESC_MAP.put(clazz, pairs);
        return pairs;

    }
}
