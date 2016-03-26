package com.ferraborghini.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {
	public User() {
	}

	public User(String name, String pwd, String sex, String label) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.label = label;
	}

	@Id
	@Column(name = "name")
	@Setter
	@Getter
	String name;
	@Setter
	@Getter
	String pwd;
	@Setter
	@Getter
	String sex;
	@Setter
	@Getter
	String label;

}
