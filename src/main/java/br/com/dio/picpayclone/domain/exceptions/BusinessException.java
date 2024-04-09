package br.com.dio.picpayclone.domain.exceptions;

public class BusinessException extends PicPayException {
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }
}
