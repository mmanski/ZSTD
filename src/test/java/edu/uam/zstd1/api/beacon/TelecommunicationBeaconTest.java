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

		double expectedDistance = 5;
		//int actualDistance = 5; //TODO smth like beacon1.getDistance(beacon2);
		
		beacon1.setX(2);
		beacon1.setY(5);
		beacon2.setX(5);
		beacon2.setY(9);
		beacon1.setRange(5);
		beacon2.setRange(10);
		
		double actualDistance = beacon1.getDistance(beacon2);

		Assert.assertEquals(
				"Distances should be equal!", expectedDistance, actualDistance);
	}

	@Test
	public void test_if_interrference_is_detected_properly() {

		Beacon beacon = new TelecommunicationBeacon();
		Beacon interferringBeacon = new TelecommunicationBeacon();
		Beacon notInterferringBeacon = new TelecommunicationBeacon();

		//to be deleted
//		Assert.assertTrue(true);

		beacon.setX(2);
		beacon.setY(5);
		interferringBeacon.setX(5);
		interferringBeacon.setY(9);
		notInterferringBeacon.setX(7);
		notInterferringBeacon.setY(9);
		interferringBeacon.setRange(6);
		notInterferringBeacon.setRange(15);

		Assert.assertTrue("These beacons are interfering with theirselves!",
			 beacon.isInterferring(interferringBeacon));

		 Assert.assertTrue("These beacons are not interfering with theirselves!",
			 beacon.isInterferring(notInterferringBeacon));
	}
}
