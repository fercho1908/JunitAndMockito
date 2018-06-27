package com.j4guanatos.banxico.exception;

/**
 * Created by prueba on 10/11/16.
 */
public class BanxicoException extends Exception {

    public BanxicoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BanxicoException(String message) {
        super(message);
    }
}
