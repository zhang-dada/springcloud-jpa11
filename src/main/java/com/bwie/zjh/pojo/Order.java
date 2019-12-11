package com.bwie.zjh.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_order")
@Data
@Entity
public class Order {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//包含id,

    @Column(name = "ordern")
    private Long ordern;// 订单号，

    @Column(name = "money")
    private String money;// 支付金额，

    @Column(name = "iso")
    private Long iso;// 订单状态（0-未支付，1-已支付）

    @Column(name = "orderTime")
    private Date orderTime;//订单日期，是否删除）

    @Column(name = "user_id")
    private Long user_id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private Users users;// 订单所属用户,
}
