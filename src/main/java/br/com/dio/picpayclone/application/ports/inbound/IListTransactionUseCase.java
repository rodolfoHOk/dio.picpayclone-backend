package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IListTransactionUseCase {

    Page<TransactionDTO> execute(Pageable pageable, String login);
}
