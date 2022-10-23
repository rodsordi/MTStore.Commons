package br.com.mt.store.commons.domain.exception;

import java.util.HashSet;
import java.util.Set;

public abstract class MTStoreException extends RuntimeException {
    private final Set<String> errorMessages = new HashSet<>();

    public MTStoreException(String message) {
        super(message);
        errorMessages.add(message);
    }

    public MTStoreException(Set<String> errorMessages) {
        super(errorMessages.stream().iterator().next());
        this.errorMessages.addAll(errorMessages);
    }

    public Set<String> getErrorMessages() {
        return errorMessages;
    }
}
