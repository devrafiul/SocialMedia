package com.zosh.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name")
	private String firstName;
	
	@Column(name="nickName")
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String gender;
	
	private List<Integer> followers=new ArrayList<>();
	
	private  List<Integer>followings=new ArrayList<>();
	
	//@ElementCollection
	//@JsonIgnore
	@ManyToMany
	private List<Post>savedPost=new ArrayList<>();

}
