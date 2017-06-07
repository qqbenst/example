package com.example.demo.service.bean;

public class UserBean {
	private Long id;
	private String name;
	private String password;
	private Long ctime;
	private Long utime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCtime() {
		return ctime;
	}

	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}

	public Long getUtime() {
		return utime;
	}

	public void setUtime(Long utime) {
		this.utime = utime;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", password=" + password + ", ctime=" + ctime + ", utime="
				+ utime + "]";
	}
	
}
