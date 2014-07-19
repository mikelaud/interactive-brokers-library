package com.blogspot.mikelaud.ibl.task;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class TaskTypes<T extends Enum<T> & TaskType> {

	private Class<T> mEnumClass;
	private Map<Class<?>,T> mMap;
	
	private void createMap() {
		mMap = new HashMap<>();
		for (T enumElement : EnumSet.allOf(mEnumClass)) {
			Class<?> key = enumElement.getTaskClass(); 
			mMap.put(key, enumElement);
		}
	}
	
	public T toType(Class<?> aTaskClass) {
		T taskType = mMap.get(aTaskClass);
		if (null == taskType) {
			String errorMessage = String.format
			(	"Task enum value (type) not found for class: %s."
			,	aTaskClass.getName()
			);
			throw new Error(errorMessage);
		}
		return taskType;
	}
	
	public T toType(TaskInnerObject aTaskInnerObject) {
		Class<?> taskClass = aTaskInnerObject.getClass().getEnclosingClass();
		if (null == taskClass) {
			throw new Error("Task class not found for TaskInnerObject.");
		}
		return toType(taskClass);
	}
	
	public TaskTypes(Class<T> aEnumClass) {
		mEnumClass = aEnumClass;
		createMap();
	}

}
