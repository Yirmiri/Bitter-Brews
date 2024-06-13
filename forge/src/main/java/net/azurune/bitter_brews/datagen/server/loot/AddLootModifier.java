package net.azurune.bitter_brews.datagen.server.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddLootModifier extends LootModifier {
    public static final Supplier<Codec<AddLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(app -> codecStart(app).and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(modifier -> modifier.item)).and(Codec.INT.fieldOf("min").forGetter(modifier -> modifier.min)).and(Codec.INT.fieldOf("max").forGetter(modifier -> modifier.max)).apply(app, AddLootModifier::new)));
    private final Item item;
    private final int min;
    private final int max;

    public AddLootModifier(LootItemCondition[] conditionsIn, Item item) {
        this(conditionsIn, item, 1, 1);
    }

    public AddLootModifier(LootItemCondition[] conditionsIn, Item item, int max) {
        this(conditionsIn, item, 1, max);
    }

    public AddLootModifier(LootItemCondition[] conditionsIn, Item item, int min, int max) {
        super(conditionsIn);
        this.item = item;
        this.min = min;
        this.max = max;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for(LootItemCondition condition : conditions) {
            if(!condition.test(context)) return generatedLoot;
        }

        RandomSource random = context.getRandom();
        generatedLoot.add(new ItemStack(item, random.nextInt(min, max + 1)));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
