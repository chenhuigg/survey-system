package cn.edu.pdsu.pojo;

public class Survey {
	private String id;
	private String name;
	private int credit;//学分
	private String term;//学期
	private String version;//版本号
	private String create_time;//创建时间
	
	private String expires_time; //过期时间
	
	public String getExpires_time() {
		return expires_time;
	}
	public void setExpires_time(String expires_time) {
		this.expires_time = expires_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
