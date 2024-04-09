package br.com.dio.picpayclone.domain.exceptions;

public class PicPayException extends RuntimeException {

    public PicPayException(String message, Throwable cause) {
        super(message, cause);
    }

    public PicPayException(String message) {
        super(message);
    }
}
