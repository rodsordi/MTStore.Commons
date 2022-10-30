package br.com.mt.store.commons.domain.usecase.exampleobject.status;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.exampleobject.statemachine.ExampleObjectStateMachine;

public class ExampleObjectProcessingStatus extends ExampleObjectStateMachine {

	ExampleObjectProcessingStatus(ExampleObject exampleObject) {
		super(exampleObject);
	}

	@Override
	public ExampleObjectStatus finish() {
		return new ExampleObjectFinishedStatus(exampleObject);
	}

	@Override
	public ExampleObjectStatus cancel() {
		return new ExampleObjectCanceledStatus(exampleObject);
	}

	@Override
	public ExampleObjectStatusEnum getExampleObjectStatusEnum() {
		return ExampleObjectStatusEnum.PROCESSING;
	}
	
}
