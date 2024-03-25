package fr.unilasalle.tdwebavancejava.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DBException extends RuntimeException{
    private String message;
}
