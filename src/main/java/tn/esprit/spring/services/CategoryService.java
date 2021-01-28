package tn.esprit.spring.services;
import java.util.List;
import tn.esprit.spring.DAO.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{

	@Autowired 
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category addCategory(Category category) {
				return categoryRepository.save(category);
	}

	@Override
	public String deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		return ("Catgeory "+categoryId+ " is deleted !");
	}

	@Override
	public List<Category> getCategory(int categoryId) {
			return categoryRepository.findAll();
	}

    @Override
	public List<Category> showName(String categoryName) {
	
		return categoryRepository.findAll();
	}

	@Override
	public Category updateCatgeory(Category category) {
		Category c= categoryRepository.findById(category.getCategoryId()).orElse(null);
		if(!(category.getCategoryName()==null))
			c.setCategoryName(category.getCategoryName());
			
		return categoryRepository.save(c);
	}
	
}
