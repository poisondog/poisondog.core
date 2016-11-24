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

/**
 * @author <a href="mailto:poisondog@gmail.com">Adam Huang</a>
 */
public class MockMissionTest {
	private MockMission mMission;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mMission = new MockMission("Output 1");
	}

	@Test
	public void testExecute() throws Exception {
		Assert.assertFalse(mMission.isPerformed());
		Assert.assertEquals("Output 1", mMission.execute("1"));
		Assert.assertTrue(mMission.isPerformed());
	}

	@Test
	public void testInput() throws Exception {
		mMission.execute("123");
		Assert.assertEquals("123", mMission.getInput());
	}

	@Test
	public void testSetter() throws Exception {
		mMission.setOutput("Output 2");
		Assert.assertEquals("Output 2", mMission.execute("2"));
	}

	@Test
	public void testSetNull() throws Exception {
		mMission.setOutput(null);
		Assert.assertNull(mMission.execute("3"));
	}

	@Test
	public void testException() throws Exception {
		mMission.setException(new IllegalArgumentException("just test"));
		try {
			mMission.execute("312");
			Assert.fail("need to throw exception");
		}catch(Exception e) {
			Assert.assertTrue(true);
		}
	}
}
