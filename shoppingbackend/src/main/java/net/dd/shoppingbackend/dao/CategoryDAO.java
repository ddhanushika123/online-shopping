package net.dd.shoppingbackend.dao;

import java.util.List;

import net.dd.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	

}
