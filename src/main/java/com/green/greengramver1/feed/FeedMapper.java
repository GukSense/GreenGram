package com.green.greengramver1.feed;

import com.green.greengramver1.feed.model.FeedGetReq;
import com.green.greengramver1.feed.model.FeedGetRes;
import com.green.greengramver1.feed.model.FeedPicPostDto;
import com.green.greengramver1.feed.model.FeedPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int postFeed(FeedPostReq p);
    List<String> getFeedPicsByFeedId(long feedId);
    List<FeedGetRes> getFeed(FeedGetReq p);
    int postFeedPics(FeedPicPostDto p);
}
