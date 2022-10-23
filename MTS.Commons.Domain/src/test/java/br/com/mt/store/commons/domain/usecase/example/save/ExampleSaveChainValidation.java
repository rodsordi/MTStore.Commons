package br.com.mt.store.commons.domain.usecase.example.save;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.example.validation.ExampleIdValidation;
import br.com.mt.store.commons.domain.usecase.example.validation.ExampleNameValidation;
import br.com.mt.store.commons.domain.usecase.example.validation.ExampleTypeValidation;
import br.com.mt.store.commons.domain.validation.Validation;

public class ExampleSaveChainValidation {

    private Validation<ExampleObject> validation;

    public ExampleSaveChainValidation() {
        validation = new ExampleIdValidation()
                .linkWith(new ExampleNameValidation())
                .linkWith(new ExampleTypeValidation())
                .getFirst();
    }

    public void execute(ExampleObject example) {
        validation.execute(example);
    }

}
