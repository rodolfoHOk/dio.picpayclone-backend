package br.com.dio.picpayclone.application.converter;

import br.com.dio.picpayclone.application.dtos.PageDTO;
import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.domain.services.IUserService;

import java.time.OffsetDateTime;

public class TransactionConverter extends BaseConverter<Transaction, TransactionDTO> {

    private final UserConverter userConverter;
    private final IUserService userService;

    public TransactionConverter(UserConverter userConverter, IUserService userService) {
        this.userConverter = userConverter;
        this.userService = userService;
    }

    @Override
    public TransactionDTO entityToDtoConverter(Transaction entity) {
        return TransactionDTO.builder()
                .code(entity.getCode())
                .origin(userConverter.entityToDtoConverter(entity.getOrigin()))
                .destination(userConverter.entityToDtoConverter(entity.getDestination()))
                .dateTime(entity.getDateTime().toString())
                .amount(entity.getAmount())
                .build();
    }

    @Override
    public Transaction dtoToEntityConverter(TransactionDTO dto) {
        return Transaction.builder()
                .code(dto.getCode())
                .dateTime(OffsetDateTime.parse(dto.getDateTime()))
                .amount(dto.getAmount())
                .destination(userService.findByLogin(dto.getDestination().getLogin()))
                .origin(userService.findByLogin(dto.getOrigin().getLogin()))
                .build();
    }

    public PageDTO<TransactionDTO> pageEntityToDtoConverter(PageDTO<Transaction> entity) {
        PageDTO<TransactionDTO> dto = new PageDTO<TransactionDTO>();
        dto.setNumber(entity.getNumber());
        dto.setSize(entity.getSize());
        dto.setTotalPages(entity.getTotalPages());
        dto.setTotalElements(entity.getTotalElements());
        dto.setContent(this.entitiesToDtosConverter(entity.getContent()));
        return dto;
    }
}
