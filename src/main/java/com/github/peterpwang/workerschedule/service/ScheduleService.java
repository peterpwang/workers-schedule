package com.github.peterpwang.workerschedule.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

import com.github.peterpwang.workerschedule.domain.Schedule;

public interface ScheduleService {
	public Page<Schedule> findAll(Pageable pageable);
	
	public Optional<Schedule> findById(Long id);
	
	@PreAuthorize("#schedule?.manager == null or #schedule?.manager?.name == authentication?.name")
	public Schedule	save(@Param("schedule") Schedule schedule);
	
	public void	deleteById(@Param("id") Long id);
}