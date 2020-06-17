package com.example.demo.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Prisoner;
import com.example.demo.repository.util.WiselyRepository;

//@Repository
public interface PrisonerRepository extends WiselyRepository<Prisoner, String> {
		
}
