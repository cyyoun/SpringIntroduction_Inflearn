package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자에 Autowired가 되어 있으면 스프링이 memberService를 알아서 맵핑해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //GetMapping 조회할 때 사용
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping("/members/new") //PostMapping 데이터를 전달할 때 사용
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
