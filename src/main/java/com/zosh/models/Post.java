package com.zosh.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String caption; 
	
	private String image;
	
	private String vedio;
	
	
	@ManyToOne
	private User user;
	
	private LocalDateTime createdAt;
	
	
	@OneToMany
	private List<User>liked=new ArrayList<>();
	
	@OneToMany
	private List<Comment>comments=new ArrayList<>();
}
