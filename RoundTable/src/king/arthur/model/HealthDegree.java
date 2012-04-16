package king.arthur.model;

/**
 * RoundTable 系统中的角色健康程度。
 * @author Aiden S. Zouliu
 *
 */
public enum HealthDegree {
	/**
	 * 残喘。
	 */
	ALIVE(),
	/**
	 * 虚弱。
	 */
	WEAK,
	/**
	 * 强壮。
	 */
	STRONG,
	/**
	 * 死亡。
	 */
	DEAD;
	
	/**
	 * 私有构造函数。防止在项目中被实例化。
	 */
	private HealthDegree() { }
	
}
