package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; //home.html 이 없으면 index.html 을 화면에 띄워줌 (우선순위 있음)
    }




}
