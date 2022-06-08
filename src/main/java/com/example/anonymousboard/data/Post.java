package com.example.anonymousboard.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    String post_id;
    String title;
    String contents;
    String created_time;
    String views;
    String password;

}
