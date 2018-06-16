package com.wuxp.common.core.enums;


/**
 * 带描述的枚举，实现该接口的枚举都是可描述的
 *
 * @author wxup
 * @create 2018-06-08 21:58
 **/
public interface DescriptiveEnum {


    /**
     * 获取枚举值的描述
     *
     * @return String
     */
    default String getDesc() {
        return DescriptiveEnumHelper.getEnumDesc((Enum<?>) this);
    }


    /**
     * 通过枚举的描述获取枚举值
     *
     * @param desc 枚举描述
     * @return T
     */
    default <T extends Enum> T getValueByDesc(String desc) {

        if (desc == null || desc.trim().length() == 0) {
            return null;
        }

        DescriptiveEnum[] enums = this.getClass().getEnumConstants();

        for (DescriptiveEnum descriptiveEnum : enums)
            if (desc.equals(descriptiveEnum.getDesc())) {
                return (T) descriptiveEnum;
            }
        return null;
    }
}
