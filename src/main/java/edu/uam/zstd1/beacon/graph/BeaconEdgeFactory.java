package edu.uam.zstd1.beacon.graph;

import edu.uam.zstd1.impl.beacon.TelecommunicationBeaconEdge;
import edu.uam.zstd1.api.Beacon;
import org.jgrapht.EdgeFactory;

public class BeaconEdgeFactory implements EdgeFactory<Beacon, TelecommunicationBeaconEdge> {

	@Override
	public TelecommunicationBeaconEdge createEdge(Beacon beacon1, Beacon beacon2) {
		return new TelecommunicationBeaconEdge(beacon1.getDistance(beacon2), beacon1, beacon2);
	}

}
