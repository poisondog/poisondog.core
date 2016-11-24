/*
 * Copyright (C) 2014 Adam Huang
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

/**
 * @author <a href="mailto:poisondog@gmail.com">Adam Huang</a>
 */
public class MockMission<T> implements Mission<T> {
	private boolean mPerformed;
	private Object mInput;
	private Object mOutput;
	private Exception mException;

	public MockMission(Object output) {
		setOutput(output);
	}

	public void setOutput(Object output) {
		mPerformed = false;
		mOutput = output;
	}

	public void setException(Exception exception) {
		mException = exception;
	}

	@Override
	public Object execute(T input) throws Exception {
		mPerformed = true;
		mInput = input;
		if (mException != null)
			throw mException;
		return mOutput;
	}

	public Object getInput() {
		return mInput;
	}

	public boolean isPerformed() {
		return mPerformed;
	}
}
