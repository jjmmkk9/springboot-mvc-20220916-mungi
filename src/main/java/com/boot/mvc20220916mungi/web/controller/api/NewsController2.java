package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.AddNewsReqDto;
import com.boot.mvc20220916mungi.web.dto.AddNewsReqDto2;
import com.boot.mvc20220916mungi.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Multicast;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class NewsController2 {

    @PostMapping("/api/news/6")
    public ResponseEntity<?> postNews(AddNewsReqDto2 addNewsReqDto2){
        log.info("{}",addNewsReqDto2);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title",addNewsReqDto2.getTitle());
        map.put("broadcastingName",addNewsReqDto2.getBroadcastingName());
        map.put("content", addNewsReqDto2.getContent());

        List<String > fileNameList = new ArrayList<>();
        for(MultipartFile file : addNewsReqDto2.getFiles()){
            fileNameList.add(file.getOriginalFilename());
        }
        map.put("files", fileNameList);


        return ResponseEntity.ok(new CMRespDto<>(1, "news 폼 업로드 완료", map));
    }






}
