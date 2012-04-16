package sir.gawain.figure;

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
 * RoundTable 系统的后台管理职能系统 Gawain 系统的实例。
 * @author Aiden S. Zouliu
 *
 */
public final class Gawain implements ServantRole {
	
	private static final SharedResourceMisuseDetector detector = new SharedResourceMisuseDetector(Gawain.class, 1); // 实例化泛滥检测

	private final RoleName roleName; // 角色名称
	private HealthDegree healthDegree; // 角色健康度
	
	/**
	 * 私有构造函数。防止在项目中被实例化。
	 * @param roleName 后台管理职能系统 Gawain 系统的角色名称
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 为 null 时抛出此异常
	 */
	private Gawain(final RoleName roleName) {
		checkNotNull(roleName);
		detector.increase();
		this.roleName = roleName;
		this.healthDegree = HealthDegree.WEAK;
	}
	
	/**
	 * 实例化后台管理职能系统 Gawain。
	 * @return 后台管理职能系统 Gawain
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 */
	public static Gawain of() {
		final RoleName roleName = RoleName.of("Sir Gawain");
		return of(roleName);
	}
	
	/**
	 * 给定后台管理职能系统 Gawain 系统的角色名称以实例化 Gawain 系统。
	 * @param roleName 后台管理职能系统 Gawain 系统的角色名称
	 * @return 后台管理职能系统 Gawain
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 为 null 时抛出此异常
	 */
	protected static Gawain of(final RoleName roleName) {
		checkNotNull(roleName);
		return new Gawain(roleName);
	}
	
	@Override
	public HealthDegree health() {
		// FIXME 根据压力情况动态返回健康程度
		return healthDegree;
	}

	@Override
	public final boolean becomeServant(KingRole king) {
		checkNotNull(king);
		final boolean admission = king.estimateServant(this);
		if (admission) {
			king.enrollServant(this);
		}
		
		return admission;
	}
	
	@Override
	public void blandish(final Award award) {
		// TODO
		checkNotNull(award);
	}
	
	@Override
	public boolean applyable(final Award award) {
		// TODO
		return true;
	}
	
	@Override
	public void crusade() {
		// TODO
	}

	@Override
	public final RoleName name() {
		return roleName;
	}
	
	@Override
	public Role role() {
		return this;
	}

}
