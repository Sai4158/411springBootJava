package psu.edu.mvcsecurity.dao;

import psu.edu.mvcsecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
