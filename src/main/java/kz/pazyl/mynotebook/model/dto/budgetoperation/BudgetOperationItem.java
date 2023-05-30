package kz.pazyl.mynotebook.model.dto.budgetoperation;

import kz.pazyl.mynotebook.model.dto.CurrencyItem;
import kz.pazyl.mynotebook.model.dto.budget.BudgetItem;
import kz.pazyl.mynotebook.model.entity.BudgetOperationEntity;
import kz.pazyl.mynotebook.model.enums.BudgetOperationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class BudgetOperationItem {
    private Long id;
    private Double sum;
    private String note;
    private BudgetOperationType type;
    private LocalDateTime createdDate;
    private BudgetItem budget;
    private CurrencyItem currency;

    public static BudgetOperationItem of(BudgetOperationEntity entity) {
        if (entity == null) return null;

        return BudgetOperationItem.builder()
                .id(entity.getId())
                .sum(entity.getSum())
                .note(entity.getNote())
                .type(entity.getType())
                .createdDate(entity.getCreatedDate())
                .budget(BudgetItem.of(entity.getBudget()))
                .currency(CurrencyItem.of(entity.getCurrency()))
                .build();
    }

    public static List<BudgetOperationItem> listOf(List<BudgetOperationEntity> entityList) {
        if (entityList == null) return null;

        return entityList.stream()
                .map(BudgetOperationItem::of)
                .collect(Collectors.toList());
    }
}
