package kz.pazyl.mynotebook.repository;

import kz.pazyl.mynotebook.model.entity.BudgetOperationEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetOperationRepository extends JpaRepository<BudgetOperationEntity, Long> {
    List<BudgetOperationEntity> findBudgetOperationEntitiesByBudget_Id(Long id, Sort sort);
}
