package io.github.jacksoneshbaugh.ParkourGenerator.generator;

/**
 * Defines the contract required for an object to be used as a randomly selected object in a {@link ParkourGenerator}.
 *
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
public interface ParkourSegment {

    /**
     * Given the middle block of the first "row" of blocks ({@code start}), generates this segment of the parkour.
     * This includes the distance of the final jump (leave an air gap if you intend to end with
     * a jump). Finally, returns the final middle block (just like the {@code start} parameter, in the form of an array).
     * Note: segments should be made so that they start in the center, and in the case where they don't end
     * in the center, the returned int array should be adjusted so that the next segment starts in a "jumpable" place.
     *
     * @param start the middle block of the first row of blocks ({@code [x, y, z]})
     * @return the final middle block (if this segment ends with a jump, this would be the final block of air of the jump.
     */
    int[] generate(int[] start);

}
