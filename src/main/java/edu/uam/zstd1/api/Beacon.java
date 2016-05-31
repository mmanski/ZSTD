package edu.uam.zstd1.api;

public interface Beacon {

	int getDistance(Beacon beacon);

	/**
	 *
	 * @param beacon
	 * @return true if the calling beacon is interferring with the other beacon due
	 * to it's range
	 */
	boolean isInterferring(Beacon beacon);
}
