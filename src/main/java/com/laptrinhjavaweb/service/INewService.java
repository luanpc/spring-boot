package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDto);
	void delete(long[] ids);
}
