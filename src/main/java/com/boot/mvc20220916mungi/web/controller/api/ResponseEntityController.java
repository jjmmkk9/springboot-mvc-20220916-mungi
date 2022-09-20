package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.CMRespDto;
import com.boot.mvc20220916mungi.web.dto.StudentRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
ResponseEntity는 body 자료형에 따라서 json이될지 일반 텍스트가 될지 결정된다!
ResponseEntity는 데이터와 httpStatus를 같이 보내줄수 있는 응답!
앞으로는 무조건 RestController 는 ResponseEntity로 해줄것
 */
@RestController
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData(){
                                        /*
                                        응답 코드까지 우리가 제어할 수 있다.
                                        HttpStatus.BAD_REQUEST      400 Bad Request
                                        HttpStatus.OK               200 OK
                                        .INTERNAL_SERVER_ERROR      500 Internal server error
                                         */
        return new ResponseEntity<String>("ResponseEntity 응답", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/v1/entity/data2")
    public ResponseEntity<?> getData2(){

        MultiValueMap<String, String> headers = new HttpHeaders();
        //응용해서 header에 데이터를 넣어놓고 쓸 수도 있는 것이다. 
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        return new ResponseEntity<>
                //body에 Json으로 날라옴
                (new CMRespDto<>(1,"전송 성공", "테스트데이터"),
                headers,
                HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaa111");
                //Entity.ok.headers.body -> 순서
        return ResponseEntity.ok()
                .headers(headers)
                .body(new CMRespDto<>(1,"ok안에 메세지","test!"));
    }

    @GetMapping("/api/v1/test/students")
    public ResponseEntity<?> getData6(){
        
        HttpHeaders headers = new HttpHeaders();
        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
            dtoList.add(StudentRespDto.builder().studentCode("20220001").build());
            dtoList.add(StudentRespDto.builder().studentCode("20220002").build());
            dtoList.add(StudentRespDto.builder().studentCode("20220003").build());
            dtoList.add(StudentRespDto.builder().studentCode("20220004").build());
            
            //StringBuilder를 만들어서 하나씩 빼면서 ", "append 같이 해줌 그리고 delete로 마지막 ", "삭제
            StringBuilder studentCodeList = new StringBuilder();
            for(StudentRespDto studentRespDto : dtoList){
                studentCodeList.append(studentRespDto.getStudentCode());
                studentCodeList.append(", ");
            }//마지막 ", "delete하는 법
            studentCodeList.delete(studentCodeList.length() -2, studentCodeList.length());
            
            headers.add("student_code_list", studentCodeList.toString());

//            이렇게 하거나 밑에걸로 하거나
//        return ResponseEntity
//                .status(HttpStatus.METHOD_NOT_ALLOWED)
//                .headers(headers)
//                .body(new CMRespDto<>(-1,"HTTP 메소드를 확인해 주세요.",dtoList));
        
        return new ResponseEntity<>(
                new CMRespDto<>(-1,"HTTP 메소드를 확인해주세요.", dtoList),
                headers,
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }
}
