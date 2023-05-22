package com.kfc.service;

import java.util.HashMap;
import java.util.List;

import com.kfc.dto.Game;

public interface MainService {

	List<Game> searchRecord();

	HashMap<String, List<Game>> gameList();

}
