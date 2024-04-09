package br.com.dio.picpayclone.infrastructure.api.exceptionhandler;

import br.com.dio.picpayclone.domain.exceptions.BusinessException;
import br.com.dio.picpayclone.domain.exceptions.NotFoundException;
import br.com.dio.picpayclone.infrastructure.api.responses.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerAdviceExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<ErrorResponse> errors = new ArrayList<>();
        var fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
            var message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorResponse errorDTO = new ErrorResponse(error.getField(), message);
            errors.add(errorDTO);
        });
        return errors;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleBusiness(BusinessException exception) {
        return new ErrorResponse(null, exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFound(NotFoundException exception) {
        return new ErrorResponse(null, exception.getMessage());
    }
}
