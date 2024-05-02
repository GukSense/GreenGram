package com.green.greengramver1.user;

import com.green.greengramver1.user.model.SignUpPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int userPost(MultipartFile pic, SignUpPostReq p) {
        //프로필 이미지 파일 처리

        return mapper.userPost(p);
    }
}
