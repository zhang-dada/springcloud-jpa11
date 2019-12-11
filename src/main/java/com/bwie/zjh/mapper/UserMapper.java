package com.bwie.zjh.mapper;

import com.bwie.zjh.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<Users,Long> {

}
