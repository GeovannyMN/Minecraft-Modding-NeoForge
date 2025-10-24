package net.galak.vohasar.item;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.item.custom.ChiselItem;
import net.galak.vohasar.item.custom.ChocolatedMilk;
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

    public static final DeferredItem<ChiselItem> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(64)));

    //COMIDAS
    public static final DeferredItem<Item> GUARANA = ITEMS.register("guarana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GUARANA)));

    public static final DeferredItem<ChocolatedMilk> CHOCOLATED_MILK = ITEMS.register("chocolated_milk",
            () -> new ChocolatedMilk(new Item.Properties().food(ModFoodProperties.CHOCOLATED_MILK)));

    public static final DeferredItem<Item> VOHASAR_CHARCOAL = ITEMS.register("vohasar_charcoal",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VOHASAR_ASHES = ITEMS.register("vohasar_ashes",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
