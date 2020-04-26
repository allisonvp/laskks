package clase2.demo.repository;

import clase2.demo.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Integer> {
    List<Shipper> findByCompanyname(String companyName);

    @Query(value="select * from shippers where CompanyName= ?1", nativeQuery = true)
    List<Shipper> buscarTransportistasPorNombre(String name);
}
