package com.doranco.service;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@WebService
@Stateless
public class StoreService {
	
	
	

	@WebMethod
	public  void  save ( StoreDTO1 dto) {
		//entityManager.persist(dto);
		System.out.println("+++++++++++== "+dto.toString());
	}

}
