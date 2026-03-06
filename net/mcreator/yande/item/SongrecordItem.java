package net.mcreator.yande.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.ForgeRegistries;

/* loaded from: SongrecordItem.class */
public class SongrecordItem extends RecordItem {
    public SongrecordItem() {
        super(0, () -> {
            return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("yande:yande.song"));
        }, new Item.Properties().m_41487_(1).m_41497_(Rarity.COMMON), 5000);
    }
}