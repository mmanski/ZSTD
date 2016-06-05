package edu.uam.zstd1.input.adapter;

import edu.uam.zstd1.api.Beacon;

import java.util.List;

/**
 *
 * @author mmanski
 */
public interface BeaconAdapter {

	List<Beacon> getBeaconsFromInput(Object input);

}
