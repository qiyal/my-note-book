package kz.pazyl.mynotebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "budget")
public class BudgetEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @Column(name = "sum")
    private Double sum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
    private CurrencyEntity currency;

    @Column(name = "finish_day")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime finishDate;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "budget")
    private List<BudgetOperationEntity> operations;

    @Transient
    private Double currentSum;

    @Transient
    private Double donePercent;
}
