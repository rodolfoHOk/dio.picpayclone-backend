package br.com.dio.picpayclone.application.converter;

import br.com.dio.picpayclone.application.dtos.CreditCardDTO;
import br.com.dio.picpayclone.domain.models.CreditCard;
import br.com.dio.picpayclone.domain.services.IUserService;
import br.com.dio.picpayclone.utils.CreditCardUtils;
import org.modelmapper.ModelMapper;

public class CreditCardConverter extends BaseConverter<CreditCard, CreditCardDTO> {

    private final ModelMapper modelMapper;
    private final IUserService userService;

    public CreditCardConverter(ModelMapper modelMapper, IUserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public CreditCardDTO entityToDtoConverter(CreditCard entity) {
        return modelMapper.map(entity, CreditCardDTO.class);
    }

    @Override
    public CreditCard dtoToEntityConverter(CreditCardDTO dto) {
        return CreditCard.builder()
                .banner(dto.banner())
                .number(CreditCardUtils.mask(dto.number()))
                .tokenNumber(dto.tokenNumber())
                .user(userService.findByLogin(dto.user().login()))
                .build();
    }
}
