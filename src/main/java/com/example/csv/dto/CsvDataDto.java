package com.example.csv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class CsvDataDto {

	
	private int serial_number;
	
	private int year;
	
	private String industry_aggregation_NZSIOC;
	
	private String industry_code_NZSIOC;
	
	private String industry_name_NZSIOC;

	private String units;

	private String variable_code;

	private String Variable_name;

	private String Variable_category;

	private String value;

	private String Industry_code_ANZSIC06;

}
