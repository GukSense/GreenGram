package com.green.greengramver1.user;

import com.green.greengramver1.common.model.ResultDto;
import com.green.greengramver1.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "유저 컨트롤러", description = "유저 CRUD, sign-in, sign-out")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입", description = "프로필 사진은 필수는 아님")
    public ResultDto<Integer> postSignUp(@RequestPart(required = false) MultipartFile pic,
                                         @RequestPart SignUpPostReq p) {

        log.info("pic: {}", pic);
        log.info("p: {}", p);

        int result = service.userPost(pic, p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입 성공")
                .resultData(result).build();
    }

    @PostMapping("sign-in")
    @Operation(summary = "인증처리", description = "")
    public ResultDto<SignInRes> postSignIn(@RequestBody SignInPostReq p) {
        log.info("p: {}", p);
        SignInRes result = service.postSignIn(p);
        System.out.println(result);
        return ResultDto.<SignInRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("인증 성공")
                .resultData(result)
                .build();

    }

}
