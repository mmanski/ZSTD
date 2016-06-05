package edu.uam.zstd1.graph.generator;

import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.api.BeaconEdge;
import edu.uam.zstd1.beacon.graph.BeaconEdgeFactory;
import edu.uam.zstd1.beacon.graph.BeaconVertexFactory;
import edu.uam.zstd1.beacon.graph.RangeAwareBeaconGraphGenerator;

import java.util.List;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author mmanski
 */
public class RangeAwareBeaconGraphProvider {

	public Graph<Beacon, BeaconEdge> generateBeaconGraph(List<Beacon> beacons) {
		VertexFactory<Beacon> beaconVertexFactory = new BeaconVertexFactory<>(beacons);
		EdgeFactory<Beacon, BeaconEdge> beaconEdgeFactory = new BeaconEdgeFactory();
		Graph<Beacon, BeaconEdge> target = new SimpleWeightedGraph<>(beaconEdgeFactory);
		RangeAwareBeaconGraphGenerator rangeAwareBeaconGraphGenerator = new RangeAwareBeaconGraphGenerator(beacons.size());
		rangeAwareBeaconGraphGenerator.generateGraph(target, beaconVertexFactory, null);
		return target;
	}
}
