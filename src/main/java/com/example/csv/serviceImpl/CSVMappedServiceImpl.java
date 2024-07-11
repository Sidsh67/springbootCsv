//package com.example.csv.serviceImpl;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.csv.entity.CSVMapped;
//import com.example.csv.repo.CSVMappedRepository;
//import com.example.csv.service.CSVMappedService;
//
//
//
//@Component
//public class CSVMappedServiceImpl implements CSVMappedService{
//
//	@Autowired
//	private CSVMappedRepository repo;
//	
//	@Override
//	public CSVMapped updateCsvFile(String vc){
//		CSVMapped obj=new CSVMapped();
//		obj.setVariable(vc);
//		CSVMapped csv=repo.save(obj);
//		return csv;
//	}
//}
//
//	
//
