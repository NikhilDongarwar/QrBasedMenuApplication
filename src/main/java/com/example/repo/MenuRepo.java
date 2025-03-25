package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.MenuDto;
import com.example.entity.Menu;

@Repository
public interface MenuRepo  extends JpaRepository<Menu,Integer>{
	
    
	

}
