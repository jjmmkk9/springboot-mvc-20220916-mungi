package com.boot.mvc20220916mungi.web.dto;

import lombok.Builder;
import lombok.Data;

/*
2교시 실습
 */
@Builder
@Data
public class StudentRespDto {
    private String studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;


}
