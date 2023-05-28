package kz.pazyl.mynotebook.service;

import kz.pazyl.mynotebook.model.dto.budget.BudgetItem;
import kz.pazyl.mynotebook.model.dto.budget.BudgetRequestCreate;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationItem;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationRequestCreate;
import kz.pazyl.mynotebook.model.entity.BudgetEntity;

public interface IBudgetService {

    BudgetItem create(BudgetRequestCreate budget);
    BudgetEntity save(BudgetEntity budget);

    BudgetOperationItem addOperation(BudgetOperationRequestCreate operation);

    BudgetItem getById(Long id);
}
