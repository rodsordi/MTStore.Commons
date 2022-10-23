package br.com.mt.store.commons.domain.exception;

import java.util.Set;

public class RequiredFieldException extends MTStoreException {

    public RequiredFieldException(String message) {
        super(message);
    }

    public RequiredFieldException(Set<String> errorMessages) {
        super(errorMessages);
    }
}
