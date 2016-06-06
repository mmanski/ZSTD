package edu.uam.zstd1.impl.beacon;

import java.awt.geom.Point2D;

import edu.uam.zstd1.api.Beacon;

public class TelecommunicationBeacon implements Beacon {
	
	private double x;
	private double y;
	private double r;

        public TelecommunicationBeacon(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
        
	@Override
	public double getDistance(Beacon beacon) {
		return getLocation().distance(beacon.getLocation());
	}

	@Override
	public boolean isInterferring(Beacon beacon) {
		if (getDistance(beacon) < getRange()) {
			return true;
		}
		
		return false;
	}
	
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public double getRange() {
		return this.r;
	}
	
	public Point2D getLocation()	{
		return new Point2D.Double(getX(), getY());
	}
}
