package cn.edu.pdsu.pojo;

import cn.edu.pdsu.util.ResponseCode;

public class AjaxResult <T>{
	private boolean success;
	private String msg;
	
	private T data;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 成功，返回一个code
	 */
	public static <T> AjaxResult<T> createBySuccess(){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		return ajaxResult;
	}
	
	/**
	 * 成功，返回一个提示信息
	 */
	public static <T> AjaxResult<T> createBySuccessMsg(String msg){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		ajaxResult.setMsg(msg);
		return ajaxResult;
	}
	
	/**
	 * 成功，返回数据
	 */
	public static<T> AjaxResult<T> createBySuccessData(T data){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		ajaxResult.setData(data);
		return ajaxResult;
	}
	
	/**
	 * 成功，返回提示信息和数据
	 */
	public static<T> AjaxResult<T> createSuccessMsgData(String msg,T data){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		ajaxResult.setMsg(msg);
		ajaxResult.setData(data);
		return ajaxResult;
	}
	
	/**
	 * 失败，返回code
	 */
	public static<T> AjaxResult<T> createByError(){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.ERROR.getCode());
		return ajaxResult;
	}
	
	/**
	 * 失败，返回提示信息
	 */
	public static<T> AjaxResult<T> createByErrorMsg(String msg){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setMsg(msg);
		return ajaxResult;
	}
	
}