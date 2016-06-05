package edu.uam.zstd1;

import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.api.BeaconEdge;
import edu.uam.zstd1.graph.generator.BeaconGraphExporter;
import edu.uam.zstd1.graph.generator.RangeAwareBeaconGraphProvider;
import edu.uam.zstd1.input.exception.InvalidInputException;
import edu.uam.zstd1.input.exception.UnsupportedInputFormatException;
import edu.uam.zstd1.input.provider.InputFileProvider;
import edu.uam.zstd1.input.provider.UserInputBeaconProvider;

import java.io.File;
import java.util.List;

import org.jgrapht.Graph;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			File inputJsonFile = new InputFileProvider().getInputFile("beacons.json");
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
