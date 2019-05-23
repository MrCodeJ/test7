package com.hfxt.domain;

import java.util.Date;


public class TbUser implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	//private TbRole tbRole;
	private Integer roleId;
	private String username;
	private String password;
	private Integer status;
	private Date createtime;
	private String phone;
	private Integer age;
	private String adress;
	private Integer sex;
	private String usercode;

	public TbUser(Integer id, Integer roleId, String username, String password,
			Integer status, Date createtime, String phone, Integer age,
			String adress, Integer sex, String usercode) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.status = status;
		this.createtime = createtime;
		this.phone = phone;
		this.age = age;
		this.adress = adress;
		this.sex = sex;
		this.usercode = usercode;
	}

	public TbUser() {
		
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getUsercode() {
		return this.usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}


}