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
import org.mockito.Mockito;
/**
 * @author poisondog <poisondog@gmail.com>
 */
public class AndRuleTest {
	private AndRule mRule;

	@Before
	public void setUp() throws Exception {
		mRule = new AndRule();
	}

	@Test
	public void testExecute1() throws Exception {
		mRule.add(new FalseRule());
		mRule.add(new FalseRule());
		Assert.assertFalse(mRule.execute(null));
	}

	@Test
	public void testExecute2() throws Exception {
		mRule.add(new FalseRule());
		mRule.add(new TrueRule());
		Assert.assertFalse(mRule.execute(null));
	}

	@Test
	public void testExecute3() throws Exception {
		mRule.add(new TrueRule());
		mRule.add(new FalseRule());
		Assert.assertFalse(mRule.execute(null));
	}

	@Test
	public void testExecute4() throws Exception {
		mRule.add(new TrueRule());
		mRule.add(new TrueRule());
		Assert.assertTrue(mRule.execute(null));
	}

	@Test
	public void testNeverCall() throws Exception {
		TrueRule rule = Mockito.spy(new TrueRule());
		mRule.add(new FalseRule());
		mRule.add(rule);
		Assert.assertFalse(mRule.execute(null));
		Mockito.verify(rule, Mockito.never()).execute(Mockito.anyObject());
	}
}
