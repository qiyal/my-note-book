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

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/budget")
public class BudgetController {
    @Autowired
    private IBudgetService iBudgetService;

    @PostMapping(name = "Create new budget")
    public ResponseEntity<BudgetItem> createBudget(
            @RequestBody BudgetRequestCreate request
    ) {
        return ResponseEntity.ok(iBudgetService.create(request));
    }

    @GetMapping(value = "/{budgetId}", name = "Get budget by id")
    public ResponseEntity<BudgetItem> getBudgetById(
            @PathVariable(name = "budgetId") @NotNull(message = "id is null") Long budgetId
    ) {
        return ResponseEntity.ok(iBudgetService.getById(budgetId));
    }

    @DeleteMapping(value = "/{budgetId}", name = "Delete budget by id")
    public ResponseEntity<Long> deleteBudgetById(
            @PathVariable(name = "budgetId") @NotNull(message = "id is null") Long budgetId
    ) {
        return ResponseEntity.ok(iBudgetService.deleteById(budgetId));
    }

    @PostMapping(value = "/{budgetId}/operation", name = "Create new BudgetOperation")
    public ResponseEntity<BudgetOperationItem> addOperation(
            @PathVariable("budgetId") Long budgetId,

            @RequestBody BudgetOperationRequestCreate request
    ) {
        return ResponseEntity.ok(iBudgetService.addOperation(budgetId, request));
    }

    @DeleteMapping(value = "/operation/{operationId}")
    public ResponseEntity<Long> deleteOperationById(
            @PathVariable("operationId") Long operationId
    ) {
        return ResponseEntity.ok(iBudgetService.deleteOperationById(operationId));
    }

    @GetMapping(value = "/{budgetId}/operation/list", name = "Get list of BudgetOperation by budgetId")
    public ResponseEntity<List<BudgetOperationItem>> getOperationList(
            @PathVariable("budgetId") Long budgetId
    ) {
        return ResponseEntity.ok(iBudgetService.getOperationList(budgetId));
    }
}
