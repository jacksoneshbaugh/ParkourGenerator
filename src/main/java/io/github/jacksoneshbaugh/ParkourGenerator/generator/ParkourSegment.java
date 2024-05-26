package io.github.jacksoneshbaugh.ParkourGenerator.generator;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * A segment of parkour used in the {@link ParkourGenerator} to generate a full course.
 *
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
public abstract class ParkourSegment {

    private final Direction startDirection, endDirection;

    /**
     * Instantiates a ParkourSegment with the given start and end directions. This is called in any segment's constructor
     * using the {@code super()} keyword to set these parameters.
     *
     * @param startDirection the {@link Direction} that this segment starts facing.
     * @param endDirection the {@link Direction} that this segment ends facing.
     */
    public ParkourSegment(Direction startDirection, Direction endDirection) {
        this.startDirection = startDirection;
        this.endDirection = endDirection;
    }

    /**
     * Given the middle block of the first "row" of blocks ({@code start}), generates this segment of the parkour.
     * This includes the distance of the final jump (leave an air gap if you intend to end with
     * a jump). Finally, returns the final middle block (just like the {@code start} parameter, in the form of an array).
     * Note: segments should be made so that they start in the center, and in the case where they don't end
     * in the center, the returned int array should be adjusted so that the next segment starts in a "jumpable" place.
     *
     * @param start the middle block of the first row of blocks ({@code [x, y, z]})
     * @param world the world to generate the segment in
     * @return the final middle block, again {@code [x, y, z]} (if this segment ends with a jump, this would be the final block of air of the jump)
     */
    public abstract int[] generate(@NotNull int[] start, @NotNull World world);

    /**
     * Gets the direction that this segment begins facing.
     *
     * @return the direction that this segment begins facing
     */
    public Direction getStartDirection() {
        return startDirection;
    }

    /**
     * Gets the direction that this segment ends facing.
     *
     * @return the direction that this segment ends facing
     */
    public Direction getEndDirection() {
        return endDirection;
    }

}
