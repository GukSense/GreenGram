package com.green.greengramver1.feed.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
public class FeedGetRes {
    private long feedId;
    private long writerId;
    private String writerNm;
    private String writerPic;
    private String contents;
    private String locations;
    private String createdAt;

    private List<String> pics;

}
