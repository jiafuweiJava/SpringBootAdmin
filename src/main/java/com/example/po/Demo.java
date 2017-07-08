package com.example.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity//加入这个注解，Demo就会进行持久化了，在这里没有对@Table进行配置，请自行配置。
public class Demo {
	@Id 
	@GeneratedValue
    private long id;//主键.
	@Column(nullable = false, unique = true)
    private String name;//测试名称.
	@Column(nullable = false, unique = true)
	private String email;
    
    
	
	
	/*public Demo(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
