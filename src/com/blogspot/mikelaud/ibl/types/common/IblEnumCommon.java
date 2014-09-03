package com.blogspot.mikelaud.ibl.types.common;

import java.util.Objects;

import com.blogspot.mikelaud.ibl.types.IblString;

public class IblEnumCommon<T extends IblEnum> implements IblEnum, Comparable<T> {

	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	
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
	public boolean equals(Object aOtherObject) {
		if (this == aOtherObject) return true;
		if (null == aOtherObject) return false;
		if (getClass() != aOtherObject.getClass()) return false;
		IblEnum other = (IblEnum) aOtherObject;
		return Objects.equals(NAME, other.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(NAME);
	}
	
	@Override
	public int compareTo(T aOther) {
		String name1 = IblString.nvl(getName());
		String name2 = IblString.nvl(aOther.getName());
		return name1.compareTo(name2);
	}
	
	@Override
	public String toString() {
		String message = String.format
		(	"id=\"%d\" name=\"%s\" description=\"%s\""
		,	ID
		,	NAME
		,	DESCRIPTION
		);
		return message;
	}

	public IblEnumCommon
	(	int aId
	,	String aName
	,	String aDescription
	) {
		ID = aId;
		NAME = aName;
		DESCRIPTION = aDescription;
	}
	
}
