package com.example.emamod.recipe;

import appeng.api.crafting.IPatternDetails;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

public class ExtremePatternDetails implements IPatternDetails {
    private final int gridSize;
    private final NonNullList<ItemStack> ingredients;
    private final ItemStack result;
    private final boolean allowSubstitutions;

    public ExtremePatternDetails(int gridSize, NonNullList<ItemStack> ingredients, ItemStack result, boolean allowSubstitutions) {
        this.gridSize = gridSize;
        this.ingredients = ingredients;
        this.result = result;
        this.allowSubstitutions = allowSubstitutions;
    }

    // IPatternDetails methods will be implemented here
}
