package com.mdn.expensestracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mdn.expensestracker.dto.ExpensesDto;
import com.mdn.expensestracker.entity.Expense;
import com.mdn.expensestracker.repository.ExpensesRepository;
import com.mdn.expensestracker.service.ExpensesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpensesServiceImplementation implements ExpensesService {

  private ExpensesRepository expensesRepository;

  @Override
  public ExpensesDto createExpense(ExpensesDto expenseDto) {
    // TODO Auto-generated method stub
    
    Expense newExpense = new Expense(
      expenseDto.getId(),
      expenseDto.getAmount(),
      expenseDto.getDescription()
    );
    Expense newlyAddedExpense = expensesRepository.save(newExpense);

    return expenseDto;

  }

  @Override
  public List<ExpensesDto> getAllExpenses() {
    List<Expense> listofAllExpenses = expensesRepository.findAll();

    List<ExpensesDto> listAllExpensesDto = listofAllExpenses
    .stream()
    .map((expenses) -> new ExpensesDto(expenses.getId(), expenses.getAmount(), expenses.getDescription()))
    .toList();

    return listAllExpensesDto;
  }
  
}
