package com.example.expensetracker.controller;

import com.example.expensetracker.model.ExpenseCategory;
import com.example.expensetracker.service.ExpenseCategoryService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class ExpenseCategoryController {
    
    private final ExpenseCategoryService expenseCategoryService;
    
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }
    
    @GetMapping
    public String showCategories(Model model) {
        List<ExpenseCategory> categories = expenseCategoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new ExpenseCategory());
        return "categories/add";
    }
    
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") ExpenseCategory category, 
                            BindingResult result) {
        if (result.hasErrors()) {
            return "categories/add";
        }
        
        expenseCategoryService.saveCategory(category);
        return "redirect:/categories";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ExpenseCategory category = expenseCategoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/edit";
    }
    
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, 
                               @Valid @ModelAttribute("category") ExpenseCategory category, 
                               BindingResult result) {
        if (result.hasErrors()) {
            return "categories/edit";
        }
        
        category.setId(id);
        expenseCategoryService.saveCategory(category);
        return "redirect:/categories";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        expenseCategoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}