package com.green.greengramver1.user;

import com.green.greengramver1.user.model.SignInPostReq;
import com.green.greengramver1.user.model.SignInRes;
import com.green.greengramver1.user.model.SignUpPostReq;
import com.green.greengramver1.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userPost(SignUpPostReq p);

    User getUserById(String p);
    SignInRes postSignIn(SignInPostReq p);
}
