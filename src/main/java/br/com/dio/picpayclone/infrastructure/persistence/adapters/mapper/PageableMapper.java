package br.com.dio.picpayclone.infrastructure.persistence.adapters.mapper;

import br.com.dio.picpayclone.application.dtos.PageableDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableMapper {

    public static Pageable toEntity(PageableDTO dto) {
        var sort = Sort.by(dto.getSort().stream().map(sortString -> {
            String[] splitSortString = sortString.split(",");
            String property = splitSortString[0];
            String orderString = splitSortString[1];
            Sort.Direction direction = null;
            if (!orderString.isEmpty()) {
                orderString = orderString.toUpperCase();
                if (orderString.equals("ASC")) direction = Sort.Direction.ASC;
                else if (orderString.equals("DESC")) direction = Sort.Direction.DESC;
            }
            return new Sort.Order(direction, property);
        }).toList());
        return PageRequest.of(dto.getPage(), dto.getSize(), sort);
    }

}
