package com.trms.trms;

public class Event {
	private int event_id;
	private String event_type;
	private int event_coverage;
	public int getEvent_id() {
		return event_id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public int getEvent_coverage() {
		return event_coverage;
	}

	public Event(int event_id, String event_type, int event_coverage) {
		super();
		this.event_id = event_id;
		this.event_type = event_type;
		this.event_coverage = event_coverage;
	}

}
