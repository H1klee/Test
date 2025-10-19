package com.example.emamod.recipe;

import appeng.api.crafting.IPatternDetails;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.GenericStack;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Простий PatternDetails: усі інгредієнти — item-входи 1:1, вихід — один item-стек.
 * Потрібно лише для старту компіляції; за потреби розширюй логіку.
 */
public class ExtremePatternDetails implements IPatternDetails {

    private final AEItemKey definition;        // Що за "патерн" закодовано (для AE2 це ідентифікує рецепт)
    private final IInput[] inputs;             // Входи
    private final GenericStack[] outputs;      // Виходи

    /**
     * Якщо в тебе є свій предмет-патерн, краще передавати його сюди як AEItemKey.of(patternStack).
     * Тут для простоти використаємо результат як "definition".
     */
    public ExtremePatternDetails(int gridSize,
                                 NonNullList<ItemStack> ingredients,
                                 ItemStack result,
                                 boolean allowSubstitutions) {

        // definition: що AE2 буде вважати цим патерном (мінімально — ключ предмета результату)
        this.definition = AEItemKey.of(result);

        // inputs: перетворюємо кожен НЕпорожній ItemStack у IInput з одним можливим варіантом
        List<IInput> builtInputs = new ArrayList<>();
        for (ItemStack is : ingredients) {
            if (!is.isEmpty()) {
                var key = AEItemKey.of(is);
                builtInputs.add(new SimpleInput(new GenericStack[]{ new GenericStack(key, 1L) }, 1L));
            }
        }
        this.inputs = builtInputs.toArray(new IInput[0]);

        // outputs: один вихід — результат
        if (!result.isEmpty()) {
            this.outputs = new GenericStack[] { new GenericStack(AEItemKey.of(result), result.getCount()) };
        } else {
            this.outputs = new GenericStack[0];
        }
    }

    @Override
    public AEItemKey getDefinition() {
        return this.definition;
    }

    @Override
    public IInput[] getInputs() {
        return this.inputs;
    }

    @Override
    public GenericStack[] getOutputs() {
        return this.outputs;
    }

    /**
     * Проста реалізація одного входу.
     */
    private static class SimpleInput implements IInput {
        private final GenericStack[] possibleInputs;
        private final long multiplier;

        private SimpleInput(GenericStack[] possibleInputs, long multiplier) {
            this.possibleInputs = possibleInputs;
            this.multiplier = multiplier;
        }

        @Override
        public GenericStack[] getPossibleInputs() {
            return this.possibleInputs;
        }

        @Override
        public long getMultiplier() {
            return this.multiplier;
        }

        @Override
        public boolean isValid(AEKey input, Level level) {
            for (var gs : possibleInputs) {
                if (gs.what().equals(input)) { // ← було gs.getWhat()
                    return true;
                }
            }
            return false;
        }

        @Nullable
        @Override
        public AEKey getRemainingKey(AEKey template) {
            // Для "processing" патернів зазвичай нічого не повертаємо
            return null;
        }
    }
}
