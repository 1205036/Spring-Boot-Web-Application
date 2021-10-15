package com.repository.springbootwebapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="filerepository")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRepository {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String keyword;
	
	private String filename;
	
	private String path;
}
