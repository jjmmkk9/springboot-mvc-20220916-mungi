package com.boot.mvc20220916mungi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Getter             //와일드카드? 머였더라 
public class CMRespDto<T> {
    private int code;       //1: 성공 -1: 실패
    private String msg;     //commit 메세지
    private T data;         //응답data

}
