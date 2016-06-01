package edu.uam.zstd1.impl.beacon;

import edu.uam.zstd1.api.Beacon;
import edu.uam.zstd1.api.BeaconEdge;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TelecommunicationBeaconEdge implements BeaconEdge {

	private static final long serialVersionUID = 1L;

	private final double edgeWeight;

	private final Beacon source;

	private final Beacon target;

}
