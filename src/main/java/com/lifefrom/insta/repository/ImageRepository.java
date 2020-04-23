package com.lifefrom.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifefrom.insta.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
