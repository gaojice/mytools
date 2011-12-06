package thread;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.NestedRuntimeException;

/**
 * 业务异常基类
 * 
 * @author lin
 * @since 2007-6-4
 */
public class BusinessException extends NestedRuntimeException {

	private static final long serialVersionUID = -5685505318215175895L;

	/**
	 * 错误代码,默认为未知错误
	 */
	protected String errorCode = "UNKNOW_ERROR";

	/**
	 * 错误信息中的参数
	 */
	protected String[] errorArgs = null;

	/**
	 * 兼容纯错误信息，不含error code,errorArgs的情况
	 */
	private String errorMessage = null;

	static private ResourceBundle rb = ResourceBundle.getBundle("i18n/messages", LocaleContextHolder.getLocale());

	public BusinessException() {
		super("UNKNOW_ERROR");
	}

	public BusinessException(String errorCode, String... errorArgs) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	public BusinessException(String errorCode, Throwable t, String... errorArgs) {
		super(errorCode, t);
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	public BusinessException(String errorMessage) {
		super("UNKNOW_ERROR");
		this.errorMessage = errorMessage;
	}

	public BusinessException(String errorMessage, Throwable t) {
		super("UNKNOW_ERROR", t);
		this.errorMessage = errorMessage;
	}

	/**
	 * 获得出错信息. 读取i18N properties文件中Error Code对应的message,并组合参数获得i18n的出错信息.
	 */
	public String getMessage() {
		// 如果errorMessage不为空,直接返回出错信息.
		if (errorMessage != null) {
			return errorMessage;
		}
		// 否则用errorCode查询Properties文件获得出错信息
		String message;
		try {
			message = rb.getString(errorCode);
		} catch (MissingResourceException mse) {
			message = "ErrorCode is: " + errorCode + ", but can't get the message of the Error Code";
		}

		// 将出错信息中的参数代入到出错信息中
		if (errorArgs != null)
			message = MessageFormat.format(message, (Object[]) errorArgs);

		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}
}