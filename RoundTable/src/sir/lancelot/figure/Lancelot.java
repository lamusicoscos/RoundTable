package sir.lancelot.figure;

import sir.lancelot.model.Award;
import king.arthur.exception.TooManyActiveInstancesException;
import king.arthur.figure.KingRole;
import king.arthur.figure.Role;
import king.arthur.figure.ServantRole;
import king.arthur.model.HealthDegree;
import king.arthur.model.RoleName;
import king.arthur.strategy.SharedResourceMisuseDetector;

import static king.arthur.strategy.Checker.checkNotNull;

/**
 * RoundTable 系统的业务职能系统 Lancelot 的实例。
 * @author Aiden S. Zouliu
 *
 */
public class Lancelot implements ServantRole {

	private static final SharedResourceMisuseDetector detector = new SharedResourceMisuseDetector(Lancelot.class, 1); // 实例化泛滥检测
	
	private final RoleName roleName; // 角色名称
	private HealthDegree healthDegree; // 角色健康度
	
	/**
	 * 私有构造函数。防止在项目中被实例化。
	 * @param roleName 业务职能系统 Lancelot 系统的角色名称
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 为 null 时抛出此异常
	 */
	private Lancelot(final RoleName roleName) {
		checkNotNull(roleName);
		detector.increase();
		this.roleName = roleName;
		this.healthDegree = HealthDegree.WEAK;
	}
	
	/**
	 * 实例化业务职能系统 Lancelot。
	 * @return 业务职能系统 Lancelot
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 */
	public static Lancelot of() {
		final RoleName roleName = RoleName.of("Sir Lancelot");
		return of(roleName);
	}
	
	/**
	 * 给定业务职能系统 Lancelot 系统的角色名称以实例化 Lancelot 系统。
	 * @param roleName 业务系统 Lancelot 系统的角色名称
	 * @return 业务职能系统 Lancelot
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 为 null 时抛出此异常
	 */
	protected static Lancelot of(final RoleName roleName) {
		checkNotNull(roleName);
		return new Lancelot(roleName);
	}
	
	@Override
	public HealthDegree health() {
		// FIXME 根据压力情况动态返回健康程度
		return healthDegree;
	}

	@Override
	public RoleName name() {
		return roleName;
	}

	@Override
	public boolean becomeServant(KingRole king) {
		checkNotNull(king);
		final boolean admission = king.estimateServant(this);
		if (admission) {
			king.enrollServant(this);
		}
		
		return admission;
	}

	@Override
	public void blandish(Award award) {
		// TODO
		checkNotNull(award);
	}
	
	@Override
	public void crusade() {
		// TODO
	}

	@Override
	public Role role() {
		return this;
	}
	
}
