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
    @GetMapping("/postsViews")
    public List<Post> getPostsViews() {
        return postMapper.selectAllPostsOrderByViews();
    }

    // 게시글 검색
    @GetMapping("/postSearch")
    public List<Post> getPostsBySearch(@RequestParam String title) {
        return postMapper.selectPostsByTitle("%" + title + "%");
    }

    // 게시글조회
    @GetMapping("/post/{post_id}")
    public Post getpost(@PathVariable("post_id") String post_id) {
        postMapper.updateViews(post_id);
        return postMapper.selectPost(post_id);
    }

    // 게시글등록
    @PostMapping("/post")
    public String insertPost(@RequestParam String title,
                           @RequestParam String contents,
                           @RequestParam String password) {
         postMapper.insertPost(title, contents, password);
         return "등록성공";
    }

    // 게시글수정
    @PutMapping("/post/{post_id}")
    public String updatePost(@PathVariable("post_id") String post_id,
                             @RequestParam String title,
                             @RequestParam String contents) {
        postMapper.updatePost(post_id, title, contents);
        return "수정성공";

    }

    // 게시글삭제
    @DeleteMapping("post/{post_id}")
    public String deletePost(@PathVariable("post_id") String post_id,
                           @RequestParam String password) {
        if (postMapper.selectPost(post_id).getPassword().equals(password)) {
            postMapper.deletePost(post_id);
            return "삭제성공";
        }
        return "삭제실패";
    }

}
