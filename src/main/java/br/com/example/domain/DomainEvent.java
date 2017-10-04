package br.com.example.domain;

import java.util.Date;

public interface DomainEvent {

	String aggregateId();
	
	int eventVersion();

	Date occorredOn();
}
