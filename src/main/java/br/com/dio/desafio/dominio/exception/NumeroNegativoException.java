package br.com.dio.desafio.dominio.exception;

public class NumeroNegativoException extends RuntimeException {
    public NumeroNegativoException(){
        super("A carga horária deve ter no mínimo 1h");
    }

    public NumeroNegativoException(String message) {
        super(message);
    }
}
