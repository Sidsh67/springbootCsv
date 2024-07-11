package com.example.csv.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.csv.entity.CsvDataEntity;
import java.util.List;



public interface csvDataRepository extends JpaRepository<CsvDataEntity, Integer>{

	
	    Page<CsvDataEntity> findByYear(Pageable pageable, @Param("year") Optional<Integer> year);
	    
//	    @Query("from public.csv_data_entity u WHERE u.variable_name ILIKE %:name%")
//	    @Query("from csv_data_entity s where s.variable_name ILIKE %:name%")
	    
//	    @Query(value = "SELECT * FROM csv_data_entity WHERE variable_name LIKE :name", nativeQuery = true)
//	    Page<CsvDataEntity> findByVariableName( String name, Pageable pageable);
	    
	    
	    Page<CsvDataEntity> findByVariableNameContaining(String name, Pageable pageable);
	    
	    Page<CsvDataEntity> findByIndustryCodeANZSIC06(Optional<String> industryCodeANZSIC06, Pageable pageable);
	    
}



