package com.apap.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.be.model.PustakawanModel;
import com.apap.be.model.RestModel;
import com.apap.be.model.ResultModel;
import com.apap.be.model.UserModel;
import com.apap.be.service.UserService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/user")
public class UserController {

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/view-all")
	public ResponseEntity<Object> GetAllUser() {
		List<UserModel> luser = userService.getAllUser();
		return ResultModel.generateResponse(HttpStatus.OK, "success", luser);
	}

	@GetMapping(value = "/view/{username}&{password}")
	public ResponseEntity<Object> GetUserByUsername(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		UserModel user = userService.getUserByUsername(username).get();
		if (user.getPassword().equals(password)) {
			return ResultModel.generateResponse(HttpStatus.OK, "success", user);
		}
		return ResultModel.generateResponse(HttpStatus.OK, "no data with that username / password", null);
	}

	@GetMapping(value = "/view-user-profile/{username}")
	public ResponseEntity<Object> GetUserProfile(@PathVariable("username") String username) {
		UserModel user = userService.getUserByUsername(username).get();
		if (!user.equals(null)) {
			String url = "http://si-sivitas.herokuapp.com/api/employees/" + user.getUuid();

			RestModel response = restTemplate.getForObject(url, RestModel.class); 
			if (response.getStatus() == 200) {
				return ResultModel.generateResponse(HttpStatus.OK, "success", response.getResult());
			}
		}
		return ResultModel.generateResponse(HttpStatus.NOT_FOUND, "no data with that user id", null);
	}

	@PostMapping(value = "/add-pustakawan/{username}&{password}")
	public ResponseEntity<Object> AddGuru(@RequestBody PustakawanModel pustakawan, @PathVariable("username") String username,
			@PathVariable("password") String password) {
		String url = "http://si-sivitas.herokuapp.com/api/employees";
		RestModel response = restTemplate.postForObject(url, pustakawan, RestModel.class);
		if (response.getStatus() == 200) {
			UserModel user = new UserModel();
			user.setUsername(username);
			user.setPassword(password);
			user.setUuid(pustakawan.getIdUser());
			user.setId_role(5);
			userService.addUser(user);
			return ResultModel.generateResponse(HttpStatus.OK, "success", response.getResult());
		}
		return ResultModel.generateResponse(HttpStatus.NOT_FOUND, "failed add user", null);
	}
 
}
