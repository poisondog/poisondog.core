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
 * @author Adam Huang <poisondog@gmail.com>
 */
public class OrderMissionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() throws Exception {
		OrderMission order = new OrderMission();
		order.add(new DebugMission("1t"));
		order.add(new DebugMission("2b"));
		order.add(new DebugMission("c3"));
		Assert.assertEquals("71t2bc3", order.execute("7"));
	}
}
