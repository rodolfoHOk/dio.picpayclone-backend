package br.com.dio.picpayclone.infrastructure.api.mappers;

import br.com.dio.picpayclone.application.dtos.CreditCardDTO;
import br.com.dio.picpayclone.infrastructure.api.requests.CreditCardRequest;
import org.modelmapper.ModelMapper;

public class CreditCardRequestMapper {

    private final ModelMapper modelMapper;

    public CreditCardRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CreditCardDTO toDto(CreditCardRequest request) {
        return modelMapper.map(request, CreditCardDTO.class);
    }
}
