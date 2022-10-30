package br.com.mt.store.commons.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import br.com.mt.store.commons.domain.exception.BusinessException;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectStatus;
import br.com.mt.store.commons.domain.usecase.exampleobject.status.ExampleObjectStatusEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExampleObject {
	private ExampleObjectStatus status;
	private UUID id;
	private String name;
	private Character type;
	private BigDecimal value;
	private Instant createdAt;
	private Instant updatedAt;
	
	public void process() {
		status = status.process();
	}
	
	public void finish() {
		status = status.finish();
	}
	
	public void cancel() {
		status = status.cancel();
	}
	
	public static CustomExampleObjectBuilder builder() {
		return new CustomExampleObjectBuilder();
	}
	
	public static class CustomExampleObjectBuilder extends ExampleObjectBuilder {
		private ExampleObjectStatusEnum exampleObjectStatusEnum;
		
		public CustomExampleObjectBuilder status(ExampleObjectStatusEnum exampleObjectStatusEnum) {
			this.exampleObjectStatusEnum = exampleObjectStatusEnum;
			return this;
		}
		
		@Override
		public ExampleObject build() {
			if (exampleObjectStatusEnum == null)
				throw new BusinessException("Must have status");
			
			ExampleObject exampleObject = super.build();
			exampleObject.status = exampleObjectStatusEnum.createExampleObjectStatus(exampleObject);
			return exampleObject;
		}
	}
}
