package br.com.mt.store.commons.domain.usecase.example.save;

import br.com.mt.store.commons.domain.ExampleObject;

public class ExampleSaveUseCase {

    private final ExampleSaveChainValidation exampleSaveChainValidation;

    public ExampleSaveUseCase(ExampleSaveChainValidation exampleSaveChainValidation) {
        this.exampleSaveChainValidation = exampleSaveChainValidation;
    }

    ExampleObject execute(ExampleObject example) {
        exampleSaveChainValidation.execute(example);
        return example;
    }

}
