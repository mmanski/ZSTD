package edu.uam.zstd1.beacon.graph;

import java.util.List;

import org.jgrapht.VertexFactory;

public class BeaconVertexFactory<Beacon> implements VertexFactory<Beacon> {

	private final List<Beacon> vertices;

	private int counter = 0;

	public BeaconVertexFactory(List<Beacon> vertices) {
		this.vertices = vertices;
	}

	@Override
	public Beacon createVertex() {
		Beacon result = vertices.get(counter);
		counter++;
		return result;
	}

}
