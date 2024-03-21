package fr.unilasalle.tdwebavancejava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Light {
    private long id;
    private boolean toggle;
    private String color;
    private String title;




}
