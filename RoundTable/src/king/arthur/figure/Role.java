package king.arthur.figure;

import king.arthur.model.HealthDegree;
import king.arthur.model.RoleName;

/**
 * RoundTable 的角色类型定义。
 * @author Aiden S. Zouliu
 *
 */
public interface Role {

	/**
	 * 获悉该角色的健康程度。
	 * @return 该角色的健康程度
	 */
	public HealthDegree health();
	
	/**
	 * 获悉该角色的类型。
	 * @return 该角色的类型
	 */
	public Role role();
	
	/**
	 * 获悉该角色的名称。
	 * @return 该角色的名称。
	 */
	public RoleName name();
	
	/**
	 * 启动角色系统功能。
	 */
	public void crusade();
}
