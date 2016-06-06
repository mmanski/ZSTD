package edu.uam.zstd1.api;

import java.awt.geom.Point2D;

public interface Beacon {
	
	double getDistance(Beacon beacon);

	/**
	 *
	 * @param beacon
	 * @return true if the calling beacon is interferring with the other beacon due
	 * to it's range
	 */
	boolean isInterferring(Beacon beacon);
	
	Point2D getLocation();
}
