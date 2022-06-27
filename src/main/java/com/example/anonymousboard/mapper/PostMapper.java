package com.example.anonymousboard.mapper;

import com.example.anonymousboard.data.Post;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    //    전체 게시글 조회(최신순)
    @Select("select post_id, title, contents, created_time, views,  pro_views, recommends, name from post p,users u where u.user_id=p.user_id order by created_time desc")
    public List<Post> selectAllPosts();

    // 게시글 상세 조회
    @Select("select  title, contents, created_time, name from post p,users u where u.user_id = p.user_id and post_id=#{id}")
    public Post selectPost(String id);

    // 게시글 추천


    //    전체 게시글 조회(조회수 순)
    @Select("select * from post order by views desc")
    public List<Post> selectAllPostsOrderByViews();


    //    게시글 등록
    @Insert("insert into post(title, contents, user_id)  values(#{title},#{contents},#{user_id})")
    public void insertPost(String title, String contents, String user_id);

    //    게시글 수정
    @Update("update post set title = #{title}, contents = #{contents} where post_id = #{post_id}")
    public void updatePost(String post_id, String title, String contents);

    //    게시글 삭제
    @Delete("delete from post where post_id=#{post_id}")
    public void deletePost(String post_id);


    //    조회수 증가
    @Update("update post set views = views+1 where post_id = #{post_id}")
    public void updateViews(String post_id);

    //   전문가 조회수 증가
    @Update("update post set pro_views = pro_views+1 where post_id = #{post_id}")
    public void updateProViews(String post_id);

    //   추천 증가
    @Update("update post set recommends = recommends+1 where post_id = #{post_id}")
    public void updateRecommends(String post_id);






}
