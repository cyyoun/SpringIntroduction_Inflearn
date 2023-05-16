package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자에 Autowired가 되어 있으면 스프링이 memberService를 알아서 맵핑해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
