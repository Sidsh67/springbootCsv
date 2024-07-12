package com.example.csv.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.csv.dto.CsvDataDto;
import com.example.csv.entity.CsvDataEntity;
import com.example.csv.repo.csvDataRepository;
import com.example.csv.service.CsvDataService;

@Service
public class CsvDataServiceImpl implements CsvDataService {

	@Autowired
	private csvDataRepository csvRepository;

//	public ResponseEntity<CsvDataEntity> saveCsvData(CsvDataDto csvDataDto) {
//		CsvDataEntity csd=new CsvDataEntity(csvDataDto.getYear(), csvDataDto.getIndustry_aggregation_NZSIOC()
//				, csvDataDto.getIndustry_code_NZSIOC(), csvDataDto.getIndustry_name_NZSIOC()
//				, csvDataDto.getUnits(), csvDataDto.getVariable_code(), csvDataDto.getVariable_name()
//				, csvDataDto.getVariable_category(), csvDataDto.getValue(), csvDataDto.getIndustry_code_ANZSIC06());
//		
//		
//		csvRepository.save(csd);
//		return new ResponseEntity<CsvDataEntity>(HttpStatus.OK);
//	}
//	

	public List<CsvDataEntity> updateCsvFile(List<CsvDataDto> csdDtoList) {
		List<CsvDataEntity> csvDataList = new ArrayList<>();

		for (CsvDataDto csvDtos : csdDtoList) {
			CsvDataEntity csvDataEntity = new CsvDataEntity(csvDtos.getYear(), csvDtos.getIndustry_aggregation_NZSIOC(),
					csvDtos.getIndustry_code_NZSIOC(), csvDtos.getIndustry_name_NZSIOC(), csvDtos.getUnits(),
					csvDtos.getVariable_code(), csvDtos.getVariable_name(), csvDtos.getVariable_category(),
					csvDtos.getValue(), csvDtos.getIndustry_code_ANZSIC06());
			CsvDataEntity savedEntity = csvRepository.save(csvDataEntity);

			csvDataList.add(savedEntity);
		}

		return csvDataList;
	}

	public List<CsvDataEntity> getAll(Integer pageNumber, Integer pageSize) {
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by("year"));
		Page<CsvDataEntity> pageData = csvRepository.findAll(p);
		List<CsvDataEntity> allData = pageData.getContent();
		return allData;
	}

	public List<CsvDataEntity> getByYear(Integer pageNumber, Integer pageSize, Optional<Integer> year) {

		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by("year"));// .withSort(Sort.by("year"));

		Page<CsvDataEntity> pageData = csvRepository.findByYear(p, year);
//		 List<CsvDataEntity> allData=pageData.getContent();
//		return allData;
		return pageData.getContent();
//		}
//		else
//		{
//			Page<CsvDataEntity> pageData=csvRepository.findAll(p);
//			return pageData.getContent();
//		}
	}

	@Override
	public List<CsvDataEntity> getByVariableName(Integer pageNumber, Integer pageSize, Optional<String> vName) {

		Pageable p = PageRequest.of(pageNumber, pageSize);// .withSort(Sort.by("year"));

		Page<CsvDataEntity> pageData = csvRepository.findByVariableNameContaining(vName.get(), p);

		return pageData.getContent();

	}

	public List<CsvDataEntity> findByIndustryCodeANZSIC06(Integer pageNumber, Integer pageSize,
			Optional<String> industryCodeANZSIC06) {

		Pageable p = PageRequest.of(pageNumber, pageSize);// .withSort(Sort.by("year"));

		Page<CsvDataEntity> pageData = csvRepository.findByVariableNameContaining(industryCodeANZSIC06.get(), p);

		return pageData.getContent();

	}

	public List<CsvDataEntity> findByYearAndVariableName(Optional<Integer> year, Optional<String> variableName,
			Integer pageNumber, Integer pageSize) {
		Pageable p = PageRequest.of(pageNumber, pageSize);

		Page<CsvDataEntity> pageData = csvRepository.findByYearAndVariableNameContaining(year.get(), variableName.get(),
				p);
		return pageData.getContent();
	}
}
