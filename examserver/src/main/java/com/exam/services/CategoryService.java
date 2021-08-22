package com.exam.services;

import java.util.Set;

import com.exam.entitiy.exam.Category;

public interface CategoryService {
 
	public Category addCategory(Category category);
	
	public Category  updateCategory(Category category);
	
	public Set<Category>  getCategories();
	
	public Category getCategory(Long cateoryId);
	
	public void deleteCategory(Long categoryId);
	
	
	
}
