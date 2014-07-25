package com.blogspot.mikelaud.ibl.task.event;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.blogspot.mikelaud.ibl.out.Out;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.blogspot.mikelaud.ibl.task.call.CallTypesFactory;

public class EventTargets {

	private List<List<CallType>> mEvents;
	
	private void initTargetCall
	(	int aTargetCallNo
	,	Class<?> aCallClass
	,	Class<?> aOutClass
	,	Class<?> aEventClass
	) {
		EventType eventKey = EventTypesFactory.get().toType(aEventClass);
		int eventIndex = eventKey.ordinal();
		List<CallType> callTargets = mEvents.get(eventIndex);
		//
		CallType callTarget = CallTypesFactory.get().toType(aCallClass);
		callTargets.add(callTarget);
	}
	
	private void initTargetCalls() {
		int targetCallNo = 0;
		for (CallType callType : CallType.values()) {
			Class<?> callClass = callType.getTaskClass();
			Field[] callFields = callClass.getDeclaredFields();
			for (Field callField : callFields) {
				Type callFieldType = callField.getGenericType();
				if (callFieldType instanceof ParameterizedType) {
					ParameterizedType genericType =
						(ParameterizedType) callFieldType;
					Type outType = genericType.getRawType();
					Type eventType = genericType.getActualTypeArguments()[0];
					if (outType instanceof Class<?>) {
						Class<?> outClass = (Class<?>) outType;
						if (eventType instanceof Class<?>) {
							Class<?> eventClass = (Class<?>) eventType;
							if (Out.class.isAssignableFrom(outClass)) {
								initTargetCall
								(	targetCallNo++
								,	callClass
								,	outClass
								,	eventClass
								);
							}
						}
					}
				}
			}
		}
	}

	public List<CallType> getTargets(EventType aEventType) {
		int eventIndex = aEventType.ordinal();
		return mEvents.get(eventIndex);
	}
	
	public EventTargets() {
		final int EVENTS_COUNT = EventType.values().length;
		mEvents = new ArrayList<>(EVENTS_COUNT);
		for (int i = 0; i < EVENTS_COUNT; i++) {
			mEvents.add(new ArrayList<CallType>(1));
		}
		//
		initTargetCalls();
		//
		for (int i = 0; i < EVENTS_COUNT; i++) {
			mEvents.set(i, Collections.unmodifiableList(mEvents.get(i)));
		}
	}
	
}
