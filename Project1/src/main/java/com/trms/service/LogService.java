package com.trms.service;

import com.trms.db.LogDao;

public class LogService {
	private static LogDao dao = new LogDao();
	public void log(String log) {
		dao.log(log);
	}
}
