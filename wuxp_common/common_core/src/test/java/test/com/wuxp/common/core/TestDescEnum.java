package test.com.wuxp.common.core;

import com.wuxp.common.annotation.Desc;
import com.wuxp.common.core.enums.DescriptiveEnum;


/**
 * 测试可描述的枚举
 *
 * @author wxup
 * @create 2018-06-08 22:01
 **/
@Desc("测试枚举")
public enum TestDescEnum implements DescriptiveEnum {


    @Desc("测试")
    TEST,

    @Desc("坑")
    KEN;


    public static void main(String[] args) throws Exception {
        String desc = TestDescEnum.TEST.getDesc();
        TestDescEnum value = TestDescEnum.TEST.getValueByDesc(desc);
        System.out.println(value);

    }


}


