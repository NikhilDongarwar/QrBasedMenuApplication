package com.example.service;

import java.awt.MenuItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Menu;
import com.example.repo.MenuRepo;

@Service
public class MenuService {
	
	@Autowired
	MenuRepo menurepo; 
	
	public List<Menu> getMenu(){
		
		return menurepo.findAll();
		
		
	}

	public Menu findMenuItemById(Integer itemId) {
		// TODO Auto-generated method stub
		return  menurepo.findById(itemId).get();
	}

}
