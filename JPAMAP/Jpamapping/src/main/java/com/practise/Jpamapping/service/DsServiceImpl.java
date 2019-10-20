package com.practise.Jpamapping.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.Jpamapping.entity.Location;
import com.practise.Jpamapping.entity.Plants;
import com.practise.Jpamapping.repo.BuildingRepo;
import com.practise.Jpamapping.repo.PlantRepo;
import com.practise.Jpamapping.repo.ReportDao;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone
 * Service Implementation ReportServiceImpl
 */
@Service
public class DsServiceImpl implements DsService {

	@Autowired
	private ReportDao reportdao;
	
	@Autowired
	private BuildingRepo buildingRepo;
	
	@Autowired
	private PlantRepo plantRepo;
	@Autowired
	private EntityManager em;
	

	/**
	 * Method getReport of ServiceImpl
	 * @param takes String language
	 * Returns Object report 
	 */
	@Override
	public List<Location> getReport() {
		List<Location> as= new ArrayList<>();
//		as.add(em.find(A.class, 1));
		as=reportdao.getBugs();
//		as.get(0).getPlants().get(0).getBuildings().get(0).getInverters()
		System.out.println(reportdao.getBugs());
//		Iterable<A> it = reportdao.findAll();
//		Iterator<A> i = it.iterator();
//		while(i.hasNext()) {
//			as.add(i.next());
//		}
		return as;
	}


	@Override
	public List<Plants> getB(int a1) {
		// TODO Auto-generated method stub
		
		return plantRepo.getBOfA(1);
	}


	@Override
	public int getTotalVoltage() {
		String obj = buildingRepo.getTotalVoltage(101);
		System.out.println(buildingRepo.getTotalVoltage(101).getClass());
		return Integer.parseInt(obj);
	}
}
	