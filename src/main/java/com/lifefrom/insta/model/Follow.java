package com.lifefrom.insta.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL에서 auto_increment, Oracle은 sequence가 생성
	private int id; //시퀀스,auto_increment
	
	@ManyToOne
	@JoinColumn(name="from_user") //db에 fk변수명
	private User from_user;
	
	@ManyToOne
	@JoinColumn(name = "to_user")
	private User to_user;
	
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;

}
