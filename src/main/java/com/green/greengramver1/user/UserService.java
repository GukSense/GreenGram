package com.green.greengramver1.user;

import com.green.greengramver1.common.model.CustomFileUtils;
import com.green.greengramver1.user.model.SignInPostReq;
import com.green.greengramver1.user.model.SignInRes;
import com.green.greengramver1.user.model.SignUpPostReq;
import com.green.greengramver1.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional //
    public int userPost(MultipartFile pic, SignUpPostReq p) {

        //프로필 이미지 파일 처리
        String saveFilName = customFileUtils.makeRandomFileName(pic);
        p.setPic(saveFilName);
        log.info("save: {}",saveFilName);
        String hashpw = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        log.info("hashpw: {}",hashpw);
        p.setUpw(hashpw);

        int result = mapper.userPost(p);

        if(pic == null) { return result; }

        try {   //경로생성, 폴더생성, 타겟지정, 생성.
            String path = String.format("user/%d", p.getUserId());
            customFileUtils.makeFolders(path);
            String target = String.format("user/%d/%s", p.getUserId(), saveFilName);
            customFileUtils.transferTo(pic, target);

            log.info("path: {}", path);
            log.info("target: {}", target);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("파일오류");
        }
        return result;
    }

    public SignInRes postSignIn(SignInPostReq p) {
        User getUser = mapper.getUserById(p.getUid());

        if (getUser == null) {
            throw new RuntimeException("아이디를 확인해 주세요.");
        } else if(!BCrypt.checkpw(p.getUpw(), getUser.getUpw())) {
            throw new RuntimeException("비밀번호를 확인해 주세요.");
        }

        return SignInRes.builder()
                .userId(getUser.getUserId())
                .nm(getUser.getNm())
                .pic(getUser.getPic())
                .build();
    }

}
