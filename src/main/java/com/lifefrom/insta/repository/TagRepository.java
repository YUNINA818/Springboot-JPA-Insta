package com.lifefrom.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifefrom.insta.model.Tags;

public interface TagRepository extends JpaRepository<Tags, Integer>{

}
