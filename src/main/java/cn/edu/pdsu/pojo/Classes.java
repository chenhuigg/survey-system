package cn.edu.pdsu.pojo;

public class Classes {
	private String id;
	private String name;
	private Grade grade;
	private Major major;
	
	private String expires_time;//存放中间表的过期时间
	private String classes_id;//用于判断班级是否发布信息
	
	public String getClasses_id() {
		return classes_id;
	}
	public void setClasses_id(String classes_id) {
		this.classes_id = classes_id;
	}
	public String getExpires_time() {
		return expires_time;
	}
	public void setExpires_time(String expires_time) {
		this.expires_time = expires_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
}
