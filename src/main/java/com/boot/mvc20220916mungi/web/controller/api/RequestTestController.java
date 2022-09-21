package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.AddPostReqDto;
import com.boot.mvc20220916mungi.web.dto.CMRespDto;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
1교시 실습
@RequestParam 으로 받아서 CMRespDto 써서 데이터 객체 안에 해당 값들이 들어있어야한다
포스트맨 완성 예제
{
    "code": 1,
    "msg": "게시글 작성 완료",
    "data": {
        "writer": "조문기",
        "title": "글 제목",
        "content": "글 내용"
    }
}
 */
@Slf4j
@RestController
public class RequestTestController {
    //이따구로 해도 되나? 싶음 - 내가 한거 Controller에다가 글 제목 요따구로 초기화해놓고 post메소드에서 갖다 쓴거 -> 걍 이건 내가 쓴거 잖어
    //너무 바보~
//    private String title = "글 제목";
//    private String writer = "조문기";
//    private String content = "글 내용";

//    @PostMapping("api/v1/rp/post")
//    public CMRespDto<?> postData(@RequestParam String title,
//                                 @RequestParam String  writer,
//                                 @RequestParam String content){
//        RequestTestController requestTestController = new RequestTestController();
//        Map<String ,Object> map = new HashMap<>();
//        map.put("title",requestTestController.getTitle());
//        map.put("writer",requestTestController.getWriter());
//        map.put("content",requestTestController.getContent());
//        return new CMRespDto<>(1, "게시글 작성 완료", map);

    //정답 - requestParam
    @PostMapping("api/v1/rp/post")
    public ResponseEntity<?> addPost(@RequestParam String title,
                                      @RequestParam String  writer,
                                      @RequestParam String content) {
        Map<String ,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("writer",writer);
        map.put("content",content);
        return ResponseEntity.ok(new CMRespDto<>(1, "게시글 작성 완료", map));

    }
    //정답 - dto 사용
    @PostMapping("api/v1/dto/post")
    public ResponseEntity<?> addPost(AddPostReqDto addPostReqDto){
        log.info("{}", addPostReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1,"게시글 작성 완료", addPostReqDto));
    }
}
