package com.example.anonymousboard.controller;

import com.example.anonymousboard.data.Post;
import com.example.anonymousboard.mapper.PostMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    final
    PostMapper postMapper;

    public ApiController(PostMapper postMapper) {
        this.postMapper = postMapper;
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
    @GetMapping("/postsT")
    public List<Post> getPostsT() {
        return postMapper.selectAllPostsOrderByTime();
    }

    // 게시글 검색
    @GetMapping("/postSearch")
    public List<Post> getPostsBySearch(@RequestParam String title) {
        return postMapper.selectPostsByTitle("%" + title + "%");
    }

    // 게시글조회
    @GetMapping("/post/{post_id}")
    public Post getpost(@PathVariable("post_id") String post_id) {
        return postMapper.selectPost(post_id);
    }

    // 게시글등록
    @PostMapping("/post")
    public void insertPost(@RequestParam String title,
                           @RequestParam String contents,
                           @RequestParam String password) {
         postMapper.insertPost(title, contents, password);
    }

    // 게시글수정
    @PutMapping("/post")
    public void updatePost(@RequestBody Post post) {
        if (postMapper.selectPost(post.getPost_id()).getPassword().equals(post.getPassword())) {
            postMapper.updatePost(post);
        }
    }

    // 게시글삭제
    @DeleteMapping("post/{post_id}")
    public void deletePost(@PathVariable("post_id") String post_id,
                           @RequestParam String password) {
        if (postMapper.selectPost(post_id).getPassword().equals(password)) {
            postMapper.deletePost(post_id);
        }
    }

}
