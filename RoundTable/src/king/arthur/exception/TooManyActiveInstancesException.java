package king.arthur.exception;

/**
 * 实例化对象超过实例化个数限制异常。
 * @author Aiden S. Zouliu
 *
 */
public class TooManyActiveInstancesException extends RuntimeException {
	
	private static final long serialVersionUID = 4124522694241538060L;

	/**
	 * 构造函数。包含详细信息。
	 * @param s 详细信息
	 */
	public TooManyActiveInstancesException(String s) {
		super(s);
	}
	
	/**
	 * 构造函数。不含有任何详细信息。
	 */
	public TooManyActiveInstancesException() {
		super();
	}
	
	/**
	 * 构造函数。包含详细信息和异常原因。
	 * @param message 详细信息
	 * @param cause 异常原因
	 */
	public TooManyActiveInstancesException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * 构造函数。包含异常原因。
	 * @param cause 异常原因
	 */
	public TooManyActiveInstancesException(final Throwable cause) {
		super(cause);
	}
}
