package com.boot.mvc20220916mungi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
/*
Dto에는 항상 최소한의 코드?만 저장 Dto 공부하기
 */
@AllArgsConstructor //AllArgsConstructor 사용해서 생성될때 notNull되나??
@Getter             //와일드카드 사용해서 데이터 타입의 자유화
public class CMRespDto<T> {
    private int code;       //1: 성공 -1: 실패
    private String msg;     //commit 메세지
    private T data;         //응답 data

}
