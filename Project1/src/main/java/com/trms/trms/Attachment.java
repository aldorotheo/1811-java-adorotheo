package com.trms.trms;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Attachment {
	private int file_id;
	private int req_id;
	private InputStream file;
	private int a_type;
	
//	public void sendToFile(String filename) {
//		Files.copy(this.getFile(), filename, StandardCopyOption.REPLACE_EXISTING);
//	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	public int getA_type() {
		return a_type;
	}

	public void setA_type(int a_type) {
		this.a_type = a_type;
	}
}
