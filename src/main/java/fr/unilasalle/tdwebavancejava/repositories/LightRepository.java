package fr.unilasalle.tdwebavancejava.repositories;

import fr.unilasalle.tdwebavancejava.models.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends JpaRepository<Light, Long> {

}
