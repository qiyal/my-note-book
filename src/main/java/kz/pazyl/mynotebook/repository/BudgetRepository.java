package kz.pazyl.mynotebook.repository;

import kz.pazyl.mynotebook.model.entity.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {

}
