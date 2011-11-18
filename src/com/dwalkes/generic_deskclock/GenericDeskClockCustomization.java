/*
 * Copyright (C) 2011 Dan Walkes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dwalkes.generic_deskclock;

import android.content.Intent;

/**
 * A class used to customize the desk clock for a specific application
 * To use, override the class and use setInstance() to specify the instance in your
 * Application class onCreate.
 */
public class GenericDeskClockCustomization {
	public static GenericDeskClockCustomization mInstance = null;
	
	protected GenericDeskClockCustomization() {
		
	}

	/**
	 * Use a specific instance as the generic desk clock customization class.  Must be
	 * called in your onCreate() before any other alarm related objects are used or instantiated
	 * @param instance to use as generic desk clock customization
	 */
	public static synchronized void setInstance(GenericDeskClockCustomization instance) {
		if( mInstance != null ) {
			throw new RuntimeException("Attempting to set customization when instance has already been obtained");
		}
		mInstance = instance;
	}
	
	
	public static synchronized GenericDeskClockCustomization getInstance() {
		if( mInstance == null ) {
			mInstance = new GenericDeskClockCustomization();
		}
		return mInstance;
	}

	/**
	 * @return an Intent to use when firing the alarm.  Allows an application to specify
	 * a different action than displaying the alert, for instance to check for conditions
	 * before conditionally firing the alarm. 
	 */
	public Intent getAlarmFireIntent() {
		return new Intent(Alarms.ALARM_ALERT_ACTION);
	}
	
	/**
	 * @return a string representing the content URI used to store alarm related data.  Must 
	 * match value specified in the applications manifest.
	 * All applications must override, otherwise you will be sharing a datastore with any other
	 * applications which may happen to use this library.
	 */
	public String getContentURIAuthority() {
		return new String("com.dwalkes.generic_deskclock");
	}
	
	public String getAlarmScreenTitle() {
		return new String("Alarm");
	}
	
}
