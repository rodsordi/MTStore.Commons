package br.com.mt.store.commons.domain.usecase.exampleobject.status;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.exampleobject.statemachine.ExampleObjectStateMachine;

public class ExampleObjectCreatedStatus extends ExampleObjectStateMachine {
	
	ExampleObjectCreatedStatus(ExampleObject exampleObject) {
		super(exampleObject);
	}

	@Override
	public ExampleObjectStatus process() {
		return new ExampleObjectProcessingStatus(exampleObject);
	}

	@Override
	public ExampleObjectStatusEnum getExampleObjectStatusEnum() {
		return ExampleObjectStatusEnum.CREATED;
	}

}
