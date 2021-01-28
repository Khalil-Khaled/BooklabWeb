package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.services.ICategoryService;

@RestController
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;
	
	@PostMapping("/category/add")
	public Category addCategory (@RequestBody Category c){
		return iCategoryService.addCategory(c);
	}
	
	
	@PostMapping("/admin/categorie/update")
	public void updateCatgeory(Category category){
		iCategoryService.updateCatgeory(category);
	}
	
	@PostMapping("/admin/categorie/delete/id")
	public void deleteCategory(@PathVariable int categoryId){
		iCategoryService.deleteCategory(categoryId);
	}
	
	@GetMapping("/category/id")
	public List<Category> getCategory(@PathVariable int categoryId){
		return iCategoryService.getCategory(categoryId);
	}
	
	@GetMapping("/category")
	public List<Category> showName(@Param("categoryName") String categoryName){
		return iCategoryService.showName(categoryName);
	}
	
}
