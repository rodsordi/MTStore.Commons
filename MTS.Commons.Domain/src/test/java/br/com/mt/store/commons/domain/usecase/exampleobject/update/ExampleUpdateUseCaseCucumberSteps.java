package br.com.mt.store.commons.domain.usecase.exampleobject.update;

/*import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import br.com.mt.store.commons.domain.Example;
import br.com.mt.store.commons.domain.exception.MTStoreException;
import br.com.mt.store.commons.domain.usecase.example.save.ExampleSaveChainValidation;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleUpdateUseCaseCucumberSteps {

    private ExampleUpdateUseCase exampleSaveUseCase;
    private Example.ExampleBuilder builder;
    private Example example;
    private Example actual;
    private MTStoreException mtStoreException;

    //Mocks

    @Before
    public void before() {
        builder = Example.builder();
        
        exampleSaveUseCase = new ExampleUpdateUseCase(new ExampleSaveChainValidation());
    }

    @After
    public void after() {
        builder = null;
        example = null;
        actual = null;
        example = null;
    }

    @Given("a valid Example")
    public void aValidExample() {
        withTheId(1l);
        withTheName("Example Name");
        withTheType("A");
    }

    @Given("an empty Example")
    public void anEmptyExample() {
        builder = Example.builder();
    }

    @And("with the Id {long}")
    public void withTheId(Long id) {
        builder.id(id);
    }

    @And("with the Name {string}")
    public void withTheName(String name) {
        builder.name(name);
    }

    @And("with the Type {string}")
    public void withTheType(String type) {
        builder.type(type.charAt(0));
    }

    @When("save Example")
    public void saveExample() {
        example = builder.build();
        actual = exampleSaveUseCase.execute(example);
    }

    @When("trying to save Example")
    public void tryingToSaveExample() {
        try {
            example = builder.build();
            exampleSaveUseCase.execute(example);
            fail();
        } catch(MTStoreException e) {
            mtStoreException = e;
        }
    }

    @Then("Example is saved")
    public void exampleIsSaved() {
        assertNotNull(actual);
        assertEquals(actual.getName(), example.getName());
        assertEquals(actual.getType(), example.getType());
    }

    @Then("throws {int} validation errors")
    public void throwsValidationErrors(int validationErrorsQtd, List<String> validationErrors) {
        assertNotNull(mtStoreException);
        var errorMessages = mtStoreException.getErrorMessages();
        assertTrue(errorMessages.size() > 0);

        for (String validationError : validationErrors)
            assertThat(errorMessages, hasItem(validationError));

        assertTrue(errorMessages.size() == validationErrorsQtd);
    }

    @Then("throws the validation error {string}")
    public void throwsTheValidationError(String errorMessage) {
        assertNotNull(mtStoreException);
        var message = mtStoreException.getMessage();
        assertNotNull(message);
        assertEquals(errorMessage, message);
    }
}*/