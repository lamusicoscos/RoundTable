package king.arthur.strategy;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import king.arthur.exception.TooManyActiveInstancesException;

/**
 * 检测某些在项目中应该被共享的资源被泛滥地实例化。
 * @author Aiden S. Zouliu
 *
 */
public class SharedResourceMisuseDetector {

	private static final int MAX_ACTIVE_INSTANCE = 64; // 默认最大实例化数
	
	private final AtomicInteger activeInstances = new AtomicInteger(); // 实例化数
	private final AtomicBoolean warned = new AtomicBoolean(); // 是否被警告过
	private final int maxActiveInstance; // 最大实例化数
	
	private final Class<?> type; // 共享资源类型

	/**
	 * 共有构造函数。指定共享资源类型 type ，生成一个最大实例化数默认为 64 的资源滥用检测类。
	 * @param type 共享资源类型
	 */
	public SharedResourceMisuseDetector(final Class<?> type) {
		this(type, MAX_ACTIVE_INSTANCE);
	}
	
	/**
	 * 共有构造函数。指定共享资源类型 type ，生成一个最大实例化数为 maxActiveInstance 的资源滥用检测类。
	 * @param type 共享资源类型
	 * @param maxActiveInstance 最大实例化数
	 * @throws IllegalArgumentException 当指定的最大实例化数为负数或 0 时，抛出此异常
	 */
	public SharedResourceMisuseDetector(final Class<?> type, final int maxActiveInstance) throws IllegalArgumentException {
		if (null == type) {
			throw new NullPointerException("SharedResourceMisuseDetector constructor param type == null");
		}
		if (maxActiveInstance <= 0) {
			throw new IllegalArgumentException("SharedResourceMisuseDetector constructor param maxActiveInstance must be > 0");
		}
		this.type = type;
		this.maxActiveInstance = maxActiveInstance;
	}
	
	/**
	 * 增加一个当前类型的资源共享类实例化数。如果总实例化的个数大于最大实例化数，且之前没有抛出过警告，会抛出一个异常以警告该共享资源被滥用。
	 * @throws TooManyActiveInstancesException 当总共实例化的个数大于最大实例化数时，抛出此异常。
	 */
	public void increase() throws TooManyActiveInstancesException {
		if (activeInstances.incrementAndGet() > maxActiveInstance) {
			if (warned.compareAndSet(false, true)) {
				throw new TooManyActiveInstancesException("You are creating too many " + type.getSimpleName() +
                        " instances(DEFAULTS TO: " + maxActiveInstance + ", CURRENT: " + activeInstances.get() + "). " + type.getSimpleName() +
                        " is a shared resource that must be reused across the" +
                        " application, so that only a few instances are created.");
			}
		}
	}
	
	/**
	 * 减少一个当前类型的资源共享类实例化数。
	 */
	public void decrease() {
		activeInstances.decrementAndGet();
	}
	
}
