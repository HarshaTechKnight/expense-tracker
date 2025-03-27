package com.example.expensetracker.service;

import com.example.expensetracker.model.ExpenseCategory;
import com.example.expensetracker.repository.ExpenseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {
    
    private final ExpenseCategoryRepository expenseCategoryRepository;
    
    public ExpenseCategoryService(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }
    
    public List<ExpenseCategory> getAllCategories() {
        return expenseCategoryRepository.findAll();
    }
    
    public ExpenseCategory saveCategory(ExpenseCategory category) {
        return expenseCategoryRepository.save(category);
    }
    
    public ExpenseCategory getCategoryById(Long id) {
        return expenseCategoryRepository.findById(id).orElse(null);
    }
    
    public void deleteCategory(Long id) {
        expenseCategoryRepository.deleteById(id);
    }
    
    public ExpenseCategory findByName(String name) {
        return expenseCategoryRepository.findByName(name);
    }
}