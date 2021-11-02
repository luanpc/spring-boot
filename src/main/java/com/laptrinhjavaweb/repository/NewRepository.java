package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.NewEntity;

@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
