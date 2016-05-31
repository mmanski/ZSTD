package edu.uam.zstd1.api.beacon;

import edu.uam.zstd1.impl.beacon.TelecommunicationBeacon;
import edu.uam.zstd1.api.Beacon;

import junit.framework.Assert;

import org.junit.Test;

public class TelecommunicationBeaconTest {

	@Test
	public void test_if_returned_distance_is_proper() {

		Beacon beacon1 = new TelecommunicationBeacon();

		Beacon beacon2 = new TelecommunicationBeacon();

		int expectedDistance = 5;
		int actualDistance = 5; //TODO smth like beacon1.getDistance(beacon2);

		Assert.assertEquals(
				"Distances should be equal!", expectedDistance, actualDistance);
	}

	@Test
	public void test_if_interrference_is_detected_properly() {

		Beacon beacon = new TelecommunicationBeacon();
		Beacon interferringBeacon = new TelecommunicationBeacon();
		Beacon notInterferringBeacon = new TelecommunicationBeacon();

		//to be deleted
		Assert.assertTrue(true);


		/*Assert.assertTrue("These beacons are interfering with theirselves!",
			 beacon.isInterferring(interferringBeacon));

		 Assert.assertTrue("These beacons are not interfering with theirselves!",
			 beacon.isInterferring(notInterferringBeacon));*/
	}

}
