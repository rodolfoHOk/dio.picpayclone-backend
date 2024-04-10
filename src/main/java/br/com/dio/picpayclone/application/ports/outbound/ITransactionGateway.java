package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.domain.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransactionGateway {

    Transaction save(Transaction transaction);

    Page<Transaction> findAllByLogin(Pageable pageable, String login);
}
