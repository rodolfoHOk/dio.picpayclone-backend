package br.com.dio.picpayclone.infrastructure.web.resources;

import br.com.dio.picpayclone.application.dtos.PageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseResource<T> {

    protected ResponseEntity<T> createdItemResponse(T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    protected ResponseEntity<T> createdItemResponseWithURI(T object, UriComponentsBuilder uriBuilder, String path,
                                                           String code) {
        URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
        return ResponseEntity.created(uri).body(object);
    }

    protected ResponseEntity<T> itemNotFoundResponse() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> successResponse() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<T> successResponseWithItem(T object) {
        return ResponseEntity.status(HttpStatus.OK).body(object);
    }

    protected ResponseEntity<List<T>> emptyListResponse() {
        List<T> emptyList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(emptyList);
    }

    protected ResponseEntity<List<T>> itemsListResponse(List<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    protected ResponseEntity<T> badRequestResponse() {
        return ResponseEntity.badRequest().build();
    }

    protected ResponseEntity<PageDTO<T>> pagedItemsListResponse(PageDTO<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
}
