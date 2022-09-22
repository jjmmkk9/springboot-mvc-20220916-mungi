package com.boot.mvc20220916mungi.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddNewsReqDto2 {
    private String title;
    private String broadcastingName;
    private List<MultipartFile> files;
    private String content;

}
