package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	@Lob
	private byte[] photo;
	
	@Lob
	private byte[] signature;
	
	@Lob
	private byte[] pan;
}
