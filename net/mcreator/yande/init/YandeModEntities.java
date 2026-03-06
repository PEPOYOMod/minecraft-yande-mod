package net.mcreator.yande.init;

import net.mcreator.yande.entity.ShindeEntity;
import net.mcreator.yande.entity.TaijiEntity;
import net.mcreator.yande.entity.YandeEntity;
import net.mcreator.yande.entity.YandegodieEntity;
import net.mcreator.yande.entity.YandeifEntity;
import net.mcreator.yande.entity.YandekeepEntity;
import net.mcreator.yande.entity.YandelosecarEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/* loaded from: YandeModEntities.class */
public class YandeModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "yande");
    public static final RegistryObject<EntityType<YandeEntity>> YANDE = register("yande", EntityType.Builder.m_20704_(YandeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandeEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<YandegodieEntity>> YANDEGODIE = register("yandegodie", EntityType.Builder.m_20704_(YandegodieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandegodieEntity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<TaijiEntity>> TAIJI = register("taiji", EntityType.Builder.m_20704_(TaijiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TaijiEntity::new).m_20699_(0.6f, 0.2f));
    public static final RegistryObject<EntityType<YandelosecarEntity>> YANDELOSECAR = register("yandelosecar", EntityType.Builder.m_20704_(YandelosecarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandelosecarEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<YandekeepEntity>> YANDEKEEP = register("yandekeep", EntityType.Builder.m_20704_(YandekeepEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandekeepEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<YandeifEntity>> YANDEIF = register("yandeif", EntityType.Builder.m_20704_(YandeifEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandeifEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<ShindeEntity>> SHINDE = register("shinde", EntityType.Builder.m_20704_(ShindeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShindeEntity::new).m_20699_(0.6f, 1.8f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> {
            return entityTypeBuilder.m_20712_(registryname);
        });
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            YandeEntity.init();
            YandegodieEntity.init();
            TaijiEntity.init();
            YandelosecarEntity.init();
            YandekeepEntity.init();
            YandeifEntity.init();
            ShindeEntity.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType) YANDE.get(), YandeEntity.createAttributes().m_22265_());
        event.put((EntityType) YANDEGODIE.get(), YandegodieEntity.createAttributes().m_22265_());
        event.put((EntityType) TAIJI.get(), TaijiEntity.createAttributes().m_22265_());
        event.put((EntityType) YANDELOSECAR.get(), YandelosecarEntity.createAttributes().m_22265_());
        event.put((EntityType) YANDEKEEP.get(), YandekeepEntity.createAttributes().m_22265_());
        event.put((EntityType) YANDEIF.get(), YandeifEntity.createAttributes().m_22265_());
        event.put((EntityType) SHINDE.get(), ShindeEntity.createAttributes().m_22265_());
    }
}