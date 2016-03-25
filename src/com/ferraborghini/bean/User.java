package com.ferraborghini.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="name")
	@Setter @Getter
	String name;
	@Setter @Getter
	String pwd;
	@Setter @Getter
	String sex;
	@Setter @Getter
	String label;
	
}
