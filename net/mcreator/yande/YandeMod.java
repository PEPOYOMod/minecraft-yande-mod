package net.mcreator.yande;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.mcreator.yande.init.YandeModEntities;
import net.mcreator.yande.init.YandeModItems;
import net.mcreator.yande.init.YandeModMobEffects;
import net.mcreator.yande.init.YandeModSounds;
import net.mcreator.yande.init.YandeModTabs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod(YandeMod.MODID)
/* loaded from: YandeMod.class */
public class YandeMod {
    public static final Logger LOGGER = LogManager.getLogger(YandeMod.class);
    public static final String MODID = "yande";
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> {
        return PROTOCOL_VERSION;
    }, (v1) -> {
        return r2.equals(v1);
    }, (v1) -> {
        return r3.equals(v1);
    });
    private static int messageID = 0;
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue();

    public YandeMod() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        YandeModSounds.REGISTRY.register(bus);
        YandeModItems.REGISTRY.register(bus);
        YandeModEntities.REGISTRY.register(bus);
        YandeModTabs.REGISTRY.register(bus);
        YandeModMobEffects.REGISTRY.register(bus);
    }

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            workQueue.add(new AbstractMap.SimpleEntry<>(action, Integer.valueOf(tick)));
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(Integer.valueOf(((Integer) work.getValue()).intValue() - 1));
                if (((Integer) work.getValue()).intValue() == 0) {
                    actions.add(work);
                }
            });
            actions.forEach(e -> {
                ((Runnable) e.getKey()).run();
            });
            workQueue.removeAll(actions);
        }
    }
}
