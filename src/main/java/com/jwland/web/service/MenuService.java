package com.jwland.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwland.web.mapper.MenuMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MenuService {	

	
	private final MenuMapper menuMapper;
	
	public List getMenu() {
		return menuMapper.getMenu();
	}
}
