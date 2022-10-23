package br.com.mt.store.commons.domain;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExampleObject {
	private Long id;
	private String name;
	private Character type;
	private Instant createdAt;
}
