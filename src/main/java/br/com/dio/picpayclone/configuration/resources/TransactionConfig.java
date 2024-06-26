package br.com.dio.picpayclone.configuration.resources;

import br.com.dio.picpayclone.application.converter.CreditCardConverter;
import br.com.dio.picpayclone.application.converter.TransactionConverter;
import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.ports.inbound.IListTransactionUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IProcessTransactionUseCase;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import br.com.dio.picpayclone.application.usecases.ListTransactionUseCase;
import br.com.dio.picpayclone.application.usecases.ProcessTransactionUseCase;
import br.com.dio.picpayclone.domain.services.ICreditCardService;
import br.com.dio.picpayclone.domain.services.IUserService;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.TransactionGateway;
import br.com.dio.picpayclone.infrastructure.web.mappers.TransactionRequestMapper;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public TransactionRequestMapper transactionRequestMapper(ModelMapper modelMapper) {
        return new TransactionRequestMapper(modelMapper);
    }

    @Bean
    public TransactionConverter transactionConverter(UserConverter userConverter, IUserService userService) {
        return new TransactionConverter(userConverter, userService);
    }

    @Bean
    public ITransactionGateway transactionGateway(TransactionRepository transactionRepository) {
        return new TransactionGateway(transactionRepository);
    }

    @Bean
    public IProcessTransactionUseCase processTransactionUseCase(
            CreditCardConverter creditCardConverter,
            TransactionConverter transactionConverter,
            IUserService userService,
            ICreditCardService creditCardService,
            ITransactionGateway transactionGateway) {
        return new ProcessTransactionUseCase(
                creditCardConverter,
                transactionConverter,
                userService,
                creditCardService,
                transactionGateway);
    }

    @Bean
    public IListTransactionUseCase listTransactionUseCase(
            ITransactionGateway transactionGateway,
            TransactionConverter transactionConverter) {
        return new ListTransactionUseCase(transactionGateway, transactionConverter);
    }

}
