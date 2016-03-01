// 2013-11-09
/*******************************
 * NoMissionTest
 *******************************/
package poisondog.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class NoMissionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() throws Exception {
		NoMission mission = new NoMission();
		Assert.assertNull(mission.execute(null));
		Assert.assertEquals(1, mission.execute(1));
		Assert.assertEquals(-1, mission.execute(-1));
		Assert.assertEquals("7", mission.execute("7"));
	}
}
