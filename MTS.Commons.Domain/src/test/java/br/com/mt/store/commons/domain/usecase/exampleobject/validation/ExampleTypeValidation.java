package br.com.mt.store.commons.domain.usecase.exampleobject.validation;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.validation.Validation;

import java.util.Set;

public class ExampleTypeValidation extends Validation<ExampleObject> {

    @Override
    protected void valideRequiredFields(Set<String> errorMessages, ExampleObject example) {
        if (example.getType() == null || "".equals(example.getType()))
            errorMessages.add("validation.example.type.not_blank");
    }

    @Override
    protected void valideFormat(Set<String> errorMessages, ExampleObject example) {
        if (!example.getType().toString().matches("[ABC]"))
            errorMessages.add("validation.example.type.must_be_ABC");
    }
}
