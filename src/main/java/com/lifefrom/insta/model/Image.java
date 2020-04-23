package com.lifefrom.insta.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Lob
//	@Column(length = 1024000)
	//private byte[] file;
	private String location; // 사진 찍은 위치
	private String caption; // 사진 설명
	private String postImage; //포스팅 사진 경로 + 이름
	
	
	//private String fileName; //사진 파일 이름
	//private String filePath; //사진경로
	
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"password"})
	private User user;
	
	//(1) tag list
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "image_id")
	@OneToMany(mappedBy = "image")
	@JsonManagedReference
	private List<Tags> tags = new ArrayList<>();
	
	
	//(2) like list
	@OneToMany(mappedBy = "image")
	@JoinColumn
	private List<Like> likes = new ArrayList<>();
	
	//fk는 절대 one to many가 있는 쪽에 생길 수 없다. 연관 테이블에 생성
	//many to one을 쓰면 쓴 쪽으로 fk가 생긴다.
	//즉, 팀쪽엔 팀의 정보, 선수단 쪽에 선수 정보가 생길때 1개 팀에 여러명의 선수로 예를 든다면
	//선수단 쪽에 선수id가 있어야 한다. 한개의 팀쪽에 여러 선수id는 들어가지 못한다.(원자성)
	
	
	
	@Transient //DB에 영향을 미치진 않는다.
	private int likeCount;
		
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
	
}
