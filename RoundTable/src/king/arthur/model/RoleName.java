package king.arthur.model;

import king.arthur.exception.InvalidRoleException;

/**
 * 角色的名字。
 * @author Aiden S. Zouliu
 *
 */
public final class RoleName {

	private final String roleName; // 角色的字符串名字
	
	/**
	 * 私有构造函数。防止在项目中被直接实例化。
	 * @param roleName 角色的字符串名字
	 */
	private RoleName(final String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * 提供角色的字符串名字，生成该字符串名字的角色名字对象。
	 * @param roleName 角色的字符串名字
	 * @return 该字符串名字的角色名字对象
	 * @throws InvalidRoleException 角色的字符串名字不可行时抛出该异常
	 */
	public static final RoleName of(final String roleName) throws InvalidRoleException {
		if (checkAvailability(roleName)) {
			return new RoleName(roleName);
		}
		
		throw new InvalidRoleException("Invalid String type role name");
	}
	
	/**
	 * 检查该字符串名字的可行性。
	 * @param name 角色的字符串名字
	 * @return true 表示该字符串名字可行，false 表示不可行
	 */
	private static final boolean checkAvailability(final String name) {
		return true;
	}
	
	@Override
	public final String toString() {
		return roleName;
	}
	
	@Override
	public final boolean equals(final Object anotherRoleName) {
		if (null == anotherRoleName) {
			return false;
		}
		if (this == anotherRoleName) {
			return true;
		}
		if (!(anotherRoleName instanceof RoleName)) {
			return false;
		}
		
		final RoleName target = (RoleName) anotherRoleName;
		
		return roleName.equalsIgnoreCase(target.roleName);
	}
}
