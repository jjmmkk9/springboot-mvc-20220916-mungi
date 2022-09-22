package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.AddNewsReqDto;
import com.boot.mvc20220916mungi.web.dto.AddPostReqDto;
import com.boot.mvc20220916mungi.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class NewsController {

    @PostMapping("/api/news/5")   //form데이터 받을수 있는 dto필요하겠죠
    public ResponseEntity<?> addNews(AddNewsReqDto addNewsReqDto){

        log.info("{}", addNewsReqDto);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("title",addNewsReqDto.getTitle());
        map.put("broadcastingName",addNewsReqDto.getBroadcastingName());
        map.put("content",addNewsReqDto.getContent());

        List<String> fileNameList = new ArrayList<String>();

        addNewsReqDto.getFiles().forEach((file) -> {
            fileNameList.add(file.getOriginalFilename());
        });
        map.put("fileNames", fileNameList);

        return ResponseEntity.ok(new CMRespDto<>(1,"뉴스등록 완료", map));
    }






}
