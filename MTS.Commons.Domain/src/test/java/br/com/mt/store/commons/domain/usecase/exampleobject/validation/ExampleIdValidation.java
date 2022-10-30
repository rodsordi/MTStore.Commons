package br.com.mt.store.commons.domain.usecase.exampleobject.validation;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.validation.Validation;

import java.util.Set;

public class ExampleIdValidation extends Validation<ExampleObject> {

    @Override
    protected void valideRequiredFields(Set<String> errorMessages, ExampleObject example) {
        if (example.getId() == null)
            errorMessages.add("validation.example.id.not_null");
    }

    @Override
    protected void valideFormat(Set<String> errorMessages, ExampleObject example) {
    	
    }
}
