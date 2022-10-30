package br.com.mt.store.commons.domain.usecase.exampleobject.status;

import java.lang.reflect.InvocationTargetException;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum ExampleObjectStatusEnum {
	CREATED(ExampleObjectCreatedStatus.class),
	PROCESSING(ExampleObjectProcessingStatus.class),
	FINISHED(ExampleObjectFinishedStatus.class),
	CANCELED(ExampleObjectCanceledStatus.class);
	
	private Class<? extends ExampleObjectStatus> clazz;
	
	ExampleObjectStatusEnum(Class<? extends ExampleObjectStatus> clazz) {
		this.clazz = clazz;
	}

	public ExampleObjectStatus createExampleObjectStatus(ExampleObject exampleObject) {
		try {
			return (ExampleObjectStatus) this.clazz
				.getDeclaredConstructor(ExampleObject.class)
				.newInstance(exampleObject);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			log.error(e.getMessage(), e);
			throw new BusinessException(e.getMessage());
		}
	}
}
