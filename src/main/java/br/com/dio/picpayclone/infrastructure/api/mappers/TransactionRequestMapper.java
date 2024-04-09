package br.com.dio.picpayclone.infrastructure.api.mappers;

import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.infrastructure.api.requests.TransactionRequest;
import org.modelmapper.ModelMapper;

public class TransactionRequestMapper {

    private final ModelMapper modelMapper;

    public TransactionRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TransactionDTO toDto(TransactionRequest request) {
        return modelMapper.map(request, TransactionDTO.class);
    }
}
