package kz.pazyl.mynotebook.model.dto.budgetoperation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kz.pazyl.mynotebook.model.enums.BudgetOperationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BudgetOperationRequestCreate {
    @NotNull(message = "Бюджет id таңдалмаған")
    private Long budgetId;

    @NotNull(message = "Валюта id таңдалмаған")
    private Long currencyId;

    @Positive
    private Double sum;

    private String note;

    @NotNull
    private BudgetOperationType type;
}
