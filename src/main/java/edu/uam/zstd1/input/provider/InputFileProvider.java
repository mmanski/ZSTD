package edu.uam.zstd1.input.provider;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by mmanski
 */
public class InputFileProvider {

	public File getInputFile(String fileName) {
		try {
			return new File(getClass().getClassLoader().getResource(fileName).toURI());
		} catch (URISyntaxException e) {
			System.err.println(e);
			return null;
		}
	}
}
