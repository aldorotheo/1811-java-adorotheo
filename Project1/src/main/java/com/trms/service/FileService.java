package com.trms.service;

import com.trms.db.FileDao;

public class FileService {
	private static FileDao fdao = new FileDao();
	
	public void insertFile(int req_id, String filename) {
		fdao.insertFile(req_id, filename);
	}
}
