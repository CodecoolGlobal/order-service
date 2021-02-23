package com.orderservice.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "date")
    private LocalDateTime date;
}
