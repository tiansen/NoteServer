package com.ferraborghini.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="note")
public class Note {
	@Id
	@Column(name="_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter @Getter
	int _id;
	@Setter @Getter
	String title;
	@Setter @Getter
	String content;
	@Setter @Getter
	int flag;
	@Setter @Getter
	Date date;
	@Setter @Getter
	int create_date;
	@Setter @Getter
	String name;
	
}
