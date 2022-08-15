package com.example.anonymousboard.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    String ord_id;
    String user_id;
    String ord_amount;
    String keep_status;
    String entrust_time;
    String withdraw_time;
    String keep_start;
    String keep_end;
    String delivery_id;
    String call_time;
    String status;
    String pay_id;
    String ord_selection;
    String ord_request;

}
