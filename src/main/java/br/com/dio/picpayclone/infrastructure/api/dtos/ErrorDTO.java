package br.com.dio.picpayclone.infrastructure.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDTO(

    String field,

    String message
) {

}
