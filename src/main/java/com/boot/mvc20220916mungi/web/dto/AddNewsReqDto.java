package com.boot.mvc20220916mungi.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddNewsReqDto {
    private String title; //
    private String broadcastingName; //<input>
    private List<MultipartFile> files; //<input>
    private String content; //<text area>
}
