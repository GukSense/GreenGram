package com.green.greengramver1.user;

import com.green.greengramver1.common.model.ResultDto;
import com.green.greengramver1.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResultDto<Integer> postUser(@RequestPart(required = false) MultipartFile pic,
                                       @RequestPart SignUpPostReq p) {

        log.info("pic: {}",pic);
        log.info("p: {}", p);

        int result = service.userPost(pic, p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .msg("회원가입 성공")
                .result(result).build();
    }





}
