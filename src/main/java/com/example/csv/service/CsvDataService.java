package com.example.csv.service;

import java.util.List;
import java.util.Optional;

import com.example.csv.dto.CsvDataDto;
import com.example.csv.entity.CsvDataEntity;

public interface CsvDataService {
	
//	public ResponseEntity<CsvDataEntity> saveCsvData(CsvDataDto csvDataDto);
	public List<CsvDataEntity> updateCsvFile(List<CsvDataDto> csdDtoList);
	public List<CsvDataEntity> getAll(Integer pageNumber, Integer pageSize);
	public List<CsvDataEntity> getByYear(Integer pageNumber, Integer pageSize, Optional<Integer> year);
	public List<CsvDataEntity> getByVariableName(Integer pageNumber, Integer pageSize, Optional<String> vName);
	public List<CsvDataEntity> findByIndustryCodeANZSIC06(Integer pageNumber, Integer pageSize, Optional<String> industryCodeANZSIC06);
	
}
