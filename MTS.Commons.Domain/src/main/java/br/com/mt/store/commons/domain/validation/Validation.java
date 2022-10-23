package br.com.mt.store.commons.domain.validation;

import br.com.mt.store.commons.domain.exception.BusinessException;
import br.com.mt.store.commons.domain.exception.RequiredFieldException;

import java.util.HashSet;
import java.util.Set;

public abstract class Validation<T> extends ChainLink {

    protected abstract void valideRequiredFields(Set<String> errorMessages, T t);

    protected abstract void valideFormat(Set<String> errorMessages, T t);

    public void execute(T t) {
        Set<String> errorMessages = new HashSet<>();

        valideRequiredFields(errorMessages, t);
        valideNextsRequiredFields(errorMessages, t);

        if (!errorMessages.isEmpty())
            throw new RequiredFieldException(errorMessages);

        valideFormat(errorMessages, t);
        valideNextsFormats(errorMessages, t);

        if (!errorMessages.isEmpty())
            throw new BusinessException(errorMessages);
    }

    private void valideNextsRequiredFields(Set<String> errorMessages, T t) {
        this.<Validation<T>>next()
                .ifPresent(validation -> {
                    validation.valideRequiredFields(errorMessages, t);
                    validation.valideNextsRequiredFields(errorMessages, t);
                });
    }

    private void valideNextsFormats(Set<String> errorMessages, T t) {
        this.<Validation<T>>next()
                .ifPresent(validation -> {
                    validation.valideFormat(errorMessages, t);
                    validation.valideNextsFormats(errorMessages, t);
                });
    }

}
