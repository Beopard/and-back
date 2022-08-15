package com.example.anonymousboard.mapper;

import com.example.anonymousboard.data.Order;
import com.example.anonymousboard.data.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    //    전체 주문 조회
    @Select("select * from orders")
    public List<Order> selectAllOrders();


}
