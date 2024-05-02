package com.green.greengramver1.user;

import com.green.greengramver1.user.model.SignUpPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userPost(SignUpPostReq p);
}
