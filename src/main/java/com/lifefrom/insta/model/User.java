package com.lifefrom.insta.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity //jap -> orm
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL에서 auto_increment, Oracle은 sequence가 생성
	private int id; //시퀀스,auto_increment
	private String username;
	private String password;
	private String name;
	private String website;
	private String bio; //자기소개
	private String email;
	private String phone;
	private String gender;
	private String profileImage; //프로필 사진경로+이름
	
	
	//(1) findById() 때만 동작
	//(2) findByUserInfo() 제외
	@OneToMany(mappedBy = "user") //mappedBy는 연관관계의 주인이 아님을 설정
	                              //mappedBy가 있으면 양반향 관계, 없으면 fk, "user"값은 follow 객체 변수명
	@JsonIgnoreProperties({"user","tags","likes"})
	private List<Image> images = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "from_user")
	private List<Follow> from_user;
	
	@OneToMany(mappedBy = "to_user")
	private List<Follow> to_user;
	
	
	
	@CreationTimestamp //자동으로 현 시간 세팅
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;

}
