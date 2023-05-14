package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "뀨 ( •̀ ω •́ )✧!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    /** MVC 템플릿 엔진 **/
    public String helloMvc(@RequestParam("name") String name, Model model) { //웹에서 매개변수 받아오기
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서의 body 부분에 데이터를 직접 넣어주겠다는 의미의 애너테이션
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }


    @GetMapping("hello-api") /** API **/
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //String 값이 아니라 객체인 경우 Default 로 api 방식으로 json 넘겨줌
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
 