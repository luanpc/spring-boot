package com.laptrinhjavaweb.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private NewConverter newConverter;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepo.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		} else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepo.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepo.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			newRepo.delete(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepo.findAll(pageable).getContent();
		for(NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepo.count();
	}
}
