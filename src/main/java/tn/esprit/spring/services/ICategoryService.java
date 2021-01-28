package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.DAO.entity.Category;
public interface ICategoryService {


	public Category addCategory(Category category);
	public String deleteCategory(int categoryId);
	public List<Category> getCategory( int categoryId);
	public List<Category> showName(String categoryName);
	public Category updateCatgeory(Category category);
	
}
