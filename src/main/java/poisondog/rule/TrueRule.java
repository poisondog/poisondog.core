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
public class TrueRule<T> implements Rule<T>, Cloneable {

	@Override
	public Boolean execute(T target) {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TrueRule))
			return false;
		return true;
	}

	@Override
	public TrueRule<T> clone() {
		return new TrueRule<T>();
	}
}
