package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.OrderForm;

@Repository
public interface orderRepo extends JpaRepository<OrderForm,Integer> {

}
