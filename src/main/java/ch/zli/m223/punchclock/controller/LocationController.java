package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.service.LocationService;

import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Klasse dient dazu, dass man eine Location nicht über ein SQL Skript adden muss
 * dazu, dass es nicht immer die gleichen Locations sind
 */
@Path("/loca")
public class LocationController {
    @Inject
    LocationService locationService;
    
}
