package king.arthur.strategy;

/**
 * 一些边界，条件等策略检测方法。
 * @author Aiden S. Zouliu
 *
 */
public final class Checker {
	
	/**
	 * 私有的构造函数，防止在项目中被实例化。
	 */
	private Checker() { }

	/**
	 * 检测限制类条件“待检测对象不为空”，如果待检测对象为 null 时，
	 * 抛出 {@link java.lang.NullPointerException NullPointerException} 异常。
	 * @param object 待检测的对象实例
	 * @throws NullPointerException 当待检测的对象实例为 null 时抛出此异常
	 */
	public static void checkNotNull(final Object object) throws NullPointerException {
		if (null == object) {
			throw new NullPointerException();
		}
	}
	
	/**
	 * 检测限制类条件“待检测对象群不为空”，如果待检测对象群中任意一个为 null 时，
	 * 抛出 {@link java.lang.NullPointerException NullPointerException} 异常。
	 * @param objects 待检测的对象实例群
	 * @throws NullPointerException 当待检测的对象实例为 null 时抛出此异常
	 */
	public static void checkNotNull(final Object...objects) throws NullPointerException {
		if (null == objects) {
			throw new NullPointerException();
		}
		for (Object obj : objects) {
			if (null == obj) {
				throw new NullPointerException();
			}
		}
	}
	
}
