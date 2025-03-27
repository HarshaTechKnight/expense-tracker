package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
    List<Expense> findByDateBetween(Date startDate, Date endDate);
    
    List<Expense> findByCategoryId(Long categoryId);
    
    @Query("SELECT e FROM Expense e WHERE YEAR(e.date) = ?1 AND MONTH(e.date) = ?2")
    List<Expense> findByMonthAndYear(int year, int month);
    
    @Query("SELECT e.category.name, SUM(e.amount) FROM Expense e GROUP BY e.category.name")
    List<Object[]> getExpensesByCategory();
}