package study.jaspertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jaspertest.entity.ChartsData;

@Repository
public interface ChartsDataRepository extends JpaRepository<ChartsData, Long> {
}