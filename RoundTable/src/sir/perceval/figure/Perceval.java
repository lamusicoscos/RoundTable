package sir.perceval.figure;

import static king.arthur.strategy.Checker.checkNotNull;

import java.util.LinkedList;
import java.util.List;

import king.arthur.exception.TooManyActiveInstancesException;
import king.arthur.figure.KingRole;
import king.arthur.figure.Role;
import king.arthur.figure.ServantRole;
import king.arthur.model.HealthDegree;
import king.arthur.model.RoleName;
import king.arthur.strategy.SharedResourceMisuseDetector;
import sir.lancelot.model.Award;
import sir.perceval.strategy.Pike;

/**
 * RoundTable 系统的信息职能系统 Perceval 的实例。
 * @author Aiden S. Zouliu
 *
 */
public class Perceval implements ServantRole {

	private static final SharedResourceMisuseDetector detector = new SharedResourceMisuseDetector(Perceval.class, 1); // 实例化泛滥检测
	
	private final RoleName roleName; // 角色名称
	private HealthDegree healthDegree; // 角色健康度
	
	private List<Pike> armours; // 信息来源通道集
	
	/**
	 * 私有构造函数。防止在项目中被实例化。
	 * @param roleName 信息职能系统 Perceval 系统的角色名称
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 为 null 时抛出此异常
	 */
	private Perceval(final RoleName roleName) {
		checkNotNull(roleName);
		detector.increase();
		this.roleName = roleName;
		this.healthDegree = HealthDegree.WEAK;
		this.armours = new LinkedList<Pike>();
	}
	
	/**
	 * 实例化信息职能系统 Perceval。
	 * @return 信息职能系统 Perceval
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 */
	public static Perceval of() {
		final RoleName roleName = RoleName.of("Sir Perceval");
		return of(roleName);
	}
	
	/**
	 * 给定信息职能系统 Perceval 系统的角色名称以实例化 Perceval 系统。
	 * @param roleName 业务系统 Perceval 系统的角色名称
	 * @return 信息职能系统 Perceval
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 为 null 时抛出此异常
	 */
	protected static Perceval of(final RoleName roleName) {
		checkNotNull(roleName);
		return new Perceval(roleName);
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
	
	/**
	 * 添加一个信息职能系统 Perceval 系统的信息来源通道。
	 * @param pike 信息来源通道
	 * @throws Exception 信息来源在添加过程中发生异常时，抛出该异常
	 */
	public void arm(final Pike pike) throws Exception {
		checkNotNull(pike);
		armours.add(pike);
	}
	
	/**
	 * 关闭一个信息职能系统 Perceval 系统的信息来源通道。
	 * @param pike 信息来源通道
	 * @throws 信息来源在关闭过程中发生异常时，抛出该异常
	 */
	public void disarm(final Pike pike) throws Exception {
		checkNotNull(pike);
		int slot = armours.indexOf(pike);
		if (-1 != slot) {
			pike.dismantle();
			armours.remove(slot);
		}
	}
	
	@Override
	public void crusade() {
		// TODO
		for (Pike armour : armours) {
			try {
				armour.function();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Role role() {
		return this;
	}
	
}
