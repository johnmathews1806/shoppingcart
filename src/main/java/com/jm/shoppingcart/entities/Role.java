package com.jm.shoppingcart.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ROLES")
public class Role implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	
	@OneToMany(mappedBy="role")
	@Transient
	private Set<User> users = new HashSet();
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = { javax.persistence.CascadeType.ALL })
	@JoinTable(
	        name = "role_permission", 
	        joinColumns = { @JoinColumn(name = "role_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "permission_id") }
	    )
	private Set<Permission> permissions = new HashSet<Permission>();
			
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	@Column(name = "STATUS")
	private String status;
	
	

	public int getRoleId() {
		return roleId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
		
		
}
