package edu.uam.zstd1.impl.beacon;

import java.awt.geom.Point2D;

import edu.uam.zstd1.api.Beacon;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TelecommunicationBeacon implements Beacon {

	private final double x;
	private final double y;
	private final double r;

	@Override
	public double getDistance(Beacon beacon) {
		return getLocation().distance(beacon.getLocation());
	}

	@Override
	public boolean isInterferring(Beacon beacon) {
		double difference = Math.sqrt(Math.pow(this.x - beacon.getLocation().getX(), 2)
				+ Math.pow(this.y - beacon.getLocation().getY(), 2));

		return Math.abs(this.r - beacon.getRange()) <= difference
				&& difference <= Math.abs(this.r + beacon.getRange());
	}

	@Override
	public double getRange() {
		return this.r;
	}

	@Override
	public Point2D getLocation() {
		return new Point2D.Double(this.x, this.y);
	}
}
