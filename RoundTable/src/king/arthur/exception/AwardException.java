package king.arthur.exception;

/**
 * RoundTable 核心系统职能系统执行业务异常。
 * @author Aiden S. Zoulius
 *
 */
public class AwardException extends RuntimeException {

	private static final long serialVersionUID = 5475100045839431003L;

	/**
	 * 构造函数。不含有任何详细信息。
	 */
	public AwardException() {
		super();
	}
	
	/**
	 * 构造函数。包含详细信息。
	 * @param s 详细信息
	 */
	public AwardException(final String s) {
		super(s);
	}
	
	/**
	 * 构造函数。包含详细信息和异常原因。
	 * @param message 详细信息
	 * @param cause 异常原因
	 */
	public AwardException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * 构造函数。包含异常原因。
	 * @param cause 异常原因
	 */
	public AwardException(final Throwable cause) {
		super(cause);
	}
	
}
