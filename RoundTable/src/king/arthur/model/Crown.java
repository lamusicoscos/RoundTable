package king.arthur.model;

import king.arthur.strategy.SharedResourceMisuseDetector;

/**
 * RoundTable 核心角色管理进入到核心系统的全部业务的工具。
 * @author Aiden S. Zouliu
 *
 */
public final class Crown {
	
	private static final SharedResourceMisuseDetector detector = new SharedResourceMisuseDetector(Crown.class, 1);
	
	private Crown() { }
	
	public static final Crown of() {
		detector.increase();
		return new Crown();
	}
	
}
