package io.github.jacksoneshbaugh.ParkourGenerator.generator.segment;

import io.github.jacksoneshbaugh.ParkourGenerator.generator.ParkourGenerator;
import io.github.jacksoneshbaugh.ParkourGenerator.generator.ParkourSegment;

/**
 * Manages all the subclasses of {@link ParkourSegment} in this plugin
 *
 * @author Jackson Eshbaugh
 * @version 05/26/2024
 */
public class SegmentManager {

    /**
     * Registers all subclasses of {@link ParkourSegment} in this plugin with the {@link ParkourGenerator}.
     * To be called when the plugin enables.
     */
    public static void registerSegments() {

        // Straight Checkpoints

        ParkourGenerator.getInstance().registerSegment(new CheckpointStraightPositiveX());
        ParkourGenerator.getInstance().registerSegment(new CheckpointStraightNegativeX());
        ParkourGenerator.getInstance().registerSegment(new CheckpointStraightPositiveZ());
        ParkourGenerator.getInstance().registerSegment(new CheckpointStraightNegativeZ());
    }

}
