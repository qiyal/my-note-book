package kz.pazyl.mynotebook.service.impl;

import kz.pazyl.mynotebook.model.dto.budget.BudgetItem;
import kz.pazyl.mynotebook.model.dto.budget.BudgetRequestCreate;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationItem;
import kz.pazyl.mynotebook.model.dto.budgetoperation.BudgetOperationRequestCreate;
import kz.pazyl.mynotebook.model.entity.BudgetEntity;
import kz.pazyl.mynotebook.model.entity.BudgetOperationEntity;
import kz.pazyl.mynotebook.model.entity.CurrencyEntity;
import kz.pazyl.mynotebook.model.enums.BudgetOperationType;
import kz.pazyl.mynotebook.model.exception.EntityNotFoundException;
import kz.pazyl.mynotebook.repository.BudgetOperationRepository;
import kz.pazyl.mynotebook.repository.BudgetRepository;
import kz.pazyl.mynotebook.repository.CurrencyRepository;
import kz.pazyl.mynotebook.service.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class BudgetService implements IBudgetService {
    @Autowired
    private BudgetRepository repository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private BudgetOperationRepository budgetOperationRepository;

    @Override
    public BudgetItem getById(Long id) {
        BudgetEntity budget = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "budget not found"));

        Optional<List<BudgetOperationEntity>> budgetOperationsOptional = Optional.ofNullable(budget.getOperations());

        budgetOperationsOptional
                .ifPresent(budgetOperations -> {
                    double currentSum = budgetOperations.stream()
                            .mapToDouble(budgetOperation ->
                                    BudgetOperationType.PLUS.equals(budgetOperation.getType())
                                            ? budgetOperation.getSum()
                                            : -budgetOperation.getSum()
                            )
                            .sum();

                    budget.setCurrentSum(currentSum);
                    budget.setDonePercent(currentSum * 100 / budget.getSum());
                });

        return BudgetItem.of(budget);
    }

    @Override
    public BudgetItem create(BudgetRequestCreate request) {

        // валютаны базадан тексереміз
        CurrencyEntity currency = currencyRepository.findById(request.getCurrencyId())
                .orElseThrow(() -> new EntityNotFoundException(request.getCurrencyId(), "Валюта табылмады"));

        BudgetEntity entity = new BudgetEntity();

        entity.setName(request.getName());
        entity.setNote(request.getNote());
        entity.setSum(request.getSum());
        entity.setCurrency(currency);
        entity.setFinishDate(request.getFinishDate());

        entity = this.save(entity);

        return BudgetItem.of(entity);
    }

    @Override
    public BudgetEntity save(BudgetEntity budget) {
        return repository.save(budget);
    }

    @Override
    public BudgetOperationItem addOperation(Long budgetId, BudgetOperationRequestCreate request) {
        BudgetEntity budget = repository.findById(budgetId)
                .orElseThrow(() -> new EntityNotFoundException(budgetId, "Budget табылмады"));

        CurrencyEntity currency = currencyRepository.findById(request.getCurrencyId())
                .orElseThrow(() -> new EntityNotFoundException(budgetId, "Валюта табылмады"));

        BudgetOperationEntity operation = new BudgetOperationEntity();
        operation.setSum(request.getSum());
        operation.setNote(request.getNote());
        operation.setType(request.getType());
        operation.setBudget(budget);
        operation.setCurrency(currency);

        budgetOperationRepository.save(operation);

        return BudgetOperationItem.of(operation);
    }

    @Override
    public List<BudgetOperationItem> getOperationList(Long budgetId) {
        return BudgetOperationItem.listOf(
                budgetOperationRepository.findBudgetOperationEntitiesByBudget_Id(
                        budgetId,
                        Sort.by(Sort.Direction.DESC, "createdDate")
                )
        );
    }

    @Override
    public Long deleteById(Long budgetId) {
        repository.deleteById(budgetId);
        return budgetId;
    }

    @Override
    public Long deleteOperationById(Long operationId) {
        budgetOperationRepository.deleteById(operationId);
        return operationId;
    }
}
