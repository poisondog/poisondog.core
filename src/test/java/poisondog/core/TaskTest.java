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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import poisondog.core.MockMission;
/**
 * @author Adam Huang
 */
public class TaskTest {
	private MockMission mMission;
	private Task<String> mTask;

	@Before
	public void setUp() throws Exception {
		mMission = new MockMission("output");
		mTask = new Task<String>(mMission, "input");
	}

	@Test
	public void testInterface() throws Exception {
		Assert.assertTrue(mTask instanceof Runnable);
	}

	@Test
	public void testRun() throws Exception {
		mTask.run();
		Assert.assertEquals("input", mMission.getInput());
		Assert.assertTrue(mMission.isPerformed());
	}

	@Test
	public void testWhenException() throws Exception {
		// TODO complete it
	}

	@Test
	public void testWhenExceptionHandlerException() throws Exception {
		// TODO complete it
	}
}
