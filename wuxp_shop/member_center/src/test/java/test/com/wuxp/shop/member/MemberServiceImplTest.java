package test.com.wuxp.shop.member;

import com.wuxp.shop.member.MemberApplication;
import com.wuxp.shop.member.entities.Member;
import com.wuxp.shop.member.enums.Gender;
import com.wuxp.shop.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 用户服务测试
 *
 * @author wxup
 * @create 2018-06-16 14:59
 **/
@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MemberApplication.class)
public class MemberServiceImplTest {


    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void testInsertMember() {

        Member entity = new Member();
        entity.setUserName("111");
        entity.setRealName("张三");
        entity.setAge(Short.valueOf("11"));
        entity.setAddress("天字一号店");
        entity.setEmail("111231@.qq.com");
        entity.setGender(Gender.FEMALE);
        Date date = new Date();
        entity.setRegDateTime(date);
        entity.setEnable(Boolean.TRUE);
        entity.setLastUpdateTime(date);
        entity.setCreateTime(date);
        entity.setIdAuth(false);
        entity.setMobileAuth(false);
        Member member = memberRepository.save(entity);

        assert member.getId() != null;
    }

}


