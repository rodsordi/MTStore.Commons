package br.com.mt.store.commons.domain.exception;

import java.util.Set;

public class FormatException extends MTStoreException {

    public FormatException(String message) {
        super(message);
    }

    public FormatException(Set<String> errorMessages) {
        super(errorMessages);
    }
}
