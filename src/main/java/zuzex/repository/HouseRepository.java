package zuzex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuzex.model.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
