package study.cicdpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cicdpractice.domain.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
