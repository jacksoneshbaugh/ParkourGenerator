package io.github.jacksoneshbaugh.ParkourGenerator.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Takes multiple {@link ParkourSegment} objects and stores them (in a registry format).
 * Then, randomly generates a parkour course using randomly selected {@link ParkourSegment}s.
 * This class is a singleton.
 *
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
public class ParkourGenerator {

    private ParkourGenerator() { }

    private static ParkourGenerator pg = null;

    /**
     * Gets the instance of the {@link ParkourGenerator}.
     *
     * @return the instance of the {@link ParkourGenerator}
     */
    public static ParkourGenerator getInstance() {
        if(pg == null) pg = new ParkourGenerator();
        return pg;
    }

    private final ArrayList<ParkourSegment> segments = new ArrayList<>();

    /**
     * Registers a {@link ParkourSegment} with the {@link ParkourGenerator}, thus allowing it to be randomly
     * chosen when generating random parkour. Other plugins looking to register instances of {@link ParkourSegment}
     * should do so in their {@code onEnable()} method.
     *
     * @param segment the {@link ParkourSegment} to register
     */
    public void registerSegment(ParkourSegment segment) {
        segments.add(segment);
    }

    /**
     * Generates a parkour course, starting at the position given by {@code start}, with {@code numSegments} {@link ParkourSegment}s from the {@code segments} {@link List}. This
     * is a destructive function and makes permanent changes to the world.
     *
     * @param startPosition an array that gives the start of the parkour course ({@code [x, y, z]})
     * @param startDirection the direction the parkour should start in
     * @param numSegments the number of segments to generate
     * @param segments the {@link List} to pick segments from
     */
    public void generateParkour(int[] startPosition, Direction startDirection, int numSegments, List<ParkourSegment> segments) {

        int[] currentPosition = startPosition;
        Direction currentDirection = startDirection;

        for(int i = 0; i < numSegments; ++i) {

            // Select a random segment.
            // Check that the segment has the same direction as currentDirection.
            // If not, choose again (repeat the above two until this is satisfied)

            ParkourSegment segment;

            do {
                segment = segments.get((int) ((Math.random() * ((segments.size() - 1)))));
            } while (segment.getStartDirection() != currentDirection);

            // Execute generate(), saving the endPosition

            int[] endPosition = segment.generate(currentPosition);

            // Check if the direction changed

            currentDirection = segment.getEndDirection();

            // Using the (possibly changed) direction, calculate the new start point (one in the current direction).

            switch (currentDirection) {
                case NEGATIVE_X:
                    currentPosition[0] = endPosition[0] - 1;
                    currentPosition[1] = endPosition[1];
                    currentPosition[2] = endPosition[2];
                    break;
                case NEGATIVE_Z:
                    currentPosition[0] = endPosition[0];
                    currentPosition[1] = endPosition[1];
                    currentPosition[2] = endPosition[2] - 1;
                    break;
                case POSITIVE_X:
                    currentPosition[0] = endPosition[0] + 1;
                    currentPosition[1] = endPosition[1];
                    currentPosition[2] = endPosition[2];
                    break;
                case POSITIVE_Z:
                    currentPosition[0] = endPosition[0];
                    currentPosition[1] = endPosition[1];
                    currentPosition[2] = endPosition[2] + 1;
                    break;
            }

        }

    }

    /**
     * Generates a parkour course, starting at the position given by {@code start}, with {@code segments} {@link ParkourSegment}s. This
     * is a destructive function and makes permanent changes to the world.
     *
     * @param startPosition an array that gives the start of the parkour course ({@code [x, y, z]})
     * @param startDirection the direction the parkour should start in
     * @param numSegments the number of segments to generate
     */
    public void generateParkour(int[] startPosition, Direction startDirection, int numSegments) {
        this.generateParkour(startPosition, startDirection, numSegments, segments);
    }

    /**
     * Generates a parkour course, starting at the position given by {@code start}, with between 10–50 {@link ParkourSegment}s. This
     * is a destructive function and makes permanent changes to the world.
     *
     * @param startPosition an array that gives the start of the parkour course ({@code [x, y, z]})
     * @param startDirection the direction the parkour should start in
     */
    public void generateParkour(int[] startPosition, Direction startDirection) {
        this.generateParkour(startPosition, startDirection, (int) ((Math.random() * (50 - 10)) + 10), segments);
    }

    /**
     * Generates a parkour course, starting at the position given by {@code start}, with between 10–50 {@link ParkourSegment}s picked from the specifed {@code segments} {@link List}. This
     * is a destructive function and makes permanent changes to the world.
     *
     * @param startPosition an array that gives the start of the parkour course ({@code [x, y, z]})
     * @param startDirection the direction the parkour should start in
     * @param segments the {@link List} to pick segments from
     */
    public void generateParkour(int[] startPosition, Direction startDirection, List<ParkourSegment> segments) {
        this.generateParkour(startPosition, startDirection, (int) ((Math.random() * (50 - 10)) + 10), segments);
    }

}
