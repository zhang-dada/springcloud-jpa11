package com.bwie.zjh.mapper;

import com.bwie.zjh.pojo.Order;
import org.hibernate.type.OrderedMapType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface orderMapper extends JpaRepository<Order,Long> {

    public List<Order> findByOrderTime(Date orderTime);
}
