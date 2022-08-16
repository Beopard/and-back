package com.example.anonymousboard.mapper;

import com.example.anonymousboard.data.Order;
import com.example.anonymousboard.data.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from orders where ord_id=#{ord_id}")
    public Order selectOrder(String ord_id);

    //    전체 주문 조회
    @Select("select * from orders where status = '운송가능'")
    public List<Order> selectAllOrders1();

    //    전체 주문 조회
    @Select("select * from orders where status = '운송중'")
    public List<Order> selectAllOrders2();

    //    전체 주문 조회
    @Select("select * from orders where status = '픽업전'")
    public List<Order> selectAllOrders22();

    //    전체 주문 조회
    @Select("select * from orders where status = '운송완료'")
    public List<Order> selectAllOrders3();

    @Update("update orders set status = '픽업전' where ord_id=#{ord_id}")
    public String updateTo픽업전(String ord_id);

    @Update("update orders set status = '운송중' where ord_id=#{ord_id}")
    public String updateTo운송중(String ord_id);

    @Update("update orders set status = '운송완료' where ord_id=#{ord_id}")
    public String updateTo운송완료(String ord_id);


}
