package com.batch.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SamplePayload {
	
	@JsonProperty("event_type")
	private String event_Type;

	public String getEvent_Type() {
		return event_Type;
	}

	public void setEvent_Type(String event_Type) {
		this.event_Type = event_Type;
	}
}
