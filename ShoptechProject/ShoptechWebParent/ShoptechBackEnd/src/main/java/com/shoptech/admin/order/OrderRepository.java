package com.shoptech.admin.order;
import com.shoptech.admin.paging.SearchRepository;
import com.shoptech.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer>, SearchRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o WHERE CONCAT('#', o.id) LIKE %?1% "
			+ "OR CONCAT(o.firstName, ' ', o.lastName) LIKE %?1% "
			+ "OR o.state LIKE %?1% OR o.country LIKE %?1% ")
	public Page<Order> findAll(String keyword, Pageable pageable);

	public Long countById(Integer id);
	
	@Query("SELECT NEW com.shoptech.entity.order.Order(o.id, o.orderTime, o.productCost,"
			+ " o.subtotal, o.total) FROM Order o WHERE"
			+ " o.orderTime BETWEEN ?1 AND ?2 ORDER BY o.orderTime ASC")
	public List<Order> findByOrderTimeBetween(Date startTime, Date endTime);

}