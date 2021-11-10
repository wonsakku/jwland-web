package com.jwland.common;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@RestController
public class MenuController {

	private final MenuService menuService;
	
	
	@GetMapping("/menu")
	public ResponseEntity<List> getMenu(){
		List menu = menuService.getMenu();
//		System.out.println(menu);
		return ResponseEntity.status(HttpStatus.OK).body(menu);
	}

}
