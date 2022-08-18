package com.doranco.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.doranco.dto.StoreDTO;

import api.client.doranco.StoreDTO1;
import api.client.doranco.StoreService;
import api.client.doranco.StoreServiceService;

@ManagedBean
@SessionScoped
public class StoreBean implements Serializable {

	private List<StoreDTO> dtos = new ArrayList<>();

	private StoreDTO storeDTO = new StoreDTO();

	public StoreBean() {
		dtos.add(new StoreDTO("M1", "Magasin Brazzaville"));
		dtos.add(new StoreDTO("M2", "Magasin Paris"));
		dtos.add(new StoreDTO("M3", "Magasin Abidjan"));
		dtos.add(new StoreDTO("M4", "Magasin Rabbat"));
		dtos.add(new StoreDTO("M5", "Magasin Dubaï"));
	}

	public List<StoreDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<StoreDTO> dtos) {
		this.dtos = dtos;
	}

	public StoreDTO getStoreDTO() {
		return storeDTO;
	}

	public void setStoreDTO(StoreDTO storeDTO) {
		this.storeDTO = storeDTO;
	}

	public void save() {
		dtos.add(new StoreDTO(storeDTO.getStoreCd(), storeDTO.getDescription()));
		StoreServiceService serviceService = new StoreServiceService();
		StoreService service = serviceService.getStoreServicePort();
		StoreDTO1 storeDTO1=new StoreDTO1();
		storeDTO1.setStoreCd(storeDTO.getStoreCd());
		storeDTO1.setDescription(storeDTO.getDescription());
		service.save(storeDTO1);
		JSFUtils.addInfoMessage("Création reussie", "Création reussie");
	}

}
