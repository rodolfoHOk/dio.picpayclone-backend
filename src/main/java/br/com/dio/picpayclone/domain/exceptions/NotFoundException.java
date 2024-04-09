package br.com.dio.picpayclone.domain.exceptions;

public class NotFoundException extends PicPayException {

    public NotFoundException(String message) {
        super(message);
    }
}
