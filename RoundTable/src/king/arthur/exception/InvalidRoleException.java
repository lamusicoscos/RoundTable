package king.arthur.exception;

/**
 * 非法角色异常。
 * @author Aiden S. Zouliu
 *
 */
public class InvalidRoleException extends RuntimeException {

	private static final long serialVersionUID = 5791964616375987775L;

	/**
	 * 构造函数。不含有任何详细信息。
	 */
	public InvalidRoleException() {
		super();
	}
	
	/**
	 * 构造函数。包含详细信息。
	 * @param s 详细信息
	 */
	public InvalidRoleException(final String s) {
		super(s);
	}
	
	/**
	 * 构造函数。包含详细信息和异常原因。
	 * @param message 详细信息
	 * @param cause 异常原因
	 */
	public InvalidRoleException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * 构造函数。包含异常原因。
	 * @param cause 异常原因
	 */
	public InvalidRoleException(final Throwable cause) {
		super(cause);
	}
	
}
