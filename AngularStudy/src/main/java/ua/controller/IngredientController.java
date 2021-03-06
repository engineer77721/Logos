package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.entity.Ingredient;
import ua.filter.BasicFilter;
import ua.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	private IngredientService service;
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@GetMapping(headers={"Accept=application/json"}, params={"page","size"})
	public Page<Ingredient> get(@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		return service.findAll(pageable, filter);
	}
	
	@GetMapping(headers={"Accept=application/json"})
	public List<Ingredient> get(){
		return service.findAll();
	}
	
	@PostMapping(headers={"Accept=application/json"})
	public Ingredient post(@RequestBody Ingredient ingredient){
		return service.save(ingredient);
	}
	
	@DeleteMapping(value="/{id}", headers={"Accept=application/json"})
	public HttpStatus delete(@PathVariable Long id){
		service.delete(id);
		return HttpStatus.OK;
	}
	
	@PutMapping(value="/{id}", headers={"Accept=application/json"})
	public Ingredient put(@PathVariable Long id,@RequestBody Ingredient ingredient){
		ingredient.setId(id);
		return service.save(ingredient);
	}
}
