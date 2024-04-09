package br.com.dio.picpayclone.application.converter;

import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.domain.models.User;
import org.modelmapper.ModelMapper;

public class UserConverter extends BaseConverter<User, UserDTO> {

    private final ModelMapper modelMapper;

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO entityToDtoConverter(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User dtoToEntityConverter(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}
