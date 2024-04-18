package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.application.dtos.PageDTO;
import br.com.dio.picpayclone.application.dtos.PageableDTO;
import br.com.dio.picpayclone.domain.models.Transaction;

public interface ITransactionGateway {

    Transaction save(Transaction transaction);

    PageDTO<Transaction> findAllByLogin(PageableDTO pageable, String login);
}
