package king.arthur.figure;

import java.util.LinkedList;
import java.util.List;

import sir.lancelot.model.Award;
import king.arthur.exception.AwardException;
import king.arthur.exception.TooManyActiveInstancesException;
import king.arthur.model.Crown;
import king.arthur.model.HealthDegree;
import king.arthur.model.RoleName;
import king.arthur.strategy.SharedResourceMisuseDetector;

import static king.arthur.strategy.Checker.checkNotNull;

/**
 * RoundTable 系统的核心系统实例。
 * @author Aiden S. Zouliu
 *
 */
public final class KingArthur implements KingRole {
	
	private static final SharedResourceMisuseDetector detector = new SharedResourceMisuseDetector(KingArthur.class, 1); // 实例化泛滥检测
	
	private final RoleName roleName; // 角色名称
	private HealthDegree healthDegree; // 角色健康度
	private final Crown crown; // 业务控制工具
	private List<ServantRole> servants; // 职能系统集
	
	/**
	 * 私有构造函数。防止在项目中被实例化。
	 * @param roleName 核心系统实例角色名
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 或 <code>crown</code> 为 null 时抛出此异常
	 */
	private KingArthur(final RoleName roleName, final Crown crown) {
		checkNotNull(roleName, crown);
		detector.increase();
		this.roleName = roleName;
		this.healthDegree = HealthDegree.WEAK;
		this.crown = crown;
		this.servants = new LinkedList<ServantRole>();
	}
	
	/**
	 * 实例化核心系统。
	 * @return 核心系统实例化对象
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>crown</code> 为 null 时抛出此异常
	 */
	public static KingArthur of(final Crown crown) {
		final RoleName roleName = RoleName.of("King Arthur");
		return of(roleName, crown);
	}
	
	/**
	 * 给定核心系统的角色名称以实例化核心系统。
	 * @param roleName 核心系统的角色名称
	 * @param crown 业务控制工具
	 * @return 核心系统实例化对象
	 * @throws TooManyActiveInstancesException 实例化超过最大实例化上限时抛出此异常
	 * @throws NullPointerException <code>roleName</code> 或 <code>crown</code> 为 null 时抛出此异常
	 */
	protected static KingArthur of(final RoleName roleName, final Crown crown) {
		return new KingArthur(roleName, crown);
	}

	@Override
	public HealthDegree health() {
		// FIXME 根据压力情况动态返回健康程度
		return healthDegree;
	}

	@Override
	public void dismissServant(final ServantRole servant) {
		// TODO
		checkNotNull(servant);
		servants.remove(servant);
	}
	
	@Override
	public void punishServant(final ServantRole servant) {
		// TODO
		checkNotNull(servant);
	}

	@Override
	public void enrollServant(final ServantRole servant) {
		// TODO
		checkNotNull(servant);
		servants.add(servant);
	}

	@Override
	public boolean estimateServant(final Role servant) {
		// FIXME 根据系统的健康度等各项能力指标来评估
		return true;
	}
	
	@Override
	public ServantRole decideServant(final Award award){
		// TODO
		checkNotNull(award);
		return null;
	}
	
	@Override
	public void enfeoff(final Award award, final ServantRole servant) throws AwardException {
		// TODO
		checkNotNull(award, servant);
		servant.blandish(award);
	}
	
	@Override
	public void crusade() {
		try {
			final Thread forkThread = new Thread() {
				@Override
				public void run() {
					for (ServantRole servant : servants) {
						servant.crusade();
					}
				}
			};
			forkThread.start();
			forkThread.join();
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
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
