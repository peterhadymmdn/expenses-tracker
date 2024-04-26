package com.mdn.expensestracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdn.expensestracker.dto.ExpensesDto;
import com.mdn.expensestracker.service.ExpensesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {
  
  ExpensesService expensesService;
  
  @PostMapping
  public ResponseEntity<ExpensesDto> addNewExpense(@RequestBody ExpensesDto expensesDto) {
    
    ExpensesDto newExpensesDto = expensesService.createExpense(expensesDto);
    
    return new ResponseEntity<>(newExpensesDto,HttpStatus.CREATED);
  }
  
  @GetMapping
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<List<ExpensesDto>> getAllExpense() {

    List<ExpensesDto> allExpensesDto = expensesService.getAllExpenses();

    return new ResponseEntity<>(allExpensesDto, HttpStatus.OK);
  }
}
