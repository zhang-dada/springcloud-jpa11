package com.bwie.zjh.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_user")
@Data
@Entity
public class Users {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//包含id,

    @Column(name = "name")
    private String name;// 姓名，

    @Column(name = "username")
    private String username;// 账号，

    @Column(name = "password")
    private String password;// 密码，

    @Column(name = "birthday")
    private Date birthday;// 生日，

    @Column(name = "gender")
    private String gender;// 性别，

    @Column(name = "descs")
    private String descs;// 籍贯// ，

    @Column(name = "zhu")
    private String zhu;// 住址，

    @Column(name = "isa")
    private Long isa;// 是否删除，



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "users",fetch = FetchType.EAGER)
    private List<Order> list;// 订单集合
}
