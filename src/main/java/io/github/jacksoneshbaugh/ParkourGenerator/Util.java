package io.github.jacksoneshbaugh.ParkourGenerator;

import io.github.jacksoneshbaugh.ParkourGenerator.generator.Direction;
import org.bukkit.entity.Player;

/**
 * Contains utility methods used by ParkourGenerator
 *
 * @author JacksonEshbaugh
 * @version 05/25/2024
 */
public class Util {

    /**
     * Converts the yaw of a player's position to a {@link Direction}.
     *
     * @param player the player whose yaw to check
     * @return The {@link Direction} the {@code player} is facing
     */
    public static Direction getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 180) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 45) {
            return Direction.NEGATIVE_Z;
        } else if (45 <= rotation && rotation < 135) {
            return Direction.POSITIVE_X;
        } else if (135 <= rotation && rotation < 225) {
            return Direction.POSITIVE_Z;
        } else if (225 <= rotation && rotation < 315) {
            return Direction.NEGATIVE_X;
        } else if (315 <= rotation && rotation < 360) {
            return Direction.NEGATIVE_Z;
        } else {
            return null;
        }
    }
}
