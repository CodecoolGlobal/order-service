package com.orderservice.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime date;
}
