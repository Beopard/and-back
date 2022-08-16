package com.example.anonymousboard.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    String ord_id;
    String distance;
    String start_time;
    String distance_from_me;
    String start_place;
    String end_place;
    String end_time;
    String size;
    String count;
    String weight;
    String price;
    String ord_request;
    String status;
    String start_place_detail;
    String end_place_detail;
    String start_time_detail;
    String end_time_detail;
    String info;
}
