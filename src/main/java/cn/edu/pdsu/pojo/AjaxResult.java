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
	 * �ɹ�������һ��code
	 */
	public static <T> AjaxResult<T> createBySuccess(){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		return ajaxResult;
	}
	
	/**
	 * �ɹ�������һ����ʾ��Ϣ
	 */
	public static <T> AjaxResult<T> createBySuccessMsg(String msg){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		ajaxResult.setMsg(msg);
		return ajaxResult;
	}
	
	/**
	 * �ɹ�����������
	 */
	public static<T> AjaxResult<T> createBySuccessData(T data){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		ajaxResult.setData(data);
		return ajaxResult;
	}
	
	/**
	 * �ɹ���������ʾ��Ϣ������
	 */
	public static<T> AjaxResult<T> createSuccessMsgData(String msg,T data){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.SUCCESS.getCode());
		ajaxResult.setMsg(msg);
		ajaxResult.setData(data);
		return ajaxResult;
	}
	
	/**
	 * ʧ�ܣ�����code
	 */
	public static<T> AjaxResult<T> createByError(){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setSuccess(ResponseCode.ERROR.getCode());
		return ajaxResult;
	}
	
	/**
	 * ʧ�ܣ�������ʾ��Ϣ
	 */
	public static<T> AjaxResult<T> createByErrorMsg(String msg){
		AjaxResult<T> ajaxResult=new AjaxResult<>();
		ajaxResult.setMsg(msg);
		return ajaxResult;
	}
	
}