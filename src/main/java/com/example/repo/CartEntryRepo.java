package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CartEntry;

@Repository
public interface CartEntryRepo extends JpaRepository<CartEntry,Integer>{

}
