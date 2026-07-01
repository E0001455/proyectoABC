package mx.com.proyectohu.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SYNONMID_TTABCTRA_CUENTA" )
@SequenceGenerator(name = "SEQ_CUENTA_GEN",sequenceName = "SYNONMID_SEQ_TTABCTRA_CUENTA",allocationSize = 1)
public class CuentaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUENTA_GEN")
	@Column(name = "ID_CUENTA")
	private Long 	idCuenta;

	@Column(name = "FCEVENT_TYPE_ID")
	private String eventTypeId;

	@Column(name = "FCEVENT_UUID")
	private String eventUuid;

	@Column(name = "FCACCOUNT_ID")
	private String accountId;

	@Column(name = "FCLIST_ID")
	private String listId;

	@Column(name = "FCRIID")
	private String riid;

	@Column(name = "FCCUSTOMER_ID")
	private String customerId;

	@Column(name = "FCEVENT_CAPTURED_DT")
	private String eventCapturedDt;

	@Column(name = "FCEVENT_STORED_DT")
	private String eventStoredDt;

	@Column(name = "FCCAMPAIGN_ID")
	private String campaignId;

	@Column(name = "FCLAUNCH_ID")
	private String launchId;

	@Column(name = "FCEMAIL")
	private String email;

	@Column(name = "FCEMAIL_ISP")
	private String emailIsp;

	@Column(name = "FCEMAIL_FORMAT")
	private String emailFormat;

	@Column(name = "FCBOUNCE_TYPE")
	private String bounceType;

	@Column(name = "FCREASON")
	private String reason;

	@Column(name = "FCREASON_CODE")
	private String reasonCode;

	@Column(name = "FCSUBJECT")
	private String subject;

	@Column(name = "FCCONTACT_INFO")
	private String contactInfo;

	@Column(name = "FCNUMERO_DE_CUENTA")
	private String numeroDeCuenta;

	@Column(name = "FCOFFER_NAME")
	private String offerName;

	@Column(name = "FCOFFER_NUMBER")
	private String offerNumber;

	@Column(name = "FCOFFER_CATEGORY")
	private String offerCategory;

	@Column(name = "FCOFFER_URL")
	private String offerUrl;

	@Column(name = "FCREGION_NAME")
	private String regionName;

	@Column(name = "FCRULE_NAME")
	private String ruleName;

	@Column(name = "FCCONTENT_TYPE")
	private String contentType;

	@Column(name = "FCCONTENT")
	private String content;

	@Column(name = "FCSIGNATURE_ID")
	private String signatureId;

	@Column(name = "FCSIGNATURE")
	private String signature;

	@Column(name = "FCCONTENT_INDEX")
	private String contentIndex;

	@Column(name = "FCOFFER_SIGNATURE_ID")
	private String offerSignatureId;

	@Column(name = "FCDYNAMIC_CONTENT_SIGNATURE_ID")
	private String dynamicContentSignatureId;

	@Column(name = "FCMESSAGE_SIZE")
	private String messageSize;

	@Column(name = "FCSEGMENT_INFO")
	private String segmentInfo;

	@Column(name = "FCFORM_ID")
	private String formId;

	@Column(name = "FCFORM_NAME")
	private String formName;

	@Column(name = "FCEXTERNAL_CAMPAIGN_ID")
	private String externalCampaignId;

	@Column(name = "FCSF_CAMPAIGN_ID")
	private String sampaignId;

	@Column(name = "FCCAMPAIGN_NAME")
	private String campaignName;

	@Column(name = "FCLAUNCH_NAME")
	private String launchName;

	@Column(name = "FCLAUNCH_STATUS")
	private String launchStatus;

	@Column(name = "FCLAUNCH_TYPE")
	private String launchType;

	@Column(name = "FCLAUNCH_CHARSET")
	private String launchCharset;
	
	@Column(name = "FCPURPOSE")
	private String purpose;

	@Column(name = "FCDESCRIPTION")
	private String description;

	@Column(name = "FCPRODUCT_CATEGORY")
	private String productCategory;

	@Column(name = "FCPRODUCT_TYPE")
	private String productType;

	@Column(name = "FCMARKETING_STRATEGY")
	private String marketingStrategy;

	@Column(name = "FCMARKETING_PROGRAM")
	private String marketingProgram;

	@Column(name = "FCLAUNCH_ERROR_CODE")
	private String launchErrorCode;

	@Column(name = "FCLAUNCH_STARTED_DT")
	private String launchStartedDt;

	@Column(name = "FCLAUNCH_COMPLETED_DT")
	private String launchCompletedDt;

	@Column(name = "FCSTAGE_ID")
	private String stageId;

	@Column(name = "FCCAMPAIGN_VERSION_ID")
	private String campaignVersionId;

	@Column(name = "FCCAMPAIGN_VERSION_NAME")
	private String campaignVersionName;

	@Column(name = "FCTEST_START_DT")
	private String testStartDt;

	@Column(name = "FCTEST_END_DT")
	private String testEndDt;

	@Column(name = "FCWINNER_SELECTION_TYPE")
	private String winnerSelectionType;

	@Column(name = "FCTEST_SUCCESS_METRIC")
	private String testSuccessMetric;

	@Column(name = "FCIS_WINNER")
	private String isWinner;

	@Column(name = "FCCAMPAIGN_VERSION_CONTENT")
	private String campaignVersionContent;

	@Column(name = "FCPROGRAM_ID")
	private String programId;

	@Column(name = "FCPROGRAM_NAME")
	private String programName;

	@Column(name = "FCPROGRAM_DESCRIPTION")
	private String programDescription;

	@Column(name = "FCAGGREGATOR_ID")
	private String aggregatorId;

	@Column(name = "FCCOUNTRY_CODE")
	private String countryCode;

	@Column(name = "FCMOBILE_CODE")
	private String mobileCode;

	@Column(name = "FCMOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "FCMOBILE_KEYWORD")
	private String mobileKeyword;

	@Column(name = "FCMOBILE_CHANNEL")
	private String mobileChannel;

	@Column(name = "FCMOBILE_CARRIER")
	private String mobileCarrier;

	@Column(name = "FCMOBILE_COUNTRY")
	private String mobileCountry;

	@Column(name = "FCREMOTE_ADDR")
	private String remoteAddr;

	@Column(name = "FCMSG_SPLIT_COUNT")
	private String msgSplitCount;

	@Column(name = "FCSMS_SENT_UUID")
	private String smsSentUuid;

	@Column(name = "FCDELIVERED_FLAG")
	private String deliveredFlag;

	@Column(name = "FCAGGREGATOR_MESSAGE_ID")
	private String aggregatorMessageId;

	@Column(name = "FCAGGREGATOR_MESSAGE_SUBID")
	private String aggregatorMessageSubid;

	@Column(name = "FCAGGREGATOR_STATUS_CODE")
	private String aggregatorStatusCode;

	@Column(name = "FCAGGREGATOR_STATUS_DESC")
	private String aggregatorStatusDesc;

	@Column(name = "FCMSG_BODY")
	private String msgBody;

	@Column(name = "FCSOURCE")
	private String source;

	@Column(name = "FCMO_MSG")
	private String moMsg;

	@Column(name = "FCFAILURE_REASON")
	private String failureReason;

	@Column(name = "FCORDER_ID")
	private String orderId;

	@Column(name = "FCORDER_TOTAL")
	private String orderTotal;

	@Column(name = "FCORDER_QUANTITY")
	private String orderQuantity;

	@Column(name = "FCUSER_AGENT_STRING")
	private String userAgentString;

	@Column(name = "FCOPERATING_SYSTEM")
	private String operatingSystem;

	@Column(name = "FCBROWSER")
	private String browser;

	@Column(name = "FCBROWSER_TYPE")
	private String browserType;

	@Column(name = "FCOPERATING_SYSTEM_INFO")
	private String operatingSystemInfo;

	@Column(name = "FCOS_VENDOR_INFO")
	private String osVendorInfo;

	@Column(name = "FCBROWSER_INFO")
	private String browserInfo;

	@Column(name = "FCBROWSER_TYPE_INFO")
	private String browserTypeInfo;

	@Column(name = "FCDEVICE_TYPE_INFO")
	private String deviceTypeInfo;

	/**
	 * @return the idCuenta
	 */
	public Long getIdCuenta() {
		return idCuenta;
	}

	/**
	 * @param idCuenta the idCuenta to set
	 */
	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	/**
	 * @return the eventTypeId
	 */
	public String getEventTypeId() {
		return eventTypeId;
	}

	/**
	 * @param eventTypeId the eventTypeId to set
	 */
	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	/**
	 * @return the eventUuid
	 */
	public String getEventUuid() {
		return eventUuid;
	}

	/**
	 * @param eventUuid the eventUuid to set
	 */
	public void setEventUuid(String eventUuid) {
		this.eventUuid = eventUuid;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the listId
	 */
	public String getListId() {
		return listId;
	}

	/**
	 * @param listId the listId to set
	 */
	public void setListId(String listId) {
		this.listId = listId;
	}

	/**
	 * @return the riid
	 */
	public String getRiid() {
		return riid;
	}

	/**
	 * @param riid the riid to set
	 */
	public void setRiid(String riid) {
		this.riid = riid;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the eventCapturedDt
	 */
	public String getEventCapturedDt() {
		return eventCapturedDt;
	}

	/**
	 * @param eventCapturedDt the eventCapturedDt to set
	 */
	public void setEventCapturedDt(String eventCapturedDt) {
		this.eventCapturedDt = eventCapturedDt;
	}

	/**
	 * @return the eventStoredDt
	 */
	public String getEventStoredDt() {
		return eventStoredDt;
	}

	/**
	 * @param eventStoredDt the eventStoredDt to set
	 */
	public void setEventStoredDt(String eventStoredDt) {
		this.eventStoredDt = eventStoredDt;
	}

	/**
	 * @return the campaignId
	 */
	public String getCampaignId() {
		return campaignId;
	}

	/**
	 * @param campaignId the campaignId to set
	 */
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * @return the launchId
	 */
	public String getLaunchId() {
		return launchId;
	}

	/**
	 * @param launchId the launchId to set
	 */
	public void setLaunchId(String launchId) {
		this.launchId = launchId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the emailIsp
	 */
	public String getEmailIsp() {
		return emailIsp;
	}

	/**
	 * @param emailIsp the emailIsp to set
	 */
	public void setEmailIsp(String emailIsp) {
		this.emailIsp = emailIsp;
	}

	/**
	 * @return the emailFormat
	 */
	public String getEmailFormat() {
		return emailFormat;
	}

	/**
	 * @param emailFormat the emailFormat to set
	 */
	public void setEmailFormat(String emailFormat) {
		this.emailFormat = emailFormat;
	}

	/**
	 * @return the bounceType
	 */
	public String getBounceType() {
		return bounceType;
	}

	/**
	 * @param bounceType the bounceType to set
	 */
	public void setBounceType(String bounceType) {
		this.bounceType = bounceType;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the contactInfo
	 */
	public String getContactInfo() {
		return contactInfo;
	}

	/**
	 * @param contactInfo the contactInfo to set
	 */
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * @return the numeroDeCuenta
	 */
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	/**
	 * @param numeroDeCuenta the numeroDeCuenta to set
	 */
	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	/**
	 * @return the offerName
	 */
	public String getOfferName() {
		return offerName;
	}

	/**
	 * @param offerName the offerName to set
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	/**
	 * @return the offerNumber
	 */
	public String getOfferNumber() {
		return offerNumber;
	}

	/**
	 * @param offerNumber the offerNumber to set
	 */
	public void setOfferNumber(String offerNumber) {
		this.offerNumber = offerNumber;
	}

	/**
	 * @return the offerCategory
	 */
	public String getOfferCategory() {
		return offerCategory;
	}

	/**
	 * @param offerCategory the offerCategory to set
	 */
	public void setOfferCategory(String offerCategory) {
		this.offerCategory = offerCategory;
	}

	/**
	 * @return the offerUrl
	 */
	public String getOfferUrl() {
		return offerUrl;
	}

	/**
	 * @param offerUrl the offerUrl to set
	 */
	public void setOfferUrl(String offerUrl) {
		this.offerUrl = offerUrl;
	}

	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the signatureId
	 */
	public String getSignatureId() {
		return signatureId;
	}

	/**
	 * @param signatureId the signatureId to set
	 */
	public void setSignatureId(String signatureId) {
		this.signatureId = signatureId;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the contentIndex
	 */
	public String getContentIndex() {
		return contentIndex;
	}

	/**
	 * @param contentIndex the contentIndex to set
	 */
	public void setContentIndex(String contentIndex) {
		this.contentIndex = contentIndex;
	}

	/**
	 * @return the offerSignatureId
	 */
	public String getOfferSignatureId() {
		return offerSignatureId;
	}

	/**
	 * @param offerSignatureId the offerSignatureId to set
	 */
	public void setOfferSignatureId(String offerSignatureId) {
		this.offerSignatureId = offerSignatureId;
	}

	/**
	 * @return the dynamicContentSignatureId
	 */
	public String getDynamicContentSignatureId() {
		return dynamicContentSignatureId;
	}

	/**
	 * @param dynamicContentSignatureId the dynamicContentSignatureId to set
	 */
	public void setDynamicContentSignatureId(String dynamicContentSignatureId) {
		this.dynamicContentSignatureId = dynamicContentSignatureId;
	}

	/**
	 * @return the messageSize
	 */
	public String getMessageSize() {
		return messageSize;
	}

	/**
	 * @param messageSize the messageSize to set
	 */
	public void setMessageSize(String messageSize) {
		this.messageSize = messageSize;
	}

	/**
	 * @return the segmentInfo
	 */
	public String getSegmentInfo() {
		return segmentInfo;
	}

	/**
	 * @param segmentInfo the segmentInfo to set
	 */
	public void setSegmentInfo(String segmentInfo) {
		this.segmentInfo = segmentInfo;
	}

	/**
	 * @return the formId
	 */
	public String getFormId() {
		return formId;
	}

	/**
	 * @param formId the formId to set
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	/**
	 * @return the formName
	 */
	public String getFormName() {
		return formName;
	}

	/**
	 * @param formName the formName to set
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}

	/**
	 * @return the externalCampaignId
	 */
	public String getExternalCampaignId() {
		return externalCampaignId;
	}

	/**
	 * @param externalCampaignId the externalCampaignId to set
	 */
	public void setExternalCampaignId(String externalCampaignId) {
		this.externalCampaignId = externalCampaignId;
	}

	/**
	 * @return the sampaignId
	 */
	public String getSampaignId() {
		return sampaignId;
	}

	/**
	 * @param sampaignId the sampaignId to set
	 */
	public void setSampaignId(String sampaignId) {
		this.sampaignId = sampaignId;
	}

	/**
	 * @return the campaignName
	 */
	public String getCampaignName() {
		return campaignName;
	}

	/**
	 * @param campaignName the campaignName to set
	 */
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	/**
	 * @return the launchName
	 */
	public String getLaunchName() {
		return launchName;
	}

	/**
	 * @param launchName the launchName to set
	 */
	public void setLaunchName(String launchName) {
		this.launchName = launchName;
	}

	/**
	 * @return the launchStatus
	 */
	public String getLaunchStatus() {
		return launchStatus;
	}

	/**
	 * @param launchStatus the launchStatus to set
	 */
	public void setLaunchStatus(String launchStatus) {
		this.launchStatus = launchStatus;
	}

	/**
	 * @return the launchType
	 */
	public String getLaunchType() {
		return launchType;
	}

	/**
	 * @param launchType the launchType to set
	 */
	public void setLaunchType(String launchType) {
		this.launchType = launchType;
	}

	/**
	 * @return the launchCharset
	 */
	public String getLaunchCharset() {
		return launchCharset;
	}

	/**
	 * @param launchCharset the launchCharset to set
	 */
	public void setLaunchCharset(String launchCharset) {
		this.launchCharset = launchCharset;
	}

	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the marketingStrategy
	 */
	public String getMarketingStrategy() {
		return marketingStrategy;
	}

	/**
	 * @param marketingStrategy the marketingStrategy to set
	 */
	public void setMarketingStrategy(String marketingStrategy) {
		this.marketingStrategy = marketingStrategy;
	}

	/**
	 * @return the marketingProgram
	 */
	public String getMarketingProgram() {
		return marketingProgram;
	}

	/**
	 * @param marketingProgram the marketingProgram to set
	 */
	public void setMarketingProgram(String marketingProgram) {
		this.marketingProgram = marketingProgram;
	}

	/**
	 * @return the launchErrorCode
	 */
	public String getLaunchErrorCode() {
		return launchErrorCode;
	}

	/**
	 * @param launchErrorCode the launchErrorCode to set
	 */
	public void setLaunchErrorCode(String launchErrorCode) {
		this.launchErrorCode = launchErrorCode;
	}

	/**
	 * @return the launchStartedDt
	 */
	public String getLaunchStartedDt() {
		return launchStartedDt;
	}

	/**
	 * @param launchStartedDt the launchStartedDt to set
	 */
	public void setLaunchStartedDt(String launchStartedDt) {
		this.launchStartedDt = launchStartedDt;
	}

	/**
	 * @return the launchCompletedDt
	 */
	public String getLaunchCompletedDt() {
		return launchCompletedDt;
	}

	/**
	 * @param launchCompletedDt the launchCompletedDt to set
	 */
	public void setLaunchCompletedDt(String launchCompletedDt) {
		this.launchCompletedDt = launchCompletedDt;
	}

	/**
	 * @return the stageId
	 */
	public String getStageId() {
		return stageId;
	}

	/**
	 * @param stageId the stageId to set
	 */
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	/**
	 * @return the campaignVersionId
	 */
	public String getCampaignVersionId() {
		return campaignVersionId;
	}

	/**
	 * @param campaignVersionId the campaignVersionId to set
	 */
	public void setCampaignVersionId(String campaignVersionId) {
		this.campaignVersionId = campaignVersionId;
	}

	/**
	 * @return the campaignVersionName
	 */
	public String getCampaignVersionName() {
		return campaignVersionName;
	}

	/**
	 * @param campaignVersionName the campaignVersionName to set
	 */
	public void setCampaignVersionName(String campaignVersionName) {
		this.campaignVersionName = campaignVersionName;
	}

	/**
	 * @return the testStartDt
	 */
	public String getTestStartDt() {
		return testStartDt;
	}

	/**
	 * @param testStartDt the testStartDt to set
	 */
	public void setTestStartDt(String testStartDt) {
		this.testStartDt = testStartDt;
	}

	/**
	 * @return the testEndDt
	 */
	public String getTestEndDt() {
		return testEndDt;
	}

	/**
	 * @param testEndDt the testEndDt to set
	 */
	public void setTestEndDt(String testEndDt) {
		this.testEndDt = testEndDt;
	}

	/**
	 * @return the winnerSelectionType
	 */
	public String getWinnerSelectionType() {
		return winnerSelectionType;
	}

	/**
	 * @param winnerSelectionType the winnerSelectionType to set
	 */
	public void setWinnerSelectionType(String winnerSelectionType) {
		this.winnerSelectionType = winnerSelectionType;
	}

	/**
	 * @return the testSuccessMetric
	 */
	public String getTestSuccessMetric() {
		return testSuccessMetric;
	}

	/**
	 * @param testSuccessMetric the testSuccessMetric to set
	 */
	public void setTestSuccessMetric(String testSuccessMetric) {
		this.testSuccessMetric = testSuccessMetric;
	}

	/**
	 * @return the isWinner
	 */
	public String getIsWinner() {
		return isWinner;
	}

	/**
	 * @param isWinner the isWinner to set
	 */
	public void setIsWinner(String isWinner) {
		this.isWinner = isWinner;
	}

	/**
	 * @return the campaignVersionContent
	 */
	public String getCampaignVersionContent() {
		return campaignVersionContent;
	}

	/**
	 * @param campaignVersionContent the campaignVersionContent to set
	 */
	public void setCampaignVersionContent(String campaignVersionContent) {
		this.campaignVersionContent = campaignVersionContent;
	}

	/**
	 * @return the programId
	 */
	public String getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(String programId) {
		this.programId = programId;
	}

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * @return the programDescription
	 */
	public String getProgramDescription() {
		return programDescription;
	}

	/**
	 * @param programDescription the programDescription to set
	 */
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	/**
	 * @return the aggregatorId
	 */
	public String getAggregatorId() {
		return aggregatorId;
	}

	/**
	 * @param aggregatorId the aggregatorId to set
	 */
	public void setAggregatorId(String aggregatorId) {
		this.aggregatorId = aggregatorId;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the mobileCode
	 */
	public String getMobileCode() {
		return mobileCode;
	}

	/**
	 * @param mobileCode the mobileCode to set
	 */
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the mobileKeyword
	 */
	public String getMobileKeyword() {
		return mobileKeyword;
	}

	/**
	 * @param mobileKeyword the mobileKeyword to set
	 */
	public void setMobileKeyword(String mobileKeyword) {
		this.mobileKeyword = mobileKeyword;
	}

	/**
	 * @return the mobileChannel
	 */
	public String getMobileChannel() {
		return mobileChannel;
	}

	/**
	 * @param mobileChannel the mobileChannel to set
	 */
	public void setMobileChannel(String mobileChannel) {
		this.mobileChannel = mobileChannel;
	}

	/**
	 * @return the mobileCarrier
	 */
	public String getMobileCarrier() {
		return mobileCarrier;
	}

	/**
	 * @param mobileCarrier the mobileCarrier to set
	 */
	public void setMobileCarrier(String mobileCarrier) {
		this.mobileCarrier = mobileCarrier;
	}

	/**
	 * @return the mobileCountry
	 */
	public String getMobileCountry() {
		return mobileCountry;
	}

	/**
	 * @param mobileCountry the mobileCountry to set
	 */
	public void setMobileCountry(String mobileCountry) {
		this.mobileCountry = mobileCountry;
	}

	/**
	 * @return the remoteAddr
	 */
	public String getRemoteAddr() {
		return remoteAddr;
	}

	/**
	 * @param remoteAddr the remoteAddr to set
	 */
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	/**
	 * @return the msgSplitCount
	 */
	public String getMsgSplitCount() {
		return msgSplitCount;
	}

	/**
	 * @param msgSplitCount the msgSplitCount to set
	 */
	public void setMsgSplitCount(String msgSplitCount) {
		this.msgSplitCount = msgSplitCount;
	}

	/**
	 * @return the smsSentUuid
	 */
	public String getSmsSentUuid() {
		return smsSentUuid;
	}

	/**
	 * @param smsSentUuid the smsSentUuid to set
	 */
	public void setSmsSentUuid(String smsSentUuid) {
		this.smsSentUuid = smsSentUuid;
	}

	/**
	 * @return the deliveredFlag
	 */
	public String getDeliveredFlag() {
		return deliveredFlag;
	}

	/**
	 * @param deliveredFlag the deliveredFlag to set
	 */
	public void setDeliveredFlag(String deliveredFlag) {
		this.deliveredFlag = deliveredFlag;
	}

	/**
	 * @return the aggregatorMessageId
	 */
	public String getAggregatorMessageId() {
		return aggregatorMessageId;
	}

	/**
	 * @param aggregatorMessageId the aggregatorMessageId to set
	 */
	public void setAggregatorMessageId(String aggregatorMessageId) {
		this.aggregatorMessageId = aggregatorMessageId;
	}

	/**
	 * @return the aggregatorMessageSubid
	 */
	public String getAggregatorMessageSubid() {
		return aggregatorMessageSubid;
	}

	/**
	 * @param aggregatorMessageSubid the aggregatorMessageSubid to set
	 */
	public void setAggregatorMessageSubid(String aggregatorMessageSubid) {
		this.aggregatorMessageSubid = aggregatorMessageSubid;
	}

	/**
	 * @return the aggregatorStatusCode
	 */
	public String getAggregatorStatusCode() {
		return aggregatorStatusCode;
	}

	/**
	 * @param aggregatorStatusCode the aggregatorStatusCode to set
	 */
	public void setAggregatorStatusCode(String aggregatorStatusCode) {
		this.aggregatorStatusCode = aggregatorStatusCode;
	}

	/**
	 * @return the aggregatorStatusDesc
	 */
	public String getAggregatorStatusDesc() {
		return aggregatorStatusDesc;
	}

	/**
	 * @param aggregatorStatusDesc the aggregatorStatusDesc to set
	 */
	public void setAggregatorStatusDesc(String aggregatorStatusDesc) {
		this.aggregatorStatusDesc = aggregatorStatusDesc;
	}

	/**
	 * @return the msgBody
	 */
	public String getMsgBody() {
		return msgBody;
	}

	/**
	 * @param msgBody the msgBody to set
	 */
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the moMsg
	 */
	public String getMoMsg() {
		return moMsg;
	}

	/**
	 * @param moMsg the moMsg to set
	 */
	public void setMoMsg(String moMsg) {
		this.moMsg = moMsg;
	}

	/**
	 * @return the failureReason
	 */
	public String getFailureReason() {
		return failureReason;
	}

	/**
	 * @param failureReason the failureReason to set
	 */
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderTotal
	 */
	public String getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the orderQuantity
	 */
	public String getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * @param orderQuantity the orderQuantity to set
	 */
	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * @return the userAgentString
	 */
	public String getUserAgentString() {
		return userAgentString;
	}

	/**
	 * @param userAgentString the userAgentString to set
	 */
	public void setUserAgentString(String userAgentString) {
		this.userAgentString = userAgentString;
	}

	/**
	 * @return the operatingSystem
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * @return the browserType
	 */
	public String getBrowserType() {
		return browserType;
	}

	/**
	 * @param browserType the browserType to set
	 */
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	/**
	 * @return the operatingSystemInfo
	 */
	public String getOperatingSystemInfo() {
		return operatingSystemInfo;
	}

	/**
	 * @param operatingSystemInfo the operatingSystemInfo to set
	 */
	public void setOperatingSystemInfo(String operatingSystemInfo) {
		this.operatingSystemInfo = operatingSystemInfo;
	}

	/**
	 * @return the osVendorInfo
	 */
	public String getOsVendorInfo() {
		return osVendorInfo;
	}

	/**
	 * @param osVendorInfo the osVendorInfo to set
	 */
	public void setOsVendorInfo(String osVendorInfo) {
		this.osVendorInfo = osVendorInfo;
	}

	/**
	 * @return the browserInfo
	 */
	public String getBrowserInfo() {
		return browserInfo;
	}

	/**
	 * @param browserInfo the browserInfo to set
	 */
	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	/**
	 * @return the browserTypeInfo
	 */
	public String getBrowserTypeInfo() {
		return browserTypeInfo;
	}

	/**
	 * @param browserTypeInfo the browserTypeInfo to set
	 */
	public void setBrowserTypeInfo(String browserTypeInfo) {
		this.browserTypeInfo = browserTypeInfo;
	}

	/**
	 * @return the deviceTypeInfo
	 */
	public String getDeviceTypeInfo() {
		return deviceTypeInfo;
	}

	/**
	 * @param deviceTypeInfo the deviceTypeInfo to set
	 */
	public void setDeviceTypeInfo(String deviceTypeInfo) {
		this.deviceTypeInfo = deviceTypeInfo;
	}


}
