package ru.pflb.store.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate

public class Order {

    @Id
    @Column(name = "order_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;

    @Column(name = "valueorder")
    private String valueOrder;

    @Column(name = "comment")
    private String comment;

    @Column(name = "createdat")
    private Instant createdAt;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

}
