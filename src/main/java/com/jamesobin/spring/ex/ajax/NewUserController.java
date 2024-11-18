package com.jamesobin.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamesobin.spring.ex.mvc.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {

	@Autowired
	private UserService userService;
	
	// 사용자 추가 API
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
		int count = userService.addUser(name, birthday, email, introduce);
		
		Map<String, String> resultMap = new HashMap<>();
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"}
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
				
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/userInput";
	}
	
	// email 전달 받고, 이미 추가되 email인지 확인
	// API
	@ResponseBody
	@GetMapping("/duplicate-email")
	public Map<String, Boolean> isDuplicateEmail(@RequestParam("email") String email) {
		boolean isDuplicate = userService.isDuplicateEmail(email);
		
		// 중복됨 {"isDuplicate":true} 
		// 중복 안됨 {"isDuplicate":false}
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(isDuplicate == true) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
	}
	
}
