package fr.unilasalle.tdwebavancejava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotFoundException extends Throwable {
    private String message;
}
