package com.jm.shoppingcart.services;

import java.util.Set;

import com.jm.shoppingcart.entities.Permission;


public interface AuthorizationService {
	public Set<Permission> getPermissions(int roleId);

}
