package cn.edu.pdsu.aop;

public class CommitException extends Exception{
	private static final long serialVersionUID = 1L;

	public CommitException() {
		super("表单重复提交");
	}
}
