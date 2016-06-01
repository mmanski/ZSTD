/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uam.zstd1.api;

/**
 *
 * @author rasgrass
 */
public interface BeaconEdge {
	
	double getEdgeWeight();
	
	Beacon getSource();
	
	Beacon getTarget();

}
