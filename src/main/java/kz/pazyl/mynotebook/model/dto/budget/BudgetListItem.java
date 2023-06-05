package kz.pazyl.mynotebook.model.dto.budget;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BudgetListItem {
    private Long totalSum;
    private List<BudgetItem> budgetList;
}
