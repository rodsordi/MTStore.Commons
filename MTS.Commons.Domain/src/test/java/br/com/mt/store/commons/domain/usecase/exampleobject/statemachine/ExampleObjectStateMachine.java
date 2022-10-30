package br.com.mt.store.commons.domain.usecase.exampleobject.statemachine;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.exception.BusinessException;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectStatus;

public abstract class ExampleObjectStateMachine implements ExampleObjectStatus {
	
	protected final ExampleObject exampleObject;
	
	public ExampleObjectStateMachine(ExampleObject exampleObject) {
		this.exampleObject = exampleObject;
	}

	@Override
	public ExampleObjectStatus process() {
		throw new BusinessException("Cannot process");
	}
	
	@Override
	public ExampleObjectStatus finish() {
		throw new BusinessException("Cannot finish");
	}

	@Override
	public ExampleObjectStatus cancel() {
		throw new BusinessException("Cannot cancel");
	}
	
}
