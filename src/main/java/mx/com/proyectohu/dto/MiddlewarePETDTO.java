package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MiddlewarePETDTO {
	
    private RecordDataDTO recordData;
    
   
    private Boolean insertOnNoMatch;
    private String updateOnMatch;
    private  String matchColumnName1;
    private String matchColumnName2;
    
//	private MergeRuleDTO mergeRule;

	/**
	 * @return the recordData
	 */
	public RecordDataDTO getRecordData() {
		return recordData;
	}

	/**
	 * @param recordData the recordData to set
	 */
	public void setRecordData(RecordDataDTO recordData) {
		this.recordData = recordData;
	}

	
	

	public Boolean getInsertOnNoMatch() {
		return insertOnNoMatch;
	}

	public void setInsertOnNoMatch(Boolean insertOnNoMatch) {
		this.insertOnNoMatch = insertOnNoMatch;
	}

	public String getUpdateOnMatch() {
		return updateOnMatch;
	}

	public void setUpdateOnMatch(String updateOnMatch) {
		this.updateOnMatch = updateOnMatch;
	}

	public String getMatchColumnName1() {
		return matchColumnName1;
	}

	public void setMatchColumnName1(String matchColumnName1) {
		this.matchColumnName1 = matchColumnName1;
	}

	public String getMatchColumnName2() {
		return matchColumnName2;
	}

	public void setMatchColumnName2(String matchColumnName2) {
		this.matchColumnName2 = matchColumnName2;
	}
	

	
}
