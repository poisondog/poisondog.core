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
package poisondog.rule;

/**
 * @author <a href="mailto:poisondog@gmail.com">Adam Huang</a>
 */
public class InverterRule<T> implements Rule<T> {
	private Rule<T> mRule;

	public InverterRule(Rule<T> rule) {
		mRule = rule;
	}

	@Override
	public Boolean execute(T target) throws Exception {
		return !mRule.execute(target);
	}
}
