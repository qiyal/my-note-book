package kz.pazyl.mynotebook.model.dto.budget;

import kz.pazyl.mynotebook.model.dto.CurrencyItem;
import kz.pazyl.mynotebook.model.entity.BudgetEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BudgetItem {
    private Long id;
    private String name;
    private String note;
    private Double sum;
    private CurrencyItem currency;
    private LocalDateTime finishDate;
    private LocalDateTime createdDate;
    private Double currentSum;
    private Double donePercent;

    public static BudgetItem of(BudgetEntity entity) {
        if (entity == null) return null;

        return BudgetItem.builder()
                .id(entity.getId())
                .name(entity.getName())
                .note(entity.getNote())
                .sum(entity.getSum())
                .currency(CurrencyItem.of(entity.getCurrency()))
                .finishDate(entity.getFinishDate())
                .createdDate(entity.getCreatedDate())
                .currentSum(entity.getCurrentSum())
                .donePercent(entity.getDonePercent())
                .build();
    }
}
