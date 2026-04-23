package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MiddlewareDTO {
	
    private RecordDataDTO recordData;
	
	private MergeRuleDTO mergeRule;

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

	/**
	 * @return the mergeRule
	 */
	public MergeRuleDTO getMergeRule() {
		return mergeRule;
	}

	/**
	 * @param mergeRule the mergeRule to set
	 */
	public void setMergeRule(MergeRuleDTO mergeRule) {
		this.mergeRule = mergeRule;
	}

	
}
