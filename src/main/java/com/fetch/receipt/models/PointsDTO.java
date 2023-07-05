package com.fetch.receipt.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PointsDTO {
	Integer points;

	public PointsDTO(Integer points) {
		super();
		this.points = points;
	}

}
