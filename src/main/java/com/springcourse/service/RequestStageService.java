package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.RequestStage;
import com.springcourse.enuns.RequestState;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired RequestStageRepository requestStageRepository;
	
	@Autowired RequestRepository requestRepository;
	
	//save
	public RequestStage save(RequestStage stage) {
		
		stage.setRealizationDate(new Date());
		
		RequestStage creatStage = requestStageRepository.save(stage);
		
		Long requestId =stage.getRequest().getId();
		RequestState state = stage.getState();
			
		requestRepository.updateStatus(requestId, state);
		
		return creatStage;
		
	}
	
	public RequestStage update(RequestStage requestStage) {
		RequestStage updateRequestStage =requestStageRepository.save(requestStage);
		return updateRequestStage;
	}
	//Get
	public RequestStage getById(Long id) {
		Optional<RequestStage> result = requestStageRepository.findById(id);
		return result.get();
	}
	public List<RequestStage> listAllById(Long requestId){
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
		return stages;
	}
}
