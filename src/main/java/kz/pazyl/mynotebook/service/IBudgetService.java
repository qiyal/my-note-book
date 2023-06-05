package kz.pazyl.mynotebook.service;

import kz.pazyl.mynotebook.model.dto.budget.BudgetItem;
import kz.pazyl.mynotebook.model.dto.budget.BudgetRequestCreate;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationItem;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationRequestCreate;
import kz.pazyl.mynotebook.model.entity.BudgetEntity;

import java.util.List;

public interface IBudgetService {

    BudgetItem getById(Long id);
    BudgetItem create(BudgetRequestCreate budget);

    BudgetEntity save(BudgetEntity budget);

    BudgetOperationItem addOperation(Long budgetId, BudgetOperationRequestCreate operation);
    List<BudgetOperationItem> getOperationList(Long budgetId);

    Long deleteById(Long budgetId);

    Long deleteOperationById(Long operationId);
}
