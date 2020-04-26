package clase2.demo.repository;

import clase2.demo.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryRepository extends JpaRepository<Territory,String> {
}
