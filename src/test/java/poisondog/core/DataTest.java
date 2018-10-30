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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Huang
 * @since 2017-10-13
 */
public class DataTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEmpty() throws Exception {
		Data data = new Data();
		Assert.assertTrue(data.isEmpty());
	}

	@Test
	public void testWithContent() throws Exception {
		Data data = new Data("content".getBytes());
		Assert.assertEquals("content", new String(data.getContent()));
		Assert.assertEquals("content", data.toString());
	}

	@Test
	public void testWithString() throws Exception {
		Data data = new Data("content");
		Assert.assertEquals("content", data.toString());
	}
}
