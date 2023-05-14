package hello.hellospring.repository;


import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트가 끝나고 메모리를 clear 해줘야 메서드 순서와 상관없이 정상 수행 가능해짐
    public void afterEach() {
        repository.clearStore();

    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("cyyoun");


        repository.save(member);

        Member result = repository.findById(member.getId()).get();

//        System.out.println("result =" + (result == member));

//        Assertions.assertEquals(member, result); //기대하는 것을 앞 순서에 기재

        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("차정두");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("공서현");
        repository.save(member2);

        Member result = repository.findByName("차정두").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("차정두");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("공서현");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
