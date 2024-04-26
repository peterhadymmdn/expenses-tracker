package com.mdn.expensestracker.service;

import java.util.List;

import com.mdn.expensestracker.dto.ExpensesDto;

public interface ExpensesService {
  public List<ExpensesDto> getAllExpenses();
  public ExpensesDto createExpense (ExpensesDto expenseDto);
}
