package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseCategory;
import com.example.expensetracker.service.ExpenseCategoryService;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    
    private final ExpenseService expenseService;
    private final ExpenseCategoryService expenseCategoryService;
    
    public ExpenseController(ExpenseService expenseService, ExpenseCategoryService expenseCategoryService) {
        this.expenseService = expenseService;
        this.expenseCategoryService = expenseCategoryService;
    }
    
    @GetMapping
    public String showExpenses(Model model) {
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<ExpenseCategory> categories = expenseCategoryService.getAllCategories();
        model.addAttribute("expense", new Expense());
        model.addAttribute("categories", categories);
        return "expenses/add";
    }
    
    @PostMapping("/add")
    public String addExpense(@Valid @ModelAttribute("expense") Expense expense, 
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ExpenseCategory> categories = expenseCategoryService.getAllCategories();
            model.addAttribute("categories", categories);
            return "expenses/add";
        }
        
        expense.setDate(new Date()); // Or use the date from the form
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        List<ExpenseCategory> categories = expenseCategoryService.getAllCategories();
        model.addAttribute("expense", expense);
        model.addAttribute("categories", categories);
        return "expenses/edit";
    }
    
    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @Valid @ModelAttribute("expense") Expense expense, 
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ExpenseCategory> categories = expenseCategoryService.getAllCategories();
            model.addAttribute("categories", categories);
            return "expenses/edit";
        }
        
        expense.setId(id);
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
    
    @GetMapping("/report")
    public String showReport(Model model) {
        List<Object[]> expensesByCategory = expenseService.getExpensesGroupedByCategory();
        model.addAttribute("expensesByCategory", expensesByCategory);
        return "expenses/report";
    }
}