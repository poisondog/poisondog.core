/*
 * Copyright (C) 2014 Adam Huang <poisondog@gmail.com>
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
package poisondog.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author poisondog <poisondog@gmail.com>
 */
public class InverterRuleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() throws Exception {
		Assert.assertTrue(new InverterRule(new FalseRule()).execute(null));
		Assert.assertFalse(new InverterRule(new TrueRule()).execute(null));
	}

//	@Test
//	public void testConstructor() throws Exception {
//		InverterRule rule = (InverterRule)Class.forName("InverterRule").newInstance();
//		try {
//			rule.execute(null);
//			Assert.fail("no rule can invert");
//		} catch(Exception e) {
//			Assert.assertTrue(true);
//		}
//	}
}
