package com.jwland.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

	public List getMenu();
}
