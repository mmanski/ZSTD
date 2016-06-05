package edu.uam.zstd1.input.adapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.impl.beacon.TelecommunicationBeacon;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.*;

/**
 * Created by mmanski
 */
class JSONToBeaconListAdapter implements BeaconAdapter {

	private final Gson gson;

	private final Type listType;

	public JSONToBeaconListAdapter() {
		gson = new Gson();
		listType = new TypeToken<List<TelecommunicationBeacon>>() {
		}.getType();
	}

	@Override
	public List<Beacon> getBeaconsFromInput(Object input) {
		String in = null;
		if (input instanceof File) {
			try {
				in = FileUtils.readFileToString((File) input, StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			in = (String) input;
		}
		return gson.fromJson(in, listType);
	}
}
