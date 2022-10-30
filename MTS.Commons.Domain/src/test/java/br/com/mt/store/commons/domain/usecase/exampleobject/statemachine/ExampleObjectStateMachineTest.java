package br.com.mt.store.commons.domain.usecase.exampleobject.statemachine;

import static org.junit.Assert.assertTrue;

import java.time.format.DateTimeFormatter;

import org.junit.Test;

import br.com.mt.store.commons.domain.ExampleObject;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectCanceledStatus;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectFinishedStatus;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectProcessingStatus;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectStatusEnum;

public class ExampleObjectStateMachineTest {
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Test
	public void process_created() {
		// Given
		var exampleObject = ExampleObject.builder()
				.status(ExampleObjectStatusEnum.CREATED)
				.build();
		// When
		exampleObject.process();
		// Then
		assertTrue(exampleObject.getStatus() instanceof ExampleObjectProcessingStatus);
	}
	
	@Test
	public void finish_processing() {
		// Given
		var exampleObject = ExampleObject.builder()
				.status(ExampleObjectStatusEnum.PROCESSING)
				.build();
		// When
		exampleObject.finish();
		// Then
		assertTrue(exampleObject.getStatus() instanceof ExampleObjectFinishedStatus);
	}
	
	@Test
	public void cancel_finished() {
		// Given
		var exampleObject = ExampleObject.builder()
				.status(ExampleObjectStatusEnum.PROCESSING)
				.build();
		// When
		exampleObject.cancel();
		// Then
		assertTrue(exampleObject.getStatus() instanceof ExampleObjectCanceledStatus);
	}
}
