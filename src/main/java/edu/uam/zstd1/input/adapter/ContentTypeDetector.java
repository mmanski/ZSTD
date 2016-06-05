package edu.uam.zstd1.input.adapter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

/**
 *
 * @author mmanski
 */
public class ContentTypeDetector {

	private TikaConfig tikaConfig;

	public ContentTypeDetector() {
		try {
			this.tikaConfig = new TikaConfig();
		} catch (TikaException | IOException ex) {
			Logger.getLogger(ContentTypeDetector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public SupportedMediaType getMediaTypeFromFile(File file) {
		Metadata metadata = new Metadata();
		metadata.set(Metadata.RESOURCE_NAME_KEY, file.toString());
		MediaType mediaType = null;
		try {
			mediaType = tikaConfig.getDetector().detect(
					TikaInputStream.get(file.toPath()), metadata);
		} catch (IOException ex) {
			Logger.getLogger(ContentTypeDetector.class.getName()).log(Level.SEVERE, null, ex);
		}
		return SupportedMediaType.of(mediaType);
	}
}
