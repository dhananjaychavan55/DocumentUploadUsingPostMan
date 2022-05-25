package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Documents;

@Repository
public interface DocRepository extends JpaRepository<Documents, Integer>{

}
