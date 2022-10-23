package br.com.mt.store.commons.domain.exception;

import java.util.HashSet;
import java.util.Set;

public class BusinessException extends MTStoreException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Set<String> errorMessages) {
        super(errorMessages);
    }
}
