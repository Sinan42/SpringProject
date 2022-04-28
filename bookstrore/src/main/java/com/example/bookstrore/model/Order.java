package com.example.bookstrore.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "book_orders")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> bookIdList;
    private Double totalPrice;

}
