package com.blogspot.mikelaud.ibl.types;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

public enum IblError implements IblEnum {
	
	HMDS_ERROR_MESSAGE(162, "Historical market data Service error message."),
	HMDS_QUERY_MESSAGE(165, "Historical market Data Service query message."),
	HMDS_EXPIRED_CONTRACT(166, "HMDS Expired Contract Violation.");

	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	
	private IblError
	(	int aId
	,	String aDescription
	) {
		ID = aId;
		NAME = this.name();
		DESCRIPTION = aDescription; 
	}
	
	@Override
	public int getId() {
		return ID;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String toString() {
		String message = String.format
		(	"id={%d} name={%s}"
		,	ID
		,	NAME
		);
		return message;
	}
	
}
