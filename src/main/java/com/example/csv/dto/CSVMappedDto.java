package com.example.csv.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.csv.entity.CsvDataEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter@Setter
public class CSVMappedDto {

	private int id;
	private String variable;
	private List<CsvDataEntity> variable_code=new ArrayList<>();
	

}
