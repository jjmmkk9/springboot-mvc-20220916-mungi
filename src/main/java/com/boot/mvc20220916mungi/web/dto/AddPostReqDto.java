package com.boot.mvc20220916mungi.web.dto;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*
1교시 실습 dto
 */
@Data
public class AddPostReqDto {
    private String title;
    private String writer;
    private String content;
    //파일은 MultipartFile 자료형!
    private MultipartFile file;
    private List<MultipartFile> files;
}
