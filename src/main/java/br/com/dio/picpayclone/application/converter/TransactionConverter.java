package br.com.dio.picpayclone.application.converter;

import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.domain.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class TransactionConverter extends BaseConverter<Transaction, TransactionDTO> {

    private final ModelMapper modelMapper;
    private final IUserService userService;

    public TransactionConverter(ModelMapper modelMapper, IUserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public TransactionDTO entityToDtoConverter(Transaction entity) {
        return modelMapper.map(entity, TransactionDTO.class);
    }

    @Override
    public Transaction dtoToEntityConverter(TransactionDTO dto) {
        return Transaction.builder()
                .code(dto.code())
                .dateTime(dto.dateTime())
                .amount(dto.amount())
                .destination(userService.findByLogin(dto.destination().login()))
                .origin(userService.findByLogin(dto.origin().login()))
                .build();
    }

    @SuppressWarnings("unchecked")
    public Page<TransactionDTO> pageEntityToDtoConverter(Page<Transaction> entity) {
        return modelMapper.map(entity, Page.class);
    }
}
