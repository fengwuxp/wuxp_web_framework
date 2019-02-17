//package test.com.wuxp.shop.member;
//
//import com.wuxp.shop.member.MemberApplication;
//import Member;
//import Gender;
//import MemberVerifyStatus;
//import MemberRepository;
//import com.wuxp.shop.system.entities.ClientChannel;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//
///**
// * 用户服务测试
// *
// * @author wxup
// * @create 2018-06-16 14:59
// **/
//@ActiveProfiles("local")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = MemberApplication.class)
////@Transactional()
//public class MemberServiceImplTest {
//
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//
//    @Test
//    public void testInsertMember() {
//
//        Member entity = new Member();
//        entity.setUserName("111");
//        entity.setRealName("张三");
//        entity.setAge(Short.valueOf("11"));
//        entity.setAddress("天字一号店");
//        entity.setEmail("111231@.qq.com");
//        entity.setGender(Gender.FEMALE);
//        Date date = new Date();
//        entity.setRegDateTime(date);
//        entity.setEnable(Boolean.TRUE);
//        entity.setLastUpdateTime(date);
//        entity.setCreateTime(date);
//        entity.setIdAuth(false);
//        entity.setMobileAuth(false)
//                .setMobilePhone("1981981313").setRegSource(new ClientChannel(
//                1L,
//                "test", Short.valueOf("1"),
//                false, new Date()))
//                .setVerify(MemberVerifyStatus.APPROVED);
//        Member member = memberRepository.save(entity);
//
//        assert member.getId() != null;
//    }
//
//}
//
//
