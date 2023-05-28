package kz.pazyl.mynotebook.model.entity;

import jakarta.persistence.*;
import kz.pazyl.mynotebook.model.enums.BudgetOperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "budget_operation")
public class BudgetOperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "note")
    private String note;

    @Column(name = "type")
    private BudgetOperationType type;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "budget_id", referencedColumnName = "id", nullable = false)
    private BudgetEntity budget;

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
    private CurrencyEntity currency;
}
