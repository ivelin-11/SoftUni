package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ApartmentRepository  extends JpaRepository<Apartment,Long> {

    @Query
    Optional<Apartment> findByAreaAndTown(BigDecimal area, Town town);
}
