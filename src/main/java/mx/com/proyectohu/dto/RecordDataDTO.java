package mx.com.proyectohu.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecordDataDTO {
	
	
	private List<String> fieldNames;
	private List<List<String>>  records;

	/**
	 * @return the fieldNames
	 */
	public List<String> getFieldNames() {
		return fieldNames;
	}

	/**
	 * @param fieldNames the fieldNames to set
	 */
	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

	/**
	 * @return the records
	 */
	public List<List<String>> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<List<String>> records) {
		this.records = records;
	}

	
	
	
	

}
