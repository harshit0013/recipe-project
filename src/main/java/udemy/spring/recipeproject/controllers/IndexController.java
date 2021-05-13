package udemy.spring.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import udemy.spring.recipeproject.domain.Category;
import udemy.spring.recipeproject.domain.UnitOfMeasure;
import udemy.spring.recipeproject.repositories.CategoryRepository;
import udemy.spring.recipeproject.repositories.UnitOfMeasureRepository;
import udemy.spring.recipeproject.services.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model)
    {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
