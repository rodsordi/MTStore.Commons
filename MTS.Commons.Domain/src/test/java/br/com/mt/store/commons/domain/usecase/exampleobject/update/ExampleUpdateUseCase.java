package br.com.mt.store.commons.domain.usecase.exampleobject.update;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.example.save.ExampleSaveChainValidation;

public class ExampleUpdateUseCase {

    private final ExampleSaveChainValidation exampleSaveChainValidation;

    public ExampleUpdateUseCase(ExampleSaveChainValidation exampleSaveChainValidation) {
        this.exampleSaveChainValidation = exampleSaveChainValidation;
    }

    ExampleObject execute(ExampleObject example) {
        exampleSaveChainValidation.execute(example);
        return example;
    }

}
