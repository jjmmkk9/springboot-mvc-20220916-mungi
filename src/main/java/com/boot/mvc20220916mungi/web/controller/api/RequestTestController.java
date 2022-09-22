package com.boot.mvc20220916mungi.web.controller.api;

import com.boot.mvc20220916mungi.web.dto.AddPostReqDto;
import com.boot.mvc20220916mungi.web.dto.CMRespDto;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    //내가 한거 Controller에다가 글 제목 요따구로 초기화해놓고 post메소드에서 갖다 쓴거 -> 걍 이건 내가 쓴거 잖어 너무 바보~
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
        //requestParam은
        Map<String ,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("writer",writer);
        map.put("content",content);
        return ResponseEntity.ok(new CMRespDto<>(1, "게시글 작성 완료", map));
    }

    //정답 - dto 사용, addPostReqDto 생성
    @PostMapping("api/v1/dto/post")
    public ResponseEntity<?> addPost(AddPostReqDto addPostReqDto){
        log.info("{}", addPostReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1,"게시글 작성 완료", addPostReqDto));
    }

    //파일로 보내기
    @PostMapping("/api/v1/file/post")
    public ResponseEntity<?> addPost2(AddPostReqDto addPostReqDto) {
        log.info("{}", addPostReqDto);
        List<String> fileNames = new ArrayList<String>();

            //fileName1 = getFile
        String fileName1 = addPostReqDto.getFile().getOriginalFilename();
        fileNames.add(fileName1);
            //files리스트가 null이 아니면
            //fileName2 = files[0].파일이름
            //fileName3 = files[1].파일이름
            //fileNames리스트에 차곡차곡 넣기
        if(addPostReqDto.getFiles() != null){
            String fileName2 = addPostReqDto.getFiles().get(0).getOriginalFilename(); //리스트라서 index로 들고와서 파일이름을 들고온다.
            String fileName3 = addPostReqDto.getFiles().get(1).getOriginalFilename();
            fileNames.add(fileName2);
            fileNames.add(fileName3);
        }
                                                                        //return 바디는 fileNames리스트
        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", fileNames));
    }

    //json으로 보내기
    @PostMapping("api/v1/json/post") //요청시 들어오는 body 달아줘야 json으로 받을수 있다. json만! requestbody붙인다.
    public ResponseEntity<?> addPost3(@RequestBody AddPostReqDto addPostReqDto){
        log.info("{}", addPostReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1,"Json으로 게시글 작성 완료", addPostReqDto));
    }



    /*
     /api/v1/post/1(번 게시글 지워라) => {
            "code": 1,
            "msg": "삭제성공",
            "data": 1}
    */
    @DeleteMapping("/api/v1/post/{id}") //PathVariable은 번호가 많이 쓰임 (페이지번호 등)
    public ResponseEntity<?> deletePost(@PathVariable int id){
        log.info("삭제할 게시글 번호: ({})", id);
        return ResponseEntity.ok(new CMRespDto<>(1,"삭제성공",id));
    }
}
