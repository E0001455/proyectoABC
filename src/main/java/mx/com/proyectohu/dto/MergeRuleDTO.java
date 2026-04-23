package mx.com.proyectohu.dto;

public class MergeRuleDTO {
	
	private String htmlValue;
	private String textValue;
	private String optinValue;
	private String optoutValue;
	private Boolean insertOnNoMatch;
	private String updateOnMatch;
	private String matchColumnName1;
	private String matchColumnName2;
	private String matchOperator;
	private String rejectRecordIfChannelEmpty;
	private String defaultPermissionStatus;
	
	
	
	/**
	 * @return the htmlValue
	 */
	public String getHtmlValue() {
		return htmlValue;
	}
	/**
	 * @param htmlValue the htmlValue to set
	 */
	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}
	/**
	 * @return the textValue
	 */
	public String getTextValue() {
		return textValue;
	}
	/**
	 * @param textValue the textValue to set
	 */
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	/**
	 * @return the optinValue
	 */
	public String getOptinValue() {
		return optinValue;
	}
	/**
	 * @param optinValue the optinValue to set
	 */
	public void setOptinValue(String optinValue) {
		this.optinValue = optinValue;
	}
	/**
	 * @return the optoutValue
	 */
	public String getOptoutValue() {
		return optoutValue;
	}
	/**
	 * @param optoutValue the optoutValue to set
	 */
	public void setOptoutValue(String optoutValue) {
		this.optoutValue = optoutValue;
	}
	/**
	 * @return the insertOnNoMatch
	 */
	public Boolean getInsertOnNoMatch() {
		return insertOnNoMatch;
	}
	/**
	 * @param insertOnNoMatch the insertOnNoMatch to set
	 */
	public void setInsertOnNoMatch(Boolean insertOnNoMatch) {
		this.insertOnNoMatch = insertOnNoMatch;
	}
	/**
	 * @return the updateOnMatch
	 */
	public String getUpdateOnMatch() {
		return updateOnMatch;
	}
	/**
	 * @param updateOnMatch the updateOnMatch to set
	 */
	public void setUpdateOnMatch(String updateOnMatch) {
		this.updateOnMatch = updateOnMatch;
	}
	/**
	 * @return the matchColumnName1
	 */
	public String getMatchColumnName1() {
		return matchColumnName1;
	}
	/**
	 * @param matchColumnName1 the matchColumnName1 to set
	 */
	public void setMatchColumnName1(String matchColumnName1) {
		this.matchColumnName1 = matchColumnName1;
	}
	/**
	 * @return the matchColumnName2
	 */
	public String getMatchColumnName2() {
		return matchColumnName2;
	}
	/**
	 * @param matchColumnName2 the matchColumnName2 to set
	 */
	public void setMatchColumnName2(String matchColumnName2) {
		this.matchColumnName2 = matchColumnName2;
	}
	/**
	 * @return the matchOperator
	 */
	public String getMatchOperator() {
		return matchOperator;
	}
	/**
	 * @param matchOperator the matchOperator to set
	 */
	public void setMatchOperator(String matchOperator) {
		this.matchOperator = matchOperator;
	}
	/**
	 * @return the rejectRecordIfChannelEmpty
	 */
	public String getRejectRecordIfChannelEmpty() {
		return rejectRecordIfChannelEmpty;
	}
	/**
	 * @param rejectRecordIfChannelEmpty the rejectRecordIfChannelEmpty to set
	 */
	public void setRejectRecordIfChannelEmpty(String rejectRecordIfChannelEmpty) {
		this.rejectRecordIfChannelEmpty = rejectRecordIfChannelEmpty;
	}
	/**
	 * @return the defaultPermissionStatus
	 */
	public String getDefaultPermissionStatus() {
		return defaultPermissionStatus;
	}
	/**
	 * @param defaultPermissionStatus the defaultPermissionStatus to set
	 */
	public void setDefaultPermissionStatus(String defaultPermissionStatus) {
		this.defaultPermissionStatus = defaultPermissionStatus;
	}
	

}
