package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.dao.RoleDao;

@RestController
public class RoleController {

	@Autowired
	RoleDao roleDao;
	
	@PostMapping("/role")
	public String addRole(RoleBean roleBean)
	{
		roleDao.addRole(roleBean);
		return "Success!!!";
	}
	
	@GetMapping("/roles")
	public List<RoleBean> listRoles()
	{
		return roleDao.listRoles();
	}
	
	@DeleteMapping("/role/{id}")
	public List<RoleBean> deleteRole(@PathVariable("id")int id)
	{
		roleDao.deleteRole(id);
		return roleDao.listRoles();
	}
	
	@PutMapping("/role/{id}")
	public List<RoleBean> updateRole(RoleBean roleBean, @PathVariable("id")int id)
	{
		roleBean.setRoleId(id);
		roleDao.updateRole(roleBean);
		return roleDao.listRoles();
	}
}
