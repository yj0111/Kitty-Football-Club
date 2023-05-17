package com.kfc.service;

import java.util.List;

import com.kfc.dto.Game;

public interface MainService {

	List<Game> searchRecord();

	List<Game> gameList();

}
