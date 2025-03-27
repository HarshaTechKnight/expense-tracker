package com.example.expensetracker.config;

import com.example.expensetracker.model.ExpenseCategory;
import com.example.expensetracker.model.Role;
import com.example.expensetracker.repository.ExpenseCategoryRepository;
import com.example.expensetracker.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    
    private final RoleRepository roleRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;
    
    public DataInitializer(RoleRepository roleRepository, ExpenseCategoryRepository expenseCategoryRepository) {
        this.roleRepository = roleRepository;
        this.expenseCategoryRepository = expenseCategoryRepository;
    }
    
    @PostConstruct
    public void init() {
        // Initialize roles
        if (roleRepository.findByName("USER") == null) {
            Role userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }
        
        if (roleRepository.findByName("ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);
        }
        
        // Initialize some categories
        if (expenseCategoryRepository.count() == 0) {
            ExpenseCategory food = new ExpenseCategory();
            food.setName("Food");
            food.setDescription("Groceries and dining out");
            expenseCategoryRepository.save(food);
            
            ExpenseCategory transportation = new ExpenseCategory();
            transportation.setName("Transportation");
            transportation.setDescription("Public transport, fuel, etc.");
            expenseCategoryRepository.save(transportation);
            
            ExpenseCategory utilities = new ExpenseCategory();
            utilities.setName("Utilities");
            utilities.setDescription("Electricity, water, internet, etc.");
            expenseCategoryRepository.save(utilities);
            
            ExpenseCategory entertainment = new ExpenseCategory();
            entertainment.setName("Entertainment");
            entertainment.setDescription("Movies, games, hobbies");
            expenseCategoryRepository.save(entertainment);
        }
    }
}