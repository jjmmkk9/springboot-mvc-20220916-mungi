package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.ResponseDataDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ResponseTestController {

    /*
    리턴이 html일 것이다. GetMapping에 return은 그냥 텍스트이니까 컨트롤러는 뷰리졸버한테 보내고
    뷰 리졸버가 파일명을 보고 경로를 찾는다. -> 뷰가 리스폰스 된다.
    우리가 데이터를 리스폰스할 때 responseBody를 꼭 붙여줘야지만 view말고 일반 데이터를 리스폰스한다.

    매번 ResponseBody 붙일빠에야 RestController로 바꿔주자
     */
    //@ResponseBody
    @GetMapping("/api/v1/data1")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("이름", "조문기");
        data.put("연락처", "010-4717-8209");
        return data;
        /*
        post man으로 get해보면 gson써서 toJson안해도
        responseBody가 달려있고 응답이 객체형태면 무조건 json으로 보내준다ㅜㅜ
        아래로 계속 테스트!
         */
    }


    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2() {
        return ResponseDataDto.builder()
                .value1("문자열")
                .value2(true)
                .value3(2022)
                .build();
    }


    @GetMapping("/api/v1/data3")
    public Object getData3() {
        //ResponseDataDto말고 리턴은 Object해줘도 됨
        return ResponseDataDto.builder()
                .value1("문자열2")
                .value2(false)
                .value3(2023)
                .build();
    }
}
