package com.mdn.expensestracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdn.expensestracker.entity.Expense;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {

}
