package com.fwjia.admin.po;

import javax.persistence.*;
import java.io.Serializable;



/**
 * @author fwjia
 */
@Entity
@Table(name = "t_demo")
@org.hibernate.annotations.Table(appliesTo = "t_demo",comment="demo表注释...")
public class Demo implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue
    private long id;

	@Column(nullable = false,unique = false,columnDefinition = "int(2) comment '年龄'")
	private Integer age;

	@Column(nullable = false, unique = false,columnDefinition = "varchar(64) comment '姓名'")
    private String name;

	@Column(nullable = false, unique = true,columnDefinition = "varchar(64) comment '邮箱'")
	private String email;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
