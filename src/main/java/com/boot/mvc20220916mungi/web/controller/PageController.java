package com.boot.mvc20220916mungi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/*
Model 사용해서 html에서 변수처럼 사용할 수 있게 하기
model.addAttribute(attributeName: "name", attributeValue: "조문기")
return에 있는 문자열과 동일한 파일명을 가진 html에 thhymeleaf해주기 -> templates - html들에서 확인하자!
 */
@Controller
public class PageController {

    /*
    &문제
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
    &문제
    myInfo.html이랑 연결하는 메소드 만들기
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
