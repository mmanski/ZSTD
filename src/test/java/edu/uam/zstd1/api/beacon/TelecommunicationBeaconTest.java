package edu.uam.zstd1.api.beacon;

import edu.uam.zstd1.impl.beacon.TelecommunicationBeacon;
import edu.uam.zstd1.api.Beacon;

import junit.framework.Assert;

import org.junit.Test;

public class TelecommunicationBeaconTest {

	@Test
	public void test_if_returned_distance_is_proper() {

		Beacon beacon1 = new TelecommunicationBeacon(2, 5, 5);
		Beacon beacon2 = new TelecommunicationBeacon(5, 9, 10);

		double expectedDistance = 5;
		
		double actualDistance = beacon1.getDistance(beacon2);

		Assert.assertEquals(
				"Distances should be equal!", expectedDistance, actualDistance);
	}

	@Test
	public void test_if_interrference_is_detected_properly() {

		Beacon beacon = new TelecommunicationBeacon(2, 5, 6);
		Beacon interferringBeacon = new TelecommunicationBeacon(5, 9, 5);
		Beacon notInterferringBeacon = new TelecommunicationBeacon(7, 9, 15);

		Assert.assertTrue("These beacons are interfering with theirselves!",
			 beacon.isInterferring(interferringBeacon));

		 Assert.assertTrue("These beacons are not interfering with theirselves!",
			 beacon.isInterferring(notInterferringBeacon));
	}
}
