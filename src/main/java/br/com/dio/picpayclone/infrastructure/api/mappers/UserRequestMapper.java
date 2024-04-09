package br.com.dio.picpayclone.infrastructure.api.mappers;

import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.infrastructure.api.requests.UserRequest;
import org.modelmapper.ModelMapper;

public class UserRequestMapper {

    private final ModelMapper modelMapper;

    public UserRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDto(UserRequest request) {
        return modelMapper.map(request, UserDTO.class);
    }
}
