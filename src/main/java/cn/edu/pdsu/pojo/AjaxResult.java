package cn.edu.pdsu.pojo;

public class AjaxResult {
	private boolean success;
	private Object data;
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}