package edu.uam.zstd1.input.adapter;

import edu.uam.zstd1.input.exception.UnsupportedInputFormatException;
import edu.uam.zstd1.input.exception.InvalidInputException;
import java.io.File;

/**
 * Created by mmanski
 */
public class BeaconAdapterFactory {

	public static BeaconAdapter getAdapter(Object userInput) throws UnsupportedInputFormatException, InvalidInputException {
		SupportedMediaType mediaType = null;
		if (userInput instanceof File) {
			File file = (File) userInput;
			mediaType = new ContentTypeDetector().getMediaTypeFromFile(file);
		} else {
			throw new UnsupportedInputFormatException("Input should be a file");
		}
		switch (mediaType) {
			case JSON:
				return new JSONToBeaconListAdapter();
			case UNKNOWN:
			default:
				throw new UnsupportedInputFormatException("The format " + mediaType.getMediaTypeName() + " is not supported");
		}
	}
}
