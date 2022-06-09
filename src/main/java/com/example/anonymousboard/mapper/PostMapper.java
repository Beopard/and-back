package com.example.anonymousboard.mapper;

import com.example.anonymousboard.data.Post;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    //    전체 게시글 조회(최신순)
    @Select("select * from post order by created_time desc")
    public List<Post> selectAllPosts();

    //    전체 게시글 조회(조회수 순)
    @Select("select * from post order by views desc")
    public List<Post> selectAllPostsOrderByTime();

    //    게시글 검색
    @Select("select * from post where title like #{title}")
    public List<Post> selectPostsByTitle(String title);

    //    게시글 등록
    @Insert("insert into post(title, contents, password)  values(#{title},#{contents},#{password})")
    public void insertPost(String title, String contents, String password);

    //    게시글 수정
    @Update("update post set title = #{title}, contents = #{contents} where post_id = #{post_id}")
    public void updatePost(Post post);

    //    게시글 삭제
    @Delete("delete from post where post_id=#{post_id}")
    public void deletePost(String post_id);

    //    게시글 조회
    @Select("select * from post where post_id=#{post_id}")
    public Post selectPost(String post_id);

}
