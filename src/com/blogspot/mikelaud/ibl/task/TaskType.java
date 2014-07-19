package com.blogspot.mikelaud.ibl.task;

public interface TaskType {

	Class<?> getTaskClass();
	TaskGroup getGroup();
	String getName();
	String getDescription();
	
}
