package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }
    
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
    
    public List<Expense> getExpensesByDateRange(Date startDate, Date endDate) {
        return expenseRepository.findByDateBetween(startDate, endDate);
    }
    
    public List<Expense> getExpensesByCategory(Long categoryId) {
        return expenseRepository.findByCategoryId(categoryId);
    }
    
    public List<Expense> getExpensesByMonthAndYear(int year, int month) {
        return expenseRepository.findByMonthAndYear(year, month);
    }
    
    public List<Object[]> getExpensesGroupedByCategory() {
        return expenseRepository.getExpensesByCategory();
    }
}