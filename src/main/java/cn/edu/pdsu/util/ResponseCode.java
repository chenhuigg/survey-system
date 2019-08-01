package cn.edu.pdsu.util;

public enum ResponseCode {
	SUCCESS(true),
	ERROR(false);
	private final boolean success ;
	private ResponseCode(boolean success) {
		this.success=success;
	}
	public boolean getCode() {
		return success;
	}
}
