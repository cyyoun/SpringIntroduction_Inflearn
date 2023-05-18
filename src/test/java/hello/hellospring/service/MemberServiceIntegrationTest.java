package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional //DB에 있는 테스트 데이터를 롤백해줌 -> db에 테스트 한 데이터가 반영이 안되므로 반복해서 테스트 실행할 수 있음
class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository; //같은 인스턴스로 테스트하는 게 정확함(DI)


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("cyyoun3");

        //when
        long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }


    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("jdcha");

        Member member2 = new Member();
        member2.setName("jdcha2");

        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다..╰（‵□′）╯");


    }

}