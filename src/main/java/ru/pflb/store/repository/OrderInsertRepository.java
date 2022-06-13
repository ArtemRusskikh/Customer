package ru.pflb.store.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pflb.store.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void insertWithQuery(Order order, Long customer_id) {
        entityManager.createNativeQuery("INSERT INTO ORDERS (order_id, valueorder, comment, createdat, customer_id ) VALUES (?,?,?,?,?)")
                .setParameter(1, order.getOrder_id())
                .setParameter(2, order.getValueOrder())
                .setParameter(3, order.getComment())
                .setParameter(4, order.getCreatedAt())
                .setParameter(5, customer_id)
                .executeUpdate();
    }
}


