package com.trms.trms;

public class Alert {
	private int messageID;
	private int senderID;
	private int receiverID;
	private String message;
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getSenderID() {
		return senderID;
	}
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
	public int getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Alert [messageID=" + messageID + ", senderID=" + senderID + ", receiverID=" + receiverID + ", message="
				+ message + "]";
	}
	public Alert(int messageID, int senderID, int receiverID, String message) {
		super();
		this.messageID = messageID;
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.message = message;
	}
	public Alert() {
		
	}
}
