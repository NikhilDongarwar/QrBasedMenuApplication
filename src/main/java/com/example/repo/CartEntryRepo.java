package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.CartEntry;

@Repository
public interface CartEntryRepo extends JpaRepository<CartEntry,Integer>{
    
	@Query("SELECT c FROM CartEntry c WHERE c.orderform.orderId = :orderId")
    List<CartEntry> findByOrderformOrderId(@Param("orderId") int orderId);

	 
}
