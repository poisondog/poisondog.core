/*
 * Copyright (C) 2014 Adam Huang
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

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:poisondog@gmail.com">Adam Huang</a>
 */
public class OrderMission<T> implements Mission<T> {
	private List<Mission> mMissions;

	public OrderMission() {
		mMissions = new LinkedList<Mission>();
	}

	public void add(Mission mission) {
		mMissions.add(mission);
	}

	@Override
	public Object execute(T input) throws Exception {
		Object result = input;
		for (Mission mission : mMissions) {
			result = mission.execute(result);
		}
		return result;
	}
}
