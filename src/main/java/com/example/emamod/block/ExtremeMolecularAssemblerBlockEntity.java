package com.example.emamod.block;

import com.example.emamod.grid.MEMonitorableBlockEntity;
import com.example.emamod.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ExtremeMolecularAssemblerBlockEntity extends MEMonitorableBlockEntity {

    public ExtremeMolecularAssemblerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.EXTREME_MOLECULAR_ASSEMBLER_ENTITY.get(), pos, state);
    }
}
