/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client.bank.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ekzestencial
 */
@Entity
@Table(name = "role", catalog = "financial", schema = "")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
	, @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId")
	, @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")})
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @Column(name = "role_id")
	private Long roleId;
	@Basic(optional = false)
        @Column(name = "name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
	private Collection<Appuser> appuserCollection;

	public Role() {
	}

	public Role(Long roleId) {
		this.roleId = roleId;
	}

	public Role(Long roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public Collection<Appuser> getAppuserCollection() {
		return appuserCollection;
	}

	public void setAppuserCollection(Collection<Appuser> appuserCollection) {
		this.appuserCollection = appuserCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (roleId != null ? roleId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Role)) {
			return false;
		}
		Role other = (Role) object;
		if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.client.bank.jpa.Role[ roleId=" + roleId + " ]";
	}
	
}
