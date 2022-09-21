package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.StudentRespDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentDataController {

    List<StudentRespDto> studentList = new ArrayList<StudentRespDto>();
    Map<String, List<StudentRespDto>> listMap = new HashMap<String, List<StudentRespDto>>();
    @GetMapping("/api/v1/students")
    public Map<String, List<StudentRespDto>> getStudents(){
        StudentRespDto s1 = StudentRespDto.builder()
                .studentCode("20220001")
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산 진구")
                .studentPhone("010-9988-1916")
                .build();
        StudentRespDto s2 = StudentRespDto.builder()
                .studentCode("20220002")
                .studentName("김준이")
                .studentYear(4)
                .studentAddress("부산 동래구")
                .studentPhone("010-9999-1234")
                .build();
        studentList.add(s1);
        studentList.add(s2);

        listMap.put("students",studentList);

        return listMap;
    }

    public static void main(String[] args) throws JsonProcessingException {
        StudentDataController controller = new StudentDataController();
        Map<String,?> result = controller.getStudents();
        //object -> Json
        ObjectMapper objectMapper = new ObjectMapper();
        String mapJson = objectMapper.writeValueAsString(result);

        System.out.println(mapJson);
    }
}
