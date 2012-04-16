package sir.gawain.model;

/**
 * Gawain 系统中可以显示的存储系统的类型。
 * @author Aiden S. Zouliu
 *
 */
public enum StorageType {
	/**
	 * 数据库存储系统。
	 */
	DATABASE,
	/**
	 * Memcache存储系统。
	 */
	MEMCACHE,
	/**
	 * Redis存储系统。
	 */
	REDIS;
	
	/**
	 * 私有构造函数。防止在项目中被实例化。
	 */
	private StorageType() { }
	
}
