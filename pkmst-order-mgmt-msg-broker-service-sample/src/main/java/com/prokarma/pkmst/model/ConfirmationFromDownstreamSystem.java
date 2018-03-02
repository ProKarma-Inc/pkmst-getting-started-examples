package com.prokarma.pkmst.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmationFromDownstreamSystem {

	@JsonProperty("sessionId")
	private String sessionId;
	
	@JsonProperty("confirmationId")
	private String confirmationId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmationId == null) ? 0 : confirmationId.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfirmationFromDownstreamSystem other = (ConfirmationFromDownstreamSystem) obj;
		if (confirmationId == null) {
			if (other.confirmationId != null)
				return false;
		} else if (!confirmationId.equals(other.confirmationId))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkOrderPlacementConfirmation [sessionId=" + sessionId + ", confirmationId=" + confirmationId + "]";
	}
	
	
	
}
