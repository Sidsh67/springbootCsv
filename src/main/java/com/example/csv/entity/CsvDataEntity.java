package com.example.csv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsvDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serial_number;
	@Column(name = "Year")
	private int year;
	@Column(name = "Industry_aggregation_NZSIOC")
	private String industry_aggregation_NZSIOC;
	@Column(name = "Industry_code_NZSIOC")
	private String industry_code_NZSIOC;
	@Column(name = "Industry_name_NZSIOC")
	private String industry_name_NZSIOC;
	@Column(name = "Units")
	private String units;
	@Column(name = "Variable_code")
	private String variable_code;
	@Column(name = "variable_name")
	private String variableName;
	@Column(name = "Variable_category")
	private String variableCategory;
	@Column(name = "Value")
	private String value;
	@Column(name = "Industry_code_ANZSIC06")
	private String industryCodeANZSIC06;
	public CsvDataEntity(int year, String industry_aggregation_NZSIOC, String industry_code_NZSIOC,
			String industry_name_NZSIOC, String units, String variable_code, String variable_name,
			String variable_category, String value, String industry_code_ANZSIC06) {
		super();
		this.year = year;
		this.industry_aggregation_NZSIOC = industry_aggregation_NZSIOC;
		this.industry_code_NZSIOC = industry_code_NZSIOC;
		this.industry_name_NZSIOC = industry_name_NZSIOC;
		this.units = units;
		this.variable_code = variable_code;
		variableName = variable_name;
		variableCategory = variable_category;
		this.value = value;
		industryCodeANZSIC06 = industry_code_ANZSIC06;
	}
	
	

}
