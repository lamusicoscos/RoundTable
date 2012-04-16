package sir.perceval.strategy;

/**
 * RoundTable 系统的信息职能系统 Perceval 系统的信息来源通道。
 * @author Aiden S. Zouliu
 *
 */
public interface Pike {
	
	/**
	 * 启动信息来源通道的功能。
	 * @throws Exception 有任何异常发生，抛出该异常
	 */
	public void function() throws Exception;
	
	/**
	 * 停止信息来源通道的功能。
	 * @throws Exception 有任何异常发生，抛出该异常
	 */
	public void dismantle() throws Exception;

}
