package net.mcreator.yande.init;

import net.mcreator.yande.item.SongrecordItem;
import net.mcreator.yande.item.TaijispawnerItem;
import net.mcreator.yande.item.YandeclothItem;
import net.mcreator.yande.item.YandeksflsItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/* loaded from: YandeModItems.class */
public class YandeModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "yande");
    public static final RegistryObject<Item> YANDE_SPAWN_EGG = REGISTRY.register("yande_spawn_egg", () -> {
        return new ForgeSpawnEggItem(YandeModEntities.YANDE, -6750055, -10092442, new Item.Properties());
    });
    public static final RegistryObject<Item> YANDEGODIE_SPAWN_EGG = REGISTRY.register("yandegodie_spawn_egg", () -> {
        return new ForgeSpawnEggItem(YandeModEntities.YANDEGODIE, -1, -1, new Item.Properties());
    });
    public static final RegistryObject<Item> TAIJISPAWNER = REGISTRY.register("taijispawner", () -> {
        return new TaijispawnerItem();
    });
    public static final RegistryObject<Item> YANDEKSFLS = REGISTRY.register("yandeksfls", () -> {
        return new YandeksflsItem();
    });
    public static final RegistryObject<Item> SONGRECORD = REGISTRY.register("songrecord", () -> {
        return new SongrecordItem();
    });
    public static final RegistryObject<YandeclothItem> YANDECLOTH_HELMET = REGISTRY.register("yandecloth_helmet", () -> {
        return new YandeclothItem(ArmorItem.Type.HELMET, new Item.Properties());
    });
    public static final RegistryObject<Item> YANDELOSECAR_SPAWN_EGG = REGISTRY.register("yandelosecar_spawn_egg", () -> {
        return new ForgeSpawnEggItem(YandeModEntities.YANDELOSECAR, -1, -1, new Item.Properties());
    });
    public static final RegistryObject<Item> YANDEKEEP_SPAWN_EGG = REGISTRY.register("yandekeep_spawn_egg", () -> {
        return new ForgeSpawnEggItem(YandeModEntities.YANDEKEEP, -1, -1, new Item.Properties());
    });
    public static final RegistryObject<Item> YANDEIF_SPAWN_EGG = REGISTRY.register("yandeif_spawn_egg", () -> {
        return new ForgeSpawnEggItem(YandeModEntities.YANDEIF, -1, -1, new Item.Properties());
    });
    public static final RegistryObject<Item> SHINDE_SPAWN_EGG = REGISTRY.register("shinde_spawn_egg", () -> {
        return new ForgeSpawnEggItem(YandeModEntities.SHINDE, -1, -1, new Item.Properties());
    });
}