package com.mysite.petsonal.size;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SizeController {


	@PostMapping("/calculate")
	public String calculate(@RequestParam("lengthSize") String height, 
	                        @RequestParam("weight") String weight, 
	                        @RequestParam("roundSize") String waist,
	                        Model model) {
	    
		int height1= Integer.parseInt(height);
		int weight1= Integer.parseInt(weight);
		int waist1= Integer.parseInt(waist);
		
	    String result = "";
	    
	    if (height1<25 || waist1<38 ||  weight1<4) {
	    	
	        result = "S 사이즈 ";
	        
	    }else if(height1<30 ||  waist1<43 ||  weight1<7 ) {
	    	
	        result = "M 사이즈 ";
	        
	    }else if(height1<34 ||  waist1<49 ||  weight1<12 ) {
	    	
	        result = "L 사이즈 ";
	        
	    }else if(height1>35 || waist1>49 ||  weight1>12 ) {
	    	
	        result = "XL 사이즈 ";
	    }
	    
	    model.addAttribute("result", result);
	    return "size_result";
	}


}

	
	

