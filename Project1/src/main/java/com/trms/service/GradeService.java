package com.trms.service;

import com.trms.db.GradeDao;
import com.trms.trms.Grade;

public class GradeService {
	private GradeDao dao = new GradeDao();
	public int getGradeId(int gradeType, String pass) {
		Grade grade = new Grade(gradeType, pass);
		return dao.findGradeID(grade);
	}
}
