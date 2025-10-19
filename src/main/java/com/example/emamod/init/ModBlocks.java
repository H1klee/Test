package com.example.emamod.init;

import com.example.emamod.EMAMod;
import com.example.emamod.block.ExtremeMolecularAssemblerBlock;
import com.example.emamod.block.ExtremeMolecularAssemblerBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EMAMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EMAMod.MODID);

    public static final RegistryObject<Block> EXTREME_MOLECULAR_ASSEMBLER = BLOCKS.register("extreme_molecular_assembler",
            () -> new ExtremeMolecularAssemblerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0f)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<BlockEntityType<ExtremeMolecularAssemblerBlockEntity>> EXTREME_MOLECULAR_ASSEMBLER_ENTITY =
            BLOCK_ENTITIES.register("extreme_molecular_assembler",
                    () -> BlockEntityType.Builder.of(ExtremeMolecularAssemblerBlockEntity::new, EXTREME_MOLECULAR_ASSEMBLER.get()).build(null));
}