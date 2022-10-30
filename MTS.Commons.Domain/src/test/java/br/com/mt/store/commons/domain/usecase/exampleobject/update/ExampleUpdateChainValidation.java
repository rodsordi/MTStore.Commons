package br.com.mt.store.commons.domain.usecase.exampleobject.update;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.exampleobject.validation.ExampleIdValidation;
import br.com.mt.store.commons.domain.usecase.exampleobject.validation.ExampleNameValidation;
import br.com.mt.store.commons.domain.usecase.exampleobject.validation.ExampleTypeValidation;
import br.com.mt.store.commons.domain.validation.Validation;

public class ExampleUpdateChainValidation {

    private Validation<ExampleObject> validation;

    public ExampleUpdateChainValidation() {
        validation = new ExampleIdValidation()
                .linkWith(new ExampleNameValidation())
                .linkWith(new ExampleTypeValidation())
                .getFirst();
    }

    public void execute(ExampleObject example) {
        validation.execute(example);
    }

}
