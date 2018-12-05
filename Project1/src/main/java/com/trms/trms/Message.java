package com.trms.trms;

public class Message {
	private int message_id;
	private int sender_id;
	private int receiver_id;
	private String message;
	private int check;
	public int getMessage_id() {
		return message_id;
	}
	public int getSender_id() {
		return sender_id;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public String getMessage() {
		return message;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public Message(int message_id, int sender_id, int receiver_id, String message, int check) {
		super();
		this.message_id = message_id;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.message = message;
		this.check = check;
	}
}
