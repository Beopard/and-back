package com.example.anonymousboard.controller;

import com.example.anonymousboard.data.Post;
import com.example.anonymousboard.data.Users;
import com.example.anonymousboard.mapper.PostMapper;
import com.example.anonymousboard.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    final
    PostMapper postMapper;
    final
    UserMapper userMapper;

    public ApiController(PostMapper postMapper, UserMapper userMapper) {
        this.postMapper = postMapper;
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public String index() {
        return "indexzz";
    }

    // 전체 게시글 조회(최신순)
    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postMapper.selectAllPosts();
    }

    // 전체 게시글 조회(조회수 순)
    @GetMapping("/postsViews")
    public List<Post> getPostsViews() {
        return postMapper.selectAllPostsOrderByViews();
    }


    // 게시글조회
    @GetMapping("/posts/{post_id}")
    public Post getpost(@PathVariable("post_id") String post_id,
                        @RequestParam("user_id") String user_id) {
        Users user = userMapper.selectUserByName(user_id);
        if(user.getRole().equals("전문가")){
            postMapper.updateProViews(post_id);
        }else{
            postMapper.updateViews(post_id);
        }
        return postMapper.selectPost(post_id);
    }

    //추천증가
    @PutMapping("/post/{post_id}")
    public void updateRecommends(@PathVariable("post_id") String post_id){
        postMapper.updateRecommends(post_id);
    }

    // 게시글등록
    @PostMapping("/post")
    public String insertPost(@RequestParam String title,
                           @RequestParam String contents,
                           @RequestParam String user_id) {
        Users user = userMapper.selectUserByName(user_id);
        System.out.println(user);
         postMapper.insertPost(title, contents, user.getUser_id());
         return "등록성공";
    }


    // 게시글삭제
    @DeleteMapping("post/{post_id}")
    public String deletePost(@PathVariable("post_id") String post_id)
                            {
        postMapper.deletePost(post_id);
        return "삭제성공";
    }

    @GetMapping("/login")
    public String login(@RequestParam String user_id,
                        @RequestParam String password){
        Users user = userMapper.selectUser(user_id);

        if(user.getPassword().equals(password)){
            return user.getName();
        }else{
            return null;
        }
    }
    @GetMapping("/users")
    public List<Users> users(){
        return userMapper.selectAllUsers();
    }

}
