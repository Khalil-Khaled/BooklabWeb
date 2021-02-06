package tn.esprit.spring.services;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.repository.CategoryRepository;
import tn.esprit.spring.DAO.repository.IItemDAO;
import tn.esprit.spring.DAO.repository.IUserRepository;

@Service
public class CategoryService implements ICategoryService{

	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired IItemDAO itemRepository;


	@Override
	public Category addCategory(Category category, int userid) {
		User user =userRepository.findById(userid);
		category.setUser(user);
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {

		if(showAllCategories().contains(category))
			categoryRepository.delete(category);
		
	}

	@Override
	public List<Category> showCategoryByUser(int userid) {
		List<Category> categoriesByUser= new ArrayList<>();
		  categoryRepository.findByUserId(userid).forEach(categoriesByUser::add);
		  return categoriesByUser;
	}
	
	@Override
	public List<Category> showBooksByCategory(int categoryId) {
		List<Category> booksByCategory=new ArrayList<>();
		categoryRepository.findById(categoryId);
		return booksByCategory;
	}
	

	@Override
	public Category showCategory(int categoryId) {
		return categoryRepository.findById(categoryId);
	}

	@Override
	public void updateCategory(Category category) {
		  categoryRepository.save(category);
		
	}

	@Override
	public List<Category> showAllCategories() {
		List<Category> allCategories= new ArrayList<>();
		categoryRepository.findAll().forEach(allCategories::add);
		return allCategories;
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

	@Override
	public int countCategoryByUser(int userid) {
		return categoryRepository.countCategoryAddedByUser(userid);
	}

	@Override
	public int countBookCategory(int categoryId) {
		
		return categoryRepository.countBookByCategory(categoryId);
	}



	
	
}
