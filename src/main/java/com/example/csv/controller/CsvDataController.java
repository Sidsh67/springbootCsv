package com.example.csv.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.csv.dto.CsvDataDto;
import com.example.csv.entity.CsvDataEntity;
import com.example.csv.service.CsvDataService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@RestController
@RequestMapping("/csv-data")
public class CsvDataController {
	@Autowired
	private CsvDataService csvDataService;

	@PostMapping
	public List<CsvDataEntity> uploadData(@RequestParam("file") MultipartFile csvFile) throws IOException, CsvValidationException, NumberFormatException{
		
		List<CsvDataDto> dataDtos = new ArrayList<>();
		
		try (CSVReader reader = new CSVReader(new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8))) {
          String[] data;
          System.out.println(reader.readNext());
          
          while ((data = reader.readNext()) != null) {
            // Each line in the CSV file is represented as an array of strings
        	
        	
        	CsvDataDto dto = new CsvDataDto();
			dto.setYear(Integer.parseInt(data[0]));
			dto.setIndustry_aggregation_NZSIOC(data[1]);
			dto.setIndustry_code_NZSIOC(data[2]); 
			dto.setIndustry_name_NZSIOC(data[3]);
			dto.setUnits(data[4]);
			dto.setVariable_code(data[5]);
			dto.setVariable_name(data[6]);
			dto.setVariable_category(data[7]);
			dto.setValue(data[8]);
			dto.setIndustry_code_ANZSIC06(data[9]);
				
			
			dataDtos.add(dto);
			System.out.println(dataDtos);

		
		
	}
          return csvDataService.updateCsvFile(dataDtos);
	
	

	}
	
	

	}
	@GetMapping()
	public List<CsvDataEntity> getAll(
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "10" ,required = false)Integer pageSize){
		List<CsvDataEntity> dto=csvDataService.getAll(pageNumber,pageSize);
		for(CsvDataEntity en:dto) {
		System.out.println(dto+"+++++++");
		System.out.println();
		}
		return dto;
	}
	
	@GetMapping("/search")
	public List<CsvDataEntity> getByYear(@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10" ,required = false)Integer pageSize,@RequestParam Optional<Integer> year){
	List<CsvDataEntity> dto=null;
		if(!year.isEmpty()) {
			dto=csvDataService.getByYear(pageNumber,pageSize,year);
		}
		else {
			dto=csvDataService.getAll(pageNumber,pageSize);
		}
		return dto;
}
	
	@GetMapping("/searching")
	public List<CsvDataEntity> findByVariableName(@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10" ,required = false)Integer pageSize,@RequestParam(required = false) Optional<String> variableName){
		List<CsvDataEntity> dto=null;
//		List<CsvDataEntity> dto= csvDataService.getByVariableName(pageNumber,pageSize,variableName);
		if(!(variableName.isEmpty())) {
			dto=csvDataService.getByVariableName(pageNumber,pageSize,variableName);
			
		}
		else {
			dto=csvDataService.getAll(pageNumber,pageSize);
		}
		return dto;
}
	@GetMapping("/searc")
	public List<CsvDataEntity> findByIndustryCodeANZSIC06(@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10" ,required = false)Integer pageSize,@RequestParam(required = false) Optional<String> industryCodeANZSIC06){
	

		List<CsvDataEntity> dto=csvDataService.getByVariableName(pageNumber,pageSize,industryCodeANZSIC06);

		return dto;
}
	
}
