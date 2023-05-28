package kz.pazyl.mynotebook.repository;

import kz.pazyl.mynotebook.model.entity.BudgetOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetOperationRepository extends JpaRepository<BudgetOperationEntity, Long> {

}
