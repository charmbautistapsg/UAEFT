/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity(name = "TPI_PAYMENT_MESSAGES_ACKNACK")
public class PaymentMessageAcknowledgement {

	@Id
	@Column(name = "PMA_RID_MESSAGES_ACKNACK")
	private String ackNackMessageId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PMA_RID_MESSAGES_OUTPUT")
	private PaymentMessageOutput outputMessage;
	
	@Lob
	@Column(name = "PMA_TXT_MESSAGE_ACKNACK", length = 1024)
	private String acknowledgedMessage;
	
	@Column(name = "PMA_DTE_MESSAGE_RECEIVE_DATE")
	private LocalDate messageReceivedDate;
	
	@Column(name = "PMA_IND_ACK")
	private Boolean acknowledgementIndicator;
	
	@Column(name = "PMA_UID_REC_CREATE_USERID")
	private String createUserId;

	@Column(name = "PMA_UID_REC_UPDATE_USERID")
	private String updateUserId;

	@Column(name = "PMA_TSP_REC_CREATE_TIMESTAMP")
	private LocalDateTime  createTimeStamp;

	@Column(name = "PMA_TSP_REC_UPDATE_TIMESTAMP")
	private LocalDateTime  updateTimeStamp = LocalDateTime.now();

	@Column(name = "PMA_CDE_REC_CREATE_COUNTRY")
	private String createCountry;

	@Column(name = "PMA_CDE_REC_UPDATE_COUNTRY")
	private String updateCountry;

	@Column(name = "PMA_CDE_REC_CREATE_LOCATION")
	private String createLocation;

	@Column(name = "PMA_CDE_REC_UPDATE_LOCATION")
	private String updateLocation;

	@Column(name = "PMA_TXT_REC_CREATE_IP")
	private String createIp;

	@Column(name = "PMA_TXT_REC_UPDATE_IP")
	private String updateIp;
}
