/*
 * Copyright (C) 2017 Adam Huang <poisondog@gmail.com>
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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author Adam Huang
 * @since 2017-10-13
 */
public class Data {
	private byte[] mContent;

	/**
	 * Constructor
	 */
	public Data() {
		mContent = new byte[0];
	}

	/**
	 * Constructor
	 */
	public Data(byte[] content) {
		mContent = content;
	}

	public byte[] getContent() {
		return mContent;
	}

	public boolean isEmpty() {
		return mContent.length <= 0;
	}

	public InputStream toInputStream() {
		return new ByteArrayInputStream(mContent);
	}
}
