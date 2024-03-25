package fr.unilasalle.tdwebavancejava.controllers;
import fr.unilasalle.tdwebavancejava.exceptions.DBException;
import fr.unilasalle.tdwebavancejava.exceptions.NotFoundException;
import fr.unilasalle.tdwebavancejava.models.Light;
import fr.unilasalle.tdwebavancejava.services.LightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lights")
@RequiredArgsConstructor
@Slf4j
public class LightController {

    private final LightService lightService;

    @GetMapping
    public ResponseEntity<List<Light>> getLight() {
        log.info("Getting all lights ...");
        List<Light> lights = this.lightService.getAllLights();
        return new ResponseEntity<>(lights, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Light> postLight(@RequestBody Light lightSent) {
        try{
            log.info("Creating light ...");
            return lightSent.getId() == null ?
                    new ResponseEntity<>(this.lightService.updateLight(lightSent), HttpStatus.CREATED) :
                    new ResponseEntity<>(this.lightService.updateLight(lightSent), HttpStatus.ACCEPTED);
        } catch (DBException e){
            log.error("Error while creating light", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NotFoundException e) {
            log.error("Could not find light with id " + lightSent.getId(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLight(@PathVariable Long id) {
        try {
            log.info("Deleting light with id " + id);
            this.lightService.deleteLight(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            log.error("Could not find light with id " + id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (DBException e) {
            log.error("Error while deleting light with id " + id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
