package edu.uam.zstd1.impl.beacon;

import java.awt.geom.Point2D;

import edu.uam.zstd1.api.Beacon;

public class TelecommunicationBeacon implements Beacon {
	
	double x;
	double y;
	double r;

	@Override
	public double getDistance(Beacon beacon) {
		return getLocation().distance(beacon.getLocation());
	}

	@Override
	public boolean isInterferring(Beacon beacon) {
		if (getDistance(beacon) < beacon.getRange()) {
			return true;
		}
		
		return false;
	}
	
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setRange(double r) {
		this.r = r;
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
