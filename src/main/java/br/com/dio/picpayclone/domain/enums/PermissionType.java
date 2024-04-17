package br.com.dio.picpayclone.domain.enums;

import lombok.Getter;

@Getter
public enum PermissionType {

    USER("ROLE_USER"), ADMINISTRATOR("ROLE_ADMIN");

    private final String code;

    private PermissionType(String code) {
        this.code = code;
    }

}
