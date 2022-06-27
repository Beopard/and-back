package com.example.anonymousboard.mapper;

import com.example.anonymousboard.data.Post;
import com.example.anonymousboard.data.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //    전체 게시글 조회(최신순)
    @Select("select * from post order by created_time desc")
    public List<Post> selectAllPosts();

    // 로그인시 유저조회
    @Select("select * from users where user_id= #{user_id}")
    public Users selectUser(String user_id);

    //이름으로 조회
    @Select("select * from users where name=#{name}")
    public Users selectUserByName(String name);

    // 전체 유저조회
    @Select("select * from users")
    public List<Users> selectAllUsers();

}
