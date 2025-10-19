package com.example.emamod.block;

import com.example.emamod.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ExtremeMolecularAssemblerBlock extends Block implements EntityBlock {

    public ExtremeMolecularAssemblerBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        // Виправлено: повертається новий екземпляр Block Entity
        return ModBlocks.EXTREME_MOLECULAR_ASSEMBLER_ENTITY.get().create(pos, state);
    }
}