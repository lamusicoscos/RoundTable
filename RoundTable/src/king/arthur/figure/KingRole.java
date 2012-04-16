package king.arthur.figure;

import sir.lancelot.model.Award;
import king.arthur.exception.AwardException;

/**
 * RoundTable 的核心角色类型定义。
 * @author Aiden S. Zouliu
 *
 */
public interface KingRole extends Role {
	
	/**
	 * 解除 RoundTable 核心系统的某个 <code>servant</code> 职能系统。
	 * @param servant 职能系统
	 */
	public void dismissServant(final ServantRole servant);
	
	/**
	 * 惩罚 RoundTable 核心系统的某个 <code>servant</code> 职能系统。
	 * @param servant 职能系统
	 */
	public void punishServant(final ServantRole servant);
	
	/**
	 * 招募一个 <code>servant</code> 系统为 RoundTable 核心系统的一个职能系统。
	 * @param servant 系统
	 */
	public void enrollServant(final ServantRole servant);
	
	/**
	 * 考核一个 <code>servant</code> 系统，检验是否可以成为 RoundTable 核心系统的一个职能系统。
	 * @param servant 系统
	 * @return true 则可以成为职能系统，否则返回 false。
	 */
	public boolean estimateServant(final Role servant);
	
	/**
	 * 根据需要执行的业务 <code>award</code> 的类型，决定由哪一个职能系统来执行该业务。
	 * @param award 需要执行的业务
	 * @return 执行该业务的职能系统
	 */
	public ServantRole decideServant(final Award award);
	
	/**
	 * 核心系统将需要执行的业务逻辑 <code>award</code> 封赏给 RoundTable 的职能系统以执行相应的处理。
	 * @param award 需要执行的业务逻辑
	 * @param servant 将要执行该业务逻辑的职能系统
	 * @throws AwardException 执行该业务逻辑失败时抛出该异常
	 */
	public void enfeoff(final Award award, final ServantRole servant) throws AwardException;
	
}
