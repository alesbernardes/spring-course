package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.enuns.RequestState;
import com.springcourse.repository.RequestRepository;

@Service
public class RequestService {
	//save

	@Autowired private RequestRepository requestRepository;
	
	public Request save(Request request) {
		request.setState(RequestState.OPEN);
		request.setCreationDate(new Date());
		
		Request createRequest = requestRepository.save(request);
		
		return createRequest;
	}
	//update
	public Request update(Request request) {
		
			
		Request updateRequest = requestRepository.save(request);
		return updateRequest;
	}
	//get
	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.get();
	}
	//list
	public List<Request> listAll() {
		List<Request>requests = requestRepository.findAll();
		return requests;
	}
	
	//lista pedudis de um usuario
	public List<Request> listAllByOwnerId(Long ownerId){
		List<Request>requests = requestRepository.findAllByOwnerId(ownerId);
		return requests;
      }
}
