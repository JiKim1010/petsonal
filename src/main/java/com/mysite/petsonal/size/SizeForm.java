package com.mysite.petsonal.size;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeForm {

	 @NotEmpty(message = "몸길이는 필수 항목입니다.")
	 private Integer height;

	 @NotEmpty(message = "몸무게는 필수 항목입니다.")
	 private Integer weight;
	 
	 @NotEmpty(message = "배둘레는 필수항목입니다.")
	 private Integer waist;
	 
	 
}
