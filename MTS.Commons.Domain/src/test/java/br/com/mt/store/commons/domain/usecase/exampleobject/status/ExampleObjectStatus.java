package br.com.mt.store.commons.domain.usecase.exampleobject.status;

public interface ExampleObjectStatus {
	public ExampleObjectStatus process();
	
	public ExampleObjectStatus finish();

	public ExampleObjectStatus cancel();
	
	public ExampleObjectStatusEnum getExampleObjectStatusEnum();
}
