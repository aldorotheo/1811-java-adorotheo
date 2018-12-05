package com.trms.trms;

public class Grade {
	private int grade_id;
	private int grade_type;
	private String passing;
	public int getGrade_id() {
		return grade_id;
	}

	public int getGrade_type() {
		return grade_type;
	}

	public String getPassing() {
		return passing;
	}

	public Grade(int grade_id, int grade_type, String passing) {
		super();
		this.grade_id = grade_id;
		this.grade_type = grade_type;
		this.passing = passing;
	}
	public Grade(int grade_type, String passing) {
		super();
		this.grade_id = grade_id;
		this.grade_type = grade_type;
		this.passing = passing;
	}
}
