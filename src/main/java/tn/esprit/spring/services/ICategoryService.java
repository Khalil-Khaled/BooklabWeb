package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.DAO.entity.Category;

public interface ICategoryService {



	 public Category addCategory(Category category, int userid);
	 public void deleteCategory(Category category);
	 public List<Category> showCategoryByUser(int userid);	
	 public List<Category> showBooksByCategory(int categoryId);
	 public Category showCategory(int categoryId);
	 public void updateCategory(Category category);
	 public List<Category> showAllCategories();
	 public void deleteCategory(int categoryId);
	 public int countCategoryByUser(int userid); 
	 public int countBookCategory(int categoryId);
	 
}
