package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.MenuDto;
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
	
	public Menu addnewMenuitem(MenuDto menuitem) {
		Menu menu=new Menu();
		menu.setCategory(menuitem.getCategory());
		menu.setDescription(menuitem.getDescription());
		menu.setName(menuitem.getName());
		menu.setPrice(menuitem.getPrice());
		return menurepo.save(menu);
			}

	public Menu updateMenuitem(Menu menu) {
	    long menuId=menu.getId();
		int id=(int)menuId;
		
		Optional<Menu> menu1=menurepo.findById(id);
		
		if(menu1.isPresent()) {
		menu1.get().setName(menu.getName());
		menu1.get().setDescription(menu.getDescription());
		menu1.get().setCategory(menu.getCategory());
		menu1.get().setPrice(menu.getPrice());
		
		return menurepo.save(menu1.get());
		
		
		}
		 return null;
		
		
		
	}

}
