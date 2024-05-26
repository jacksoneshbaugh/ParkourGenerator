package io.github.jacksoneshbaugh.ParkourGenerator.generator.segment;

import io.github.jacksoneshbaugh.ParkourGenerator.generator.Direction;
import io.github.jacksoneshbaugh.ParkourGenerator.generator.ParkourSegment;
import org.bukkit.Material;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * A straight "checkpoint" segment in the negative z direction.
 *
 * @author Jackson Eshbaugh
 * @version 05/26/2024
 */
public class CheckpointStraightNegativeZ extends ParkourSegment {

    public CheckpointStraightNegativeZ() {
        super(Direction.NEGATIVE_Z, Direction.NEGATIVE_Z);
    }

    @Override
    public int[] generate(@NotNull int[] start, @NotNull World world) {

        // Platform

        world.getBlockAt(start[0] - 3, start[1], start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 2, start[1], start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 1, start[1], start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0], start[1], start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 1, start[1], start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 2, start[1], start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1], start[2]).setType(Material.COBBLESTONE);

        world.getBlockAt(start[0] - 3, start[1], start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 2, start[1], start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 1, start[1], start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0], start[1], start[2] - 1).setType(Material.IRON_BLOCK);
        world.getBlockAt(start[0] + 1, start[1], start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 2, start[1], start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1], start[2] - 1).setType(Material.COBBLESTONE);

        world.getBlockAt(start[0] - 3, start[1], start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 2, start[1], start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 1, start[1], start[2] - 2).setType(Material.IRON_BLOCK);
        world.getBlockAt(start[0], start[1], start[2] - 2).setType(Material.GOLD_BLOCK);
        world.getBlockAt(start[0] + 1, start[1], start[2] - 2).setType(Material.IRON_BLOCK);
        world.getBlockAt(start[0] + 2, start[1], start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1], start[2] - 2).setType(Material.COBBLESTONE);

        world.getBlockAt(start[0] - 3, start[1], start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 2, start[1], start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 1, start[1], start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0], start[1], start[2] - 3).setType(Material.IRON_BLOCK);
        world.getBlockAt(start[0] + 1, start[1], start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 2, start[1], start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1], start[2] - 3).setType(Material.COBBLESTONE);

        world.getBlockAt(start[0] - 3, start[1], start[2] - 4).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 2, start[1], start[2] - 4).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 1, start[1], start[2] - 4).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0], start[1], start[2] - 4).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 1, start[1], start[2] - 4).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 2, start[1], start[2] - 4).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1], start[2] - 4).setType(Material.COBBLESTONE);

        // Negative-X wall

        world.getBlockAt(start[0] - 3, start[1] + 1, start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 1, start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 1, start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 1, start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 1, start[2] - 4).setType(Material.COBBLESTONE);

        world.getBlockAt(start[0] - 3, start[1] + 2, start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 2, start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 2, start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 2, start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] - 3, start[1] + 2, start[2] - 4).setType(Material.COBBLESTONE);

        // Positive-X wall

        world.getBlockAt(start[0] + 3, start[1] + 1, start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 1, start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 1, start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 1, start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 1, start[2] - 4).setType(Material.COBBLESTONE);

        world.getBlockAt(start[0] + 3, start[1] + 2, start[2]).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 2, start[2] - 1).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 2, start[2] - 2).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 2, start[2] - 3).setType(Material.COBBLESTONE);
        world.getBlockAt(start[0] + 3, start[1] + 2, start[2] - 4).setType(Material.COBBLESTONE);

        return new int[]{
                start[0],
                start[1],
                start[2] - 4
        };
    }
}