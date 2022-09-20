package com.boot.mvc20220916mungi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/*
@Controller의 원래 형태는 @Component 였다.
기존에(Di) 우리는 생성된 객체를 변수에 넣어줬다. 그러나 IOC 는 제어의 역전 이라는 뜻으로 메소드나
객체의 호출 작업을 개발자가 결정하는 것이 아니라, 외부에서 결정되는 것을 의미한다.
객체의 의존성을 역전시켜 객체 간의 결합도를 줄이고 유연한 코드를 작성 할 수 있게 하여 가독성 및 코드 중복
유지보수를 편하게 한다.

 */
@Controller
public class PageController {

    /*
    index연결하기
    controller는 어노테이션으로 표시해주기
    getMapping은 받는 mapping주소가 들어오면 메소드실행시키는 아이
     */
@GetMapping({"/","/index"})
    public String loadindex(Model model) {
        model.addAttribute("name","조문기");
        return "index";
        //모델, 뷰 채워서 view resolver한테 보냄~ view resolver는 prefix""suffix 합쳐서 view찾아감

}
@GetMapping("/helloboot")
    public String loadHelloBoot(Model model){
        model.addAttribute("nowDate", LocalDateTime.now());
        return "hello";
}

/*
myInfo.html이랑 연결하는 메소드
Model이용해서 addAttribute로 html에서 value 넘겨받을수 있게 해줌~
html에서 thhymeleaf 설정해주기~~
 */
@GetMapping("/myinfo")
    public String loadInfo(Model model) {
    model.addAttribute("name","조문기");
    model.addAttribute("age","24");
    model.addAttribute("phone","010-4717-8209");
    model.addAttribute("address","김해시 봉황동");
    return "myInfo";
}

/*
! post요청 !

 */

}
