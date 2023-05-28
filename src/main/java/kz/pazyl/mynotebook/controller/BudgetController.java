package kz.pazyl.mynotebook.controller;

import jakarta.validation.constraints.NotNull;
import kz.pazyl.mynotebook.model.dto.budget.BudgetItem;
import kz.pazyl.mynotebook.model.dto.budget.BudgetRequestCreate;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationItem;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationRequestCreate;
import kz.pazyl.mynotebook.service.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(value = "/budget")
public class BudgetController {
    @Autowired
    private IBudgetService iBudgetService;

    @PostMapping
    public ResponseEntity<BudgetItem> createBudget(
            @RequestBody BudgetRequestCreate request
    ) {
        return ResponseEntity.ok(iBudgetService.create(request));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BudgetItem> getBudgetById(
            @PathVariable(name = "id") @NotNull(message = "id is null") Long budgetId
    ) {
        return ResponseEntity.ok(iBudgetService.getById(budgetId));
    }

    @PostMapping("/operation")
    public ResponseEntity<BudgetOperationItem> addOperation(
            @RequestBody BudgetOperationRequestCreate request
    ) {
        return ResponseEntity.ok(iBudgetService.addOperation(request));
    }
}
