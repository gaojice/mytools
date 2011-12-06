package jms;

import org.springframework.core.NestedRuntimeException;

public class CfException extends NestedRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2467126151597455035L;
	private Long taskId;

	public CfException(Long taskId, Throwable cause, String msg) {
		super(msg, cause);
		this.taskId = taskId;
	}

	public Long getTaskId() {
		return taskId;
	}

}
