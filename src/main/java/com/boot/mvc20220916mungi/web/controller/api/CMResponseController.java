package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.CMRespDto;
import com.boot.mvc20220916mungi.web.dto.StudentRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/*
커밋메세지를 달아서 데이터 보내는게 CMReponse
프론트엔드한테 데이터 공유할 때 쓰는 것!!
 */
@RestController
public class CMResponseController {

    @GetMapping("/api/v1/cm/data1")
    public CMRespDto<?> getData(){

        return new CMRespDto<String>(1, "데이터응답 성공", "테스트 데이터");
    }
    @GetMapping("/api/v1/cm/data2")
    public CMRespDto<?> getData2(){

        return new CMRespDto<Boolean>(-1, "데이터응답 실패", false);
    }

    @GetMapping("/api/v1/cm/data3")
    public CMRespDto<?> getData3(){
        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
        //학생 코드만 4개 생성
        dtoList.add(StudentRespDto.builder().studentCode("1").build());
        dtoList.add(StudentRespDto.builder().studentCode("2").build());
        dtoList.add(StudentRespDto.builder().studentCode("3").build());
        dtoList.add(StudentRespDto.builder().studentCode("4").build());
                            //비워두면 알아서 자료형 인식함
        return new CMRespDto<>(1, "학생 정보 리스트 데이터입니다.", dtoList);
    }
}
