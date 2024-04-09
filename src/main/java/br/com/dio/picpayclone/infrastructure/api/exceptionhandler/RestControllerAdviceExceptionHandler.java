package br.com.dio.picpayclone.infrastructure.api.exceptionhandler;

import br.com.dio.picpayclone.infrastructure.api.dtos.ErrorDTO;
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
    List<ErrorDTO> handle(MethodArgumentNotValidException exception) {
        List<ErrorDTO> errorsDTOS = new ArrayList<>();
        var fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
            var message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorDTO errorDTO = new ErrorDTO(error.getField(), message);
            errorsDTOS.add(errorDTO);
        });
        return errorsDTOS;
    }
}
