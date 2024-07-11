//package com.example.csv.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class CSVMapped {
//	//customer
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//	
//	@Column(name = "Variable_code")
//	private String variable;
////	@OneToMany(targetEntity = CsvmappedEntity2.class, cascade = CascadeType.ALL)
////	@JoinColumn(name = "variable_code",referencedColumnName = "id")
//	@OneToMany(mappedBy = "entity",cascade = CascadeType.ALL)
//	private List<CsvDataEntity> variable_code=new ArrayList<>();
//
//	
//	
//	
//
//}
