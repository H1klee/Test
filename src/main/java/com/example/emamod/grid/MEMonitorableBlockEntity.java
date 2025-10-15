package com.example.emamod.grid;

import appeng.api.networking.GridHelper;
import appeng.api.networking.IGridNode;
import appeng.api.networking.IManagedGridNode;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class MEMonitorableBlockEntity extends BlockEntity {
    private IManagedGridNode gridNode;

    public MEMonitorableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.gridNode = GridHelper.INSTANCE.createManagedNode(this, (node, machine) -> {});
    }

    public IGridNode getGridNode() {
        return gridNode.getNode();
    }
}
