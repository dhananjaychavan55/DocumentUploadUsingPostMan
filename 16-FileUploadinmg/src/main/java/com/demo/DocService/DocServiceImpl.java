package com.demo.DocService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Documents;
import com.demo.repository.DocRepository;

@Service
public class DocServiceImpl implements DocumentService{

	@Autowired
	private DocRepository repo;
	@Override
	public void insertDocuments(Documents d) {
		repo.save(d);
		
	}

}
