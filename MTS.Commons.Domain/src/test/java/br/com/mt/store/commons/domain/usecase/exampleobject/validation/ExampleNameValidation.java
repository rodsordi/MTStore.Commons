package br.com.mt.store.commons.domain.usecase.exampleobject.validation;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.validation.Validation;

import java.util.Set;

public class ExampleNameValidation extends Validation<ExampleObject> {

    @Override
    protected void valideRequiredFields(Set<String> errorMessages, ExampleObject example) {
        if (example.getName() == null || "".equals(example.getName()))
            errorMessages.add("validation.example.name.not_blank");

    }

    @Override
    protected void valideFormat(Set<String> errorMessages, ExampleObject example) {
        if (!example.getName().matches("[^\\d]+"))
            errorMessages.add("validation.example.name.must_not_contain_digits");
    }

}
