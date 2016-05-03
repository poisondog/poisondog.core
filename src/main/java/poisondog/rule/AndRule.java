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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class AndRule<T> implements Rule<T>, Iterable<Rule<T>> {
	private List<Rule<T>> mCollection;

	public AndRule() {
		mCollection = new LinkedList<Rule<T>>();
	}

	public void add(Rule<T> rule) {
		mCollection.add(rule);
	}

	@Override
	public Boolean execute(T target) throws Exception {
		for (Rule<T> rule : mCollection) {
			if(!rule.execute(target))
				return false;
		}
		return true;
	}

	@Override
	public Iterator<Rule<T>> iterator() {
		return mCollection.iterator();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AndRule))
			return false;
		AndRule another = (AndRule)obj;
		return mCollection.containsAll(another.mCollection) && another.mCollection.containsAll(mCollection);
	}
}
