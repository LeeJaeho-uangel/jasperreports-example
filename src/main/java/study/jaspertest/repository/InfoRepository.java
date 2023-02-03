package study.jaspertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jaspertest.entity.Info;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {
}