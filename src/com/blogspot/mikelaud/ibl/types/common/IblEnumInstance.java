package com.blogspot.mikelaud.ibl.types.common;

public interface IblEnumInstance<T extends IblEnumInstance<?>> extends IblEnum {

	T getInstance();
	
	@Override
	default int getId() {
		return getInstance().getId();
	}
	
	@Override
	default String getName() {
		return getInstance().getName();
	}
	
	@Override
	default String getDescription() {
		return getInstance().getDescription();
	}

}
