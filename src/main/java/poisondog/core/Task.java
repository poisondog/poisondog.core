/*
 * Copyright (C) 2015 Adam Huang <poisondog@gmail.com>
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
package poisondog.core;

import poisondog.core.Mission;
import poisondog.core.NoMission;

/**
 * @author Adam Huang
 */
public class Task<T> implements Runnable {
	private Mission<T> mMission;
	private Mission mHandler;
	private T mInput;
	private Mission<Exception> mExceptionHandler;

	/**
	 * Constructor
	 */
	public Task(Mission<T> mission, T input) {
		this(mission, input, new NoMission());
	}

	/**
	 * Constructor
	 */
	public Task(Mission<T> mission, T input, Mission handler) {
		mMission = mission;
		mInput = input;
		mHandler = handler;
		mExceptionHandler = new NoMission<Exception>();
	}

	public void setExceptionHandler(Mission<Exception> handler) {
		mExceptionHandler = handler;
	}

	@Override
	public void run() {
		try {
			mHandler.execute(mMission.execute(mInput));
		} catch(Exception e) {
			try {
				mExceptionHandler.execute(e);
			} catch(Exception v) {
				throw new IllegalArgumentException("Exception Handler did not to throw Exception!");
			}
		}
	}
}
