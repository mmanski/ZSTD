package edu.uam.zstd1;

import dk.aaue.sna.ext.graphml.GraphMLImporter;
import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.api.BeaconEdge;
import edu.uam.zstd1.graph.generator.BeaconGraphExporter;
import edu.uam.zstd1.graph.generator.RangeAwareBeaconGraphProvider;
import edu.uam.zstd1.input.exception.InvalidInputException;
import edu.uam.zstd1.input.exception.UnsupportedInputFormatException;
import edu.uam.zstd1.input.provider.InputFileProvider;
import edu.uam.zstd1.input.provider.UserInputBeaconProvider;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.ClassBasedVertexFactory;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Main {

	public static void main(String[] args) {

		if (args != null && args.length > 0 && args[0] != null) {
			String graphFile = args[0];
			SimpleGraph<Object, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
			File file = new File(graphFile);
			GraphMLImporter<Object, DefaultEdge> importer = GraphMLImporter.createFromFile(file);
			importer.generateGraph(g, new ClassBasedVertexFactory(Object.class), new HashMap<String,Object>());
			System.out.println("Liczba częstotliwości: " + (g.edgeSet().size()+1) );
		} else {

			try {
				File inputJsonFile = new InputFileProvider().getInputFile("./beacons.json");
				List<Beacon> beacons = UserInputBeaconProvider.getBeaconsFromInput(inputJsonFile);
				RangeAwareBeaconGraphProvider rangeAwareBeaconGraphProvider = new RangeAwareBeaconGraphProvider();
				Graph<Beacon, BeaconEdge> target = rangeAwareBeaconGraphProvider.generateBeaconGraph(beacons);
				BeaconGraphExporter beaconGraphExporter = new BeaconGraphExporter();
				beaconGraphExporter.exportGraph(target, "Graph.graphml");
			} catch (InvalidInputException | UnsupportedInputFormatException ex) {
				System.err.println(ex);
			}
		}

	}

}
