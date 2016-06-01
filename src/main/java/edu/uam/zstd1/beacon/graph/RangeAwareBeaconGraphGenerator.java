package edu.uam.zstd1.beacon.graph;

import edu.uam.zstd1.impl.beacon.TelecommunicationBeaconEdge;
import edu.uam.zstd1.api.Beacon;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;
import org.jgrapht.generate.CompleteGraphGenerator;

/**
 * Generates a graph with edges connecting the interferring beacons
 *
 * @author mmanski
 */
public class RangeAwareBeaconGraphGenerator extends CompleteGraphGenerator<Beacon, TelecommunicationBeaconEdge> {

	public RangeAwareBeaconGraphGenerator(int size) {
		super(size);
	}

	@Override
	public void generateGraph(Graph<Beacon, TelecommunicationBeaconEdge> target,
			VertexFactory<Beacon> vertexFactory, Map<String, Beacon> resultMap) {

		super.generateGraph(target, vertexFactory, resultMap);
		target.removeAllEdges(getEdgesBetweenNotInterferringBeacons(target.edgeSet()));
	}

	private Set<TelecommunicationBeaconEdge> getEdgesBetweenNotInterferringBeacons(Set<TelecommunicationBeaconEdge> edges) {
		return edges.stream()
				.filter(edge -> !edge.getSource().isInterferring(edge.getTarget()))
				.collect(Collectors.toSet());
	}
}
