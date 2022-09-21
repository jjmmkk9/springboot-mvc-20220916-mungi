package com.boot.mvc20220916mungi.web.dto;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
public class AddPostReqDto {
    private String title;
    private String writer;
    private String content;
}
