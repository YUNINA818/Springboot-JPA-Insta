package com.lifefrom.insta.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Tags {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //시퀀스
	
	private String name;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="imageId")
	@JsonBackReference
	private Image image;
	
	@CreationTimestamp //자동으로 현 시간 세팅
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;

	

}