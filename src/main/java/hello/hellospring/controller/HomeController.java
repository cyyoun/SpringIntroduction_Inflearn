package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; //home.html 이 없으면 index.html 을 화면에 띄워줌 (우선순위 있음)

    }
}
