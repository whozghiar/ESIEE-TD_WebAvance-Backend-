package fr.unilasalle.tdwebavancejava.controllers;

import fr.unilasalle.tdwebavancejava.model.Light;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lights")
public class LightController {
    @GetMapping
    public ResponseEntity<Light> getLight() {
        Light light = new Light();
        light.setId(1);
        light.setToggle(true);
        light.setTitle("Salon");
        light.setColor("#FFFFFF"); // No color (black)

        return new ResponseEntity<>(light, HttpStatus.OK);
    }
}
