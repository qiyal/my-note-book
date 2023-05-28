package kz.pazyl.mynotebook.model.dto.budget;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BudgetRequestCreate {

    @NotBlank(message = "Биджет аты толтырулы болу керек")
    private String name;

    private String note;

    @Positive(message = "Сумма нөлден кіші боллмау керек")
    private Double sum;

    @NotNull(message = "Валюта таңдалмаған")
    private Long currencyId;

    @DateTimeFormat(pattern = "yyyy-mm-dd'T'hh:mm:ss")
    private LocalDateTime finishDate;
}
