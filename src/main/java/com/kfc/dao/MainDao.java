package com.kfc.dao;

import java.util.List;

import com.kfc.dto.Game;

public interface MainDao {

	List<Game> searchRecord();

	List<Game> gameList();

}
