package br.com.dio.picpayclone.infrastructure.web.mappers;

import br.com.dio.picpayclone.application.dtos.LoginDTO;
import br.com.dio.picpayclone.infrastructure.web.requests.LoginRequest;
import org.modelmapper.ModelMapper;

public class LoginRequestMapper {

    private final ModelMapper modelMapper;

    public LoginRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LoginDTO toDto(LoginRequest request) {
        return modelMapper.map(request, LoginDTO.class);
    }

}
