package king.arthur.figure;

import sir.lancelot.model.Award;

/**
 * RoundTable 的职能角色类型定义。
 * @author Aiden S. Zouliu
 *
 */
public interface ServantRole extends Role {

	/**
	 * 成为 RoundTable 核心系统中的一个职能系统。
	 * @param king
	 * @return
	 */
	public boolean becomeServant(final KingRole king);
	
	/**
	 * 该职能系统执行被核心系统封赏的业务逻辑 <code>award</code>。
	 * @param award 需要执行的业务逻辑
	 */
	public void blandish(final Award award);
	
}
