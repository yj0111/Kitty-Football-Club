package com.kfc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kfc.dao.MainDao;

public class mainServiceImpl implements MainService {
	@Autowired
	MainDao mainDao;
}
