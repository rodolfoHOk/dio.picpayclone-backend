package br.com.dio.picpayclone.infrastructure.web.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    String field,
    String message
) {

}
