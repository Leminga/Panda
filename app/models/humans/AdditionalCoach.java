package models.humans;

import java.util.List;

import javax.persistence.Entity;

import models.AdditionalPacket;

import play.data.validation.Constraints.Required;

@Entity
public class AdditionalCoach extends Coach {
	
	@Required
	private List <AdditionalPacket>additionalPackets;

	public List<AdditionalPacket> getAdditionalPackets() {
		return additionalPackets;
	}

	public void setAdditionalPackets(List<AdditionalPacket> additionalPackets) {
		this.additionalPackets = additionalPackets;
	}
	
}
