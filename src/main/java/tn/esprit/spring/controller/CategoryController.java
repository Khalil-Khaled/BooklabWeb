package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.services.CategoryService;
import tn.esprit.spring.services.ICategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("addcategory")
	public Category addCategory (@RequestBody Category category, @PathVariable("userid") int userid){
		return categoryService.addCategory(category, userid);
	}
	
	
	@PutMapping("updatecategory")
	public void updateCatgeory(@RequestBody Category category){
		categoryService.updateCategory(category);
	}
	
	@DeleteMapping("deletecategory")
	public void deleteCategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	
	@GetMapping("findcategory")
	public List<Category> getCategory(){
        return categoryService.showAllCategories();
	}
	
	@GetMapping("categorybyuser")
	public int numberOfCategories(@PathVariable("userid") int userid){
		return categoryService.countCategoryByUser(userid);
	}
	
	@GetMapping("showcategorybyUser")
	public List<Category> getCategoryByUser(@PathVariable("userid") int userid){
		return categoryService.showCategoryByUser(userid);
		}
	
	@GetMapping("showbooks")
	public List<Category> getBooksByCategory(@PathVariable("categoryId") int categoryId){
		return categoryService.showBooksByCategory(categoryId);
	}
	
	@GetMapping("numberofbooks")
	public int numberOfBooks(@PathVariable("categoryId") int categoryId){
		return categoryService.countBookCategory(categoryId);
	}
}
