package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.PageDTO;
import br.com.dio.picpayclone.application.dtos.PageableDTO;
import br.com.dio.picpayclone.application.dtos.TransactionDTO;

public interface IListTransactionUseCase {

    PageDTO<TransactionDTO> execute(PageableDTO pageable, String login);

}
