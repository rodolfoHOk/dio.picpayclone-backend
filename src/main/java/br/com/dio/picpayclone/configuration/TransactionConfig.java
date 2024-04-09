package br.com.dio.picpayclone.configuration;

import br.com.dio.picpayclone.application.converter.CreditCardConverter;
import br.com.dio.picpayclone.application.converter.TransactionConverter;
import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.ports.inbound.IProcessTransactionUseCase;
import br.com.dio.picpayclone.application.ports.outbound.ICreditCardGateway;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.application.usecases.ProcessTransactionUseCase;
import br.com.dio.picpayclone.domain.services.ICreditCardService;
import br.com.dio.picpayclone.domain.services.IUserService;
import br.com.dio.picpayclone.domain.services.impl.CreditCardService;
import br.com.dio.picpayclone.domain.services.impl.UserService;
import br.com.dio.picpayclone.infrastructure.api.mappers.CreditCardRequestMapper;
import br.com.dio.picpayclone.infrastructure.api.mappers.UserRequestMapper;
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
    public CreditCardRequestMapper creditCardRequestMapper(ModelMapper modelMapper) {
        return new CreditCardRequestMapper(modelMapper);
    }

    @Bean
    public UserRequestMapper userRequestMapper(ModelMapper modelMapper) {
        return new UserRequestMapper(modelMapper);
    }

    @Bean
    public TransactionRequestMapper transactionRequestMapper(ModelMapper modelMapper) {
        return new TransactionRequestMapper(modelMapper);
    }

    @Bean
    public CreditCardConverter creditCardConverter(ModelMapper modelMapper, UserRepository userRepository) {
        return new CreditCardConverter(modelMapper, userService(userRepository));
    }

    @Bean
    public UserConverter userConverter(ModelMapper modelMapper) {
        return new UserConverter(modelMapper);
    }

    @Bean
    public TransactionConverter transactionConverter(ModelMapper modelMapper, UserRepository userRepository) {
        return new TransactionConverter(modelMapper, userService(userRepository));
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
            ModelMapper modelMapper,
            CreditCardRepository creditCardRepository,
            UserRepository userRepository) {
        return new CreditCardService(creditCardConverter(modelMapper, userRepository), creditCardGateway(creditCardRepository));
    }

    @Bean
    public IUserService userService(UserRepository userRepository) {
        return new UserService(userGateway(userRepository));
    }

    @Bean
    public IProcessTransactionUseCase processTransactionUseCase(
            ModelMapper modelMapper,
            UserRepository userRepository,
            TransactionRepository transactionRepository,
            CreditCardRepository creditCardRepository) {
        return new ProcessTransactionUseCase(
                transactionConverter(modelMapper, userRepository),
                userService(userRepository),
                creditCardService(modelMapper, creditCardRepository, userRepository),
                transactionGateway(transactionRepository));
    }
}
