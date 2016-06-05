package edu.uam.zstd1.graph.generator;

import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.api.BeaconEdge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;

import org.jgrapht.Graph;
import org.jgrapht.ext.GraphMLExporter;
import org.xml.sax.SAXException;

/**
 *
 * @author mmanski
 */
public class BeaconGraphExporter {

	public ExportStatus exportGraph(Graph<Beacon, BeaconEdge> graph, String filename) {
		GraphMLExporter<Beacon, BeaconEdge> graphMLExporter = new GraphMLExporter<>();

		try {
			graphMLExporter.export(new FileWriter(filename), graph);
		} catch (IOException | SAXException | TransformerConfigurationException ex) {
			Logger.getLogger(BeaconGraphExporter.class.getName()).log(Level.SEVERE, null, ex);
			return ExportStatus.FAILURE;
		}
		return ExportStatus.SUCCES;
	}

	public static enum ExportStatus {

		SUCCES,
		FAILURE;
	}
}
