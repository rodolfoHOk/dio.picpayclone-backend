package br.com.dio.picpayclone.application.converter;

import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.domain.models.User;
import org.modelmapper.ModelMapper;

import java.time.format.DateTimeFormatter;

public class UserConverter extends BaseConverter<User, UserDTO> {

    private final ModelMapper modelMapper;

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO entityToDtoConverter(User entity) {
        return UserDTO.builder()
                .login(entity.getLogin())
                .email(entity.getEmail())
                .completeName(entity.getCompleteName())
                .cpf(entity.getCpf())
                .birthday(entity.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .phoneNumber(entity.getPhoneNumber())
                .balance(entity.getBalance())
                .build();
    }

    @Override
    public User dtoToEntityConverter(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}
