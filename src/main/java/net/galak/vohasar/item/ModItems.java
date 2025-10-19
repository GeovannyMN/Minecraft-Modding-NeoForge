package net.galak.vohasar.item;

import net.galak.vohasar.Vohasar;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Vohasar.MOD_ID);

    public static final DeferredItem<Item> VOHASARITE = ITEMS.register("vohasarite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_VOHASARITE = ITEMS.register("raw_vohasarite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
