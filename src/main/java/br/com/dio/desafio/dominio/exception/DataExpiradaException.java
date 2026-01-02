package br.com.dio.desafio.dominio.exception;

public class DataExpiradaException extends RuntimeException {
    public DataExpiradaException(){
        super("A data não pode anterior ao dia de hoje");
    }

    public DataExpiradaException(String message) {
        super(message);
    }
}
