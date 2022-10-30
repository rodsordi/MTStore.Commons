package br.com.mt.store.commons.domain.usecase.exampleobject.status;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.exampleobject.statemachine.ExampleObjectStateMachine;

public class ExampleObjectCanceledStatus extends ExampleObjectStateMachine {

	ExampleObjectCanceledStatus(ExampleObject exampleObject) {
		super(exampleObject);
	}

	@Override
	public ExampleObjectStatusEnum getExampleObjectStatusEnum() {
		return ExampleObjectStatusEnum.CANCELED;
	}

}
