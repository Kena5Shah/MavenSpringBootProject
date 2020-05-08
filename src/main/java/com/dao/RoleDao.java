package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;
@Repository
public class RoleDao {

	@Autowired
	JdbcTemplate stmt;

	public void addRole(RoleBean roleBean) {
		stmt.update("insert into roles(roleName) values(?)", roleBean.getRoleName()); 
	}

	public List<RoleBean> listRoles() {
		List<RoleBean> roles = stmt.query("select * from roles", new RoleBeanRowMapper());
		return roles;
	}
	
	class RoleBeanRowMapper implements RowMapper<RoleBean>
	{

		public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleBean roleBean = new RoleBean();
			roleBean.setRoleId(rs.getInt("roleId"));
			roleBean.setRoleName(rs.getString("roleName"));
			return roleBean;
		}
		
	}

	public void deleteRole(int id) {
		stmt.update("delete from roles where roleId = "+id);
	}

	public RoleBean getDataByPk(int id) {
		RoleBean roleBean = stmt.queryForObject("select * from roles where roleId = "+id, new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		return roleBean;
	}

	public void updateRole(RoleBean roleBean) {
		stmt.update("update roles set roleName = ? where roleId = ?",roleBean.getRoleName(),roleBean.getRoleId());
	}
}
