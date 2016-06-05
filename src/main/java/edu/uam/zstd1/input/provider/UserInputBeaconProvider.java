package edu.uam.zstd1.input.provider;

import edu.uam.zstd1.input.exception.UnsupportedInputFormatException;
import edu.uam.zstd1.input.exception.InvalidInputException;
import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.input.adapter.BeaconAdapter;
import edu.uam.zstd1.input.adapter.BeaconAdapterFactory;

import java.util.List;

/**
 * Created by mmanski
 */
public class UserInputBeaconProvider {

	public static List<Beacon> getBeaconsFromInput(Object inout) throws InvalidInputException,
			UnsupportedInputFormatException {
		BeaconAdapter beaconAdapter = BeaconAdapterFactory.getAdapter(inout);
		return beaconAdapter.getBeaconsFromInput(inout);
	}
}
