package indi.zzw.constant;

/**
 * 角色名常量类，如果是配置security配置文件，请使用以CONFIG后缀命名的常量，如果是分配权限，请使用以DESTRIBUTION后缀命名的常量
 *
 */
public final class RoleNameConstant {
	private static final String ROLE_NAME_PREFIX = "ROLE_";

	//Spring-security 配置部分使用的角色名
	public static final String ROLE_ADMIN_FOR_CONFIG = "ADMIN";
	public static final String ROLE_STAFF_FOR_CONFIG = "STAFF";
	public static final String ROLE_CUSTOM_USER_FOR_CONFIG = "CUSTOMUSER";

	//使用端使用的角色名 格式：ROLE_NAME_PREFIX + 配置部分所对应的角色名
	public static final String ROLE_ADMIN_FOR_DESTRIBUTION = ROLE_NAME_PREFIX + ROLE_ADMIN_FOR_CONFIG;
	public static final String ROLE_STAFF_FOR_DESTRIBUTION = ROLE_NAME_PREFIX + ROLE_STAFF_FOR_CONFIG;
	public static final String ROLE_CUSTOM_USER_FOR_DESTRIBUTION = ROLE_NAME_PREFIX + ROLE_CUSTOM_USER_FOR_CONFIG;
}
