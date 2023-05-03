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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.psglobal.uaeftmt103.domain.enums.MessageOutputStatus;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "TPI_PAYMENT_MESSAGES_OUTPUT")
public class PaymentMessageOutput {
	@Id
	@Column(name = "PMO_RID_MESSAGES_OUTPUT")
	private String outputMessageId;
	
	@Column(name = "PMO_RID_MESSAGE_FORMAT")
	private String messageFormatId;

	@Column(name = "PMO_RID_METHOD_MESSAGE_TYPES")
	private String messageTypeId;

	@Column(name = "PMO_RID_OUT_SOURCE", nullable = false)
	private String outputSourceId;
	
	@Lob 
	@Column(name = "PMO_TXT_MESSAGE_OUTPUT", length = 1024)
	private String outputMessage;
	
	@OneToMany(mappedBy = "outputMessage", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<PaymentMessageAcknowledgement> acknowledgements = new ArrayList<PaymentMessageAcknowledgement>();

	@Enumerated(EnumType.STRING)
	@Column(name = "PMO_CDE_MESSAGE_STATUS", nullable = false)
	private MessageOutputStatus messageStatus;

	@Column(name = "PMO_NUM_MESSAGE_SENT_SEQUENCE")
	private String sequenceMessageSent;
	
	@Column(name = "PMO_DTE_MESSAGE_SENT_DATE")
	private LocalDate dateMessageSent;

	@Column(name = "PMO_UID_REC_CREATE_USERID")
	private String createUserId;

	@Column(name = "PMO_UID_REC_UPDATE_USERID")
	private String updateUserId;

	@Column(name = "PMO_TSP_REC_CREATE_TIMESTAMP")
	private LocalDateTime createTimeStamp;

	@Column(name = "PMO_TSP_REC_UPDATE_TIMESTAMP")
	private LocalDateTime updateTimeStamp = LocalDateTime.now();

	@Column(name = "PMO_CDE_REC_CREATE_COUNTRY")
	private String createCountry;

	@Column(name = "PMO_CDE_REC_UPDATE_COUNTRY")
	private String updateCountry;

	@Column(name = "PMO_CDE_REC_CREATE_LOCATION")
	private String createLocation;

	@Column(name = "PMO_TXT_REC_CREATE_IP")
	private String createIp;

	@Column(name = "PMO_TXT_REC_UPDATE_IP")
	private String updateIp;

	@Column(name = "PMO_CDE_REC_UPDATE_LOCATION")
	private String updateLocation;

	public PaymentMessageOutput(String outputMessageId, String outputMessage, String messageFormatId, String outputSourceId, MessageOutputStatus messageStatus
			, LocalDateTime createTimeStamp, String createUserId, LocalDate dateMessageSent)
	{
		this.outputMessageId=outputMessageId;
		this.outputMessage=outputMessage;
		this.messageFormatId=messageFormatId;
		this.outputSourceId=outputSourceId;
		this.messageStatus=messageStatus;
		this.createTimeStamp=createTimeStamp;
		this.createUserId=createUserId;
		this.dateMessageSent=dateMessageSent;

	}

	
}
