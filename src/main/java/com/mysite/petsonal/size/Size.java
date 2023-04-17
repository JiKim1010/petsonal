package com.mysite.petsonal.size;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Size {
	
	@Id
	private Integer height;
	
	private Integer weight;
	
	private Integer waist;


}
