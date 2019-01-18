package com.example.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fwjia
 */
@Entity
@Table(name = "t_user")
@org.hibernate.annotations.Table(appliesTo = "t_user",comment="用户表")
public class User implements Serializable {

	private static final long serialVersionUID = 2L;


	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, unique = true,columnDefinition = "varchar(64) comment '姓名'")
	private String userName;

	@Column(nullable = false,columnDefinition = "varchar(64) comment '密码'")
	private String passWord;

	@Column(columnDefinition = "varchar(256) comment '头像'")
	private String avatar;

	@Column(columnDefinition = "varchar(64) comment '手机'")
	private String phone;

	@Column(columnDefinition = "varchar(64) comment '邮箱'")
	private String email;

	@Column(columnDefinition = "varchar(8) comment '性别'")
	private String sex;

	@Column(columnDefinition = "varchar(64) comment 'ip地址'")
	private String ip;

	@Column(columnDefinition = "varchar(64) comment '加入时间'")
	private String joinTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", avatar='" + avatar + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", sex='" + sex + '\'' +
				", ip='" + ip + '\'' +
				", joinTime='" + joinTime + '\'' +
				'}';
	}
}
