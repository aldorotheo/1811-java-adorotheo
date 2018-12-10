package com.trms.trms;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

public class Request {
	private int req_id; //request id
	private int emp_id; //employee id
	private Date s_date; //start date
	private Time s_time; //start time
	private LocalDateTime a_date; //last accepted date, for use with auto-approval system
	private String s_location; //location
	private String description; //description
	private double s_cost; //cost
	private int g_format; //grading format
	private int ev_type; //event type
	private String just; //justification
	private String t_missed; //time missed (string so they can enter in values like "1 week"
	private int status; //status for determining what stage the application/request is at
	private int urgency;
	private int changedcost;
	private String finalg = "";
	public int getUrgency() {
		return urgency;
	}
	public void setUrgency(int urgency) {
		this.urgency = urgency;
	}
	public int getReq_id() {
		return req_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public int getChangedcost() {
		return changedcost;
	}
	public void setChangedcost(int changedcost) {
		this.changedcost = changedcost;
	}
	public Date getS_date() {
		return s_date;
	}
	public Time getS_time() {
		return s_time;
	}
	public LocalDateTime getA_date() {
		return a_date;
	}
	public void setA_date(LocalDateTime a_date) {
		this.a_date = a_date;
	}
	public String getS_location() {
		return s_location;
	}
	public String getDescription() {
		return description;
	}
	public double getS_cost() {
		return s_cost;
	}
	public int getG_format() {
		return g_format;
	}
	public String getFinalg() {
		return finalg;
	}
	public void setFinalg(String finalg) {
		this.finalg = finalg;
	}
	public int getEv_type() {
		return ev_type;
	}
	public String getJust() {
		return just;
	}
	public String getT_missed() {
		return t_missed;
	}
	public void setT_missed(String t_missed) {
		this.t_missed = t_missed;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Request(int req_id, int emp_id, Date s_date, Time s_time, LocalDateTime a_date, String s_location,
			String description, double s_cost, int g_format, int ev_type, String just, String t_missed, int status) {
		super();
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.s_date = s_date;
		this.s_time = s_time;
		this.a_date = a_date;
		this.s_location = s_location;
		this.description = description;
		this.s_cost = s_cost;
		this.g_format = g_format;
		this.ev_type = ev_type;
		this.just = just;
		this.t_missed = t_missed;
		this.status = status;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public void setS_time(Time s_time) {
		this.s_time = s_time;
	}
	public void setS_location(String s_location) {
		this.s_location = s_location;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setS_cost(double s_cost) {
		this.s_cost = s_cost;
	}
	public void setG_format(int g_format) {
		this.g_format = g_format;
	}
	public void setEv_type(int ev_type) {
		this.ev_type = ev_type;
	}
	public void setJust(String just) {
		this.just = just;
	}
	public Request(int emp_id, Date s_date, Time s_time, String s_location,
			String description, double s_cost, int g_format, int ev_type, String just, String t_missed, int status) {
		super();
		this.emp_id = emp_id;
		this.s_date = s_date;
		this.s_time = s_time;
		this.s_location = s_location;
		this.description = description;
		this.s_cost = s_cost;
		this.g_format = g_format;
		this.ev_type = ev_type;
		this.just = just;
		this.t_missed = t_missed;
		this.status = status;
		this.finalg="";
	}
	public Request(int emp_id, Date s_date, Time s_time, String s_location,
			String description, double s_cost, int g_format, int ev_type, String just, String t_missed, int status, String finalg) {
		super();
		this.emp_id = emp_id;
		this.s_date = s_date;
		this.s_time = s_time;
		this.s_location = s_location;
		this.description = description;
		this.s_cost = s_cost;
		this.g_format = g_format;
		this.ev_type = ev_type;
		this.just = just;
		this.t_missed = t_missed;
		this.status = status;
		this.finalg = finalg;
	}
	public Request(int emp_id, Date s_date, Time s_time, LocalDateTime a_date, String s_location,
			String description, double s_cost, int g_format, int ev_type, String just, String t_missed, int status) {
		super();
		this.emp_id = emp_id;
		this.s_date = s_date;
		this.s_time = s_time;
		this.a_date = a_date;
		this.s_location = s_location;
		this.description = description;
		this.s_cost = s_cost;
		this.g_format = g_format;
		this.ev_type = ev_type;
		this.just = just;
		this.t_missed = t_missed;
		this.status = status;
		this.finalg="";
	}
	public Request() {
	}
	public Request(int req_id, int emp_id, Date s_date, Time s_time, LocalDateTime a_date, String s_location, String description,
			double s_cost, int g_format, int ev_type, String just, String t_missed, int status, String finalg) {
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.s_date = s_date;
		this.s_time = s_time;
		this.a_date = a_date;
		this.s_location = s_location;
		this.description = description;
		this.s_cost = s_cost;
		this.g_format = g_format;
		this.ev_type = ev_type;
		this.just = just;
		this.t_missed = t_missed;
		this.status = status;
		this.finalg = finalg;
	}
	public Request(int req_id, int emp_id, Date s_date, Time s_time, LocalDateTime a_date, String s_location, String description,
			double s_cost, int g_format, int ev_type, String just, String t_missed, int status, int urgency, String finalg) {
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.s_date = s_date;
		this.s_time = s_time;
		this.a_date = a_date;
		this.s_location = s_location;
		this.description = description;
		this.s_cost = s_cost;
		this.g_format = g_format;
		this.ev_type = ev_type;
		this.just = just;
		this.t_missed = t_missed;
		this.status = status;
		this.urgency = urgency;
		this.finalg = finalg;
	}
	@Override
	public String toString() {
		return "Request ID: " + req_id + " Employee: " + emp_id + " Date: " + s_date + " Time: " + s_time
				+ " Location: " + s_location + " Description: '" + description + "' Amount: "
				+ s_cost + " Grading Format:" + g_format + " Event Type: " + ev_type + " Justification: '" + just + "' Time Missed: "
				+ t_missed + " Final: " + finalg + "\n";
	}
	
}
