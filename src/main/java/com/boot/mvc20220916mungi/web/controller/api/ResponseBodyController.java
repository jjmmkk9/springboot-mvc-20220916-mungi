package com.boot.mvc20220916mungi.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //restController로 해주면 responseBody가 붙어있는 걸로 퉁침
public class ResponseBodyController {

//    Logger logger = LoggerFactory.getLogger(getClass()); 매번 타이핑 치기 귀찮으니까 @Slf4j

    /*
    매개변수에 @requestParam 써줘서 parameter로 받는 방법
    /api/text?value=스프링부트 api 테스트&num=1000

     */
    @GetMapping("/api/text")
    public String textGetReq(@RequestParam String value, int num){
        return "파라미터 값: " + value + "," + num;
        
    }

/*
! post 요청 !
post요청은 param 아니다 body다..
 */
    
    @PostMapping("/api/text")  //post요청 근데 위에 매핑이랑 똑같아도되나? - 된다~ 메소드가 다르면 된다
    public String textPostReq(@RequestParam String name, int age){
        log.info("name: {}", name);
        log.info("age: {}", age);
        return "name: " + name + ", age: " + age;
    }

    
    @PutMapping("/api/text")
    public String textPutReq(){
        log.info("put Request!!");
        return "풋! 요청에 대한 응답";
    }

    
    @DeleteMapping("/api/text")
    public String textDeleteReq(){
        log.info("delete request");
        return "delete 요청에 대한 응답";
    }
}
