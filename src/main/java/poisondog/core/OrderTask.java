/*
 * Copyright (C) 2018 Adam Huang <poisondog@gmail.com>
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

import java.util.ArrayList;

/**
 * @author Adam Huang
 * @since 2018-09-13
 */
public class OrderTask implements Runnable, Mission<Object> {
	private ArrayList<Runnable> mContent;

	/**
	 * Constructor
	 */
	public OrderTask() {
		mContent = new ArrayList<Runnable>();
	}

	public void add(Runnable task) {
		mContent.add(task);
	}

	@Override
	public void run() {
		for (Runnable task : mContent) {
			task.run();
		}
	}

	@Override
	public Object execute(Object none) {
		run();
		return none;
	}
}
