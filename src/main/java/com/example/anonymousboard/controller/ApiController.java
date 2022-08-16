package com.example.anonymousboard.controller;

import com.example.anonymousboard.data.Order;
import com.example.anonymousboard.data.Post;
import com.example.anonymousboard.mapper.OrderMapper;
import com.example.anonymousboard.mapper.PostMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    final
    PostMapper postMapper;

    @Autowired
    OrderMapper orderMapper;

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

    /*Order Controller*/

    @GetMapping("/duser/{ord_id}")
    public Order getOrder(@PathVariable("ord_id") String ord_id) {
        System.out.println(ord_id);
        System.out.println(orderMapper.selectOrder(ord_id));
        return orderMapper.selectOrder(ord_id);
    }


    @GetMapping("/duser/orders1")
    public List<Order> getOrders1() {
        return orderMapper.selectAllOrders1();
    }

    @GetMapping("/duser/orders2")
    public List<Order> getOrders2() {
        return orderMapper.selectAllOrders2();
    }

    @GetMapping("/duser/orders22")
    public List<Order> getOrders22() {
        return orderMapper.selectAllOrders22();
    }

    @GetMapping("/duser/orders3")
    public List<Order> getOrders3() {
        return orderMapper.selectAllOrders3();
    }

    @PutMapping("/duser/change/{id}")
    public String changeStatus(@PathVariable("id") String id, @RequestParam("status") String status) {
        switch (status) {
            case "운송하기":
                orderMapper.updateTo픽업전(id);
                break;
            case "운송시작":
                orderMapper.updateTo운송중(id);
                break;
            case "운송완료":
                orderMapper.updateTo운송완료(id);
                break;
        }
        System.out.println(status);
        return "변경완료Good";
    }

}
