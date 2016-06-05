package edu.uam.zstd1.input.adapter;

import org.apache.tika.mime.MediaType;

/**
 *
 * @author mmanski
 */
public enum SupportedMediaType {

	JSON("application/json"),
	UNKNOWN("Unknown");

	private final String mediaTypeName;

	private SupportedMediaType(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
	}

	public String getMediaTypeName() {
		return mediaTypeName;
	}

	public static SupportedMediaType of(MediaType mediaType) {
		for (SupportedMediaType supportedMediaType : SupportedMediaType.values()) {
			if (supportedMediaType.getMediaTypeName().equals(mediaType.toString())) {
				return supportedMediaType;
			}
		}
		return UNKNOWN;
	}

}
