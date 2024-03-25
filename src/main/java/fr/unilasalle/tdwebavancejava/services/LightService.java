package fr.unilasalle.tdwebavancejava.services;
import fr.unilasalle.tdwebavancejava.exceptions.DBException;
import fr.unilasalle.tdwebavancejava.models.Light;
import fr.unilasalle.tdwebavancejava.repositories.LightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LightService {

    private final LightRepository lightRepository;

    public List<Light> getAllLights() {
        return this.lightRepository.findAll();
    }

    public Light updateLight(Light light) {
        try {
            Light lightUpdated = this.lightRepository.save(light);
            return lightUpdated;
        } catch (DBException e) {
            throw new DBException("Error while updating light");
        }
    }
}
