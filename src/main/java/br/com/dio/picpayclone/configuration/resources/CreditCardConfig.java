package br.com.dio.picpayclone.configuration.resources;

import br.com.dio.picpayclone.application.converter.CreditCardConverter;
import br.com.dio.picpayclone.application.ports.outbound.ICreditCardGateway;
import br.com.dio.picpayclone.domain.services.ICreditCardService;
import br.com.dio.picpayclone.domain.services.IUserService;
import br.com.dio.picpayclone.domain.services.impl.CreditCardService;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.CreditCardGateway;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.CreditCardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardConfig {

    @Bean
    public CreditCardConverter creditCardConverter(ModelMapper modelMapper, IUserService userService) {
        return new CreditCardConverter(modelMapper, userService);
    }

    @Bean
    ICreditCardGateway creditCardGateway(CreditCardRepository creditCardRepository) {
        return new CreditCardGateway(creditCardRepository);
    }

    @Bean
    public ICreditCardService creditCardService(
            CreditCardConverter creditCardConverter,
            ICreditCardGateway creditCardGateway) {
        return new CreditCardService(creditCardGateway);
    }

}
