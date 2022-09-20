package com.boot.mvc20220916mungi.web.dto;

import lombok.Builder;
import lombok.Data;

/*
2교시 실습
 */
@Builder
@Data //data어노테이션 역할은 게터세터인가?
public class StudentRespDto {
    private String studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;


}
