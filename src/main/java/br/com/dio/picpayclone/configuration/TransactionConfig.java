package br.com.dio.picpayclone.configuration;

import br.com.dio.picpayclone.application.converter.CreditCardConverter;
import br.com.dio.picpayclone.application.converter.TransactionConverter;
import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.ports.inbound.IListTransactionUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IProcessTransactionUseCase;
import br.com.dio.picpayclone.application.ports.outbound.ICreditCardGateway;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.application.usecases.ListTransactionUseCase;
import br.com.dio.picpayclone.application.usecases.ProcessTransactionUseCase;
import br.com.dio.picpayclone.domain.services.ICreditCardService;
import br.com.dio.picpayclone.domain.services.IUserService;
import br.com.dio.picpayclone.domain.services.impl.CreditCardService;
import br.com.dio.picpayclone.domain.services.impl.UserService;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.CreditCardGateway;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.TransactionGateway;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.UserGateway;
import br.com.dio.picpayclone.infrastructure.api.mappers.TransactionRequestMapper;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.CreditCardRepository;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.TransactionRepository;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TransactionRequestMapper transactionRequestMapper(ModelMapper modelMapper) {
        return new TransactionRequestMapper(modelMapper);
    }

    @Bean
    public CreditCardConverter creditCardConverter(ModelMapper modelMapper, IUserService userService) {
        return new CreditCardConverter(modelMapper, userService);
    }

    @Bean
    public UserConverter userConverter(ModelMapper modelMapper) {
        return new UserConverter(modelMapper);
    }

    @Bean
    public TransactionConverter transactionConverter(ModelMapper modelMapper, IUserService userService) {
        return new TransactionConverter(modelMapper, userService);
    }

    @Bean ICreditCardGateway creditCardGateway(CreditCardRepository creditCardRepository) {
        return new CreditCardGateway(creditCardRepository);
    }

    @Bean
    public IUserGateway userGateway(UserRepository userRepository) {
        return new UserGateway(userRepository);
    }

    @Bean
    public ITransactionGateway transactionGateway(TransactionRepository transactionRepository) {
        return new TransactionGateway(transactionRepository);
    }

    @Bean
    public ICreditCardService creditCardService(
            CreditCardConverter creditCardConverter,
            ICreditCardGateway creditCardGateway) {
        return new CreditCardService(creditCardConverter, creditCardGateway);
    }

    @Bean
    public IUserService userService(IUserGateway userGateway) {
        return new UserService(userGateway);
    }

    @Bean
    public IProcessTransactionUseCase processTransactionUseCase(
            TransactionConverter transactionConverter,
            IUserService userService,
            ICreditCardService creditCardService,
            ITransactionGateway transactionGateway) {
        return new ProcessTransactionUseCase(
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
