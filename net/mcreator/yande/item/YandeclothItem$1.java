package net.mcreator.yande.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/* loaded from: YandeclothItem$1.class */
class YandeclothItem$1 implements ArmorMaterial {
    YandeclothItem$1() {
    }

    public int m_266425_(ArmorItem.Type type) {
        return new int[]{13, 15, 16, 11}[type.m_266308_().m_20749_()] * 25;
    }

    public int m_7366_(ArmorItem.Type type) {
        return new int[]{2, 5, 6, 2}[type.m_266308_().m_20749_()];
    }

    public int m_6646_() {
        return 9;
    }

    public SoundEvent m_7344_() {
        return SoundEvents.f_271165_;
    }

    public Ingredient m_6230_() {
        return Ingredient.m_151265_();
    }

    public String m_6082_() {
        return "yandecloth";
    }

    public float m_6651_() {
        return 0.0f;
    }

    public float m_6649_() {
        return 0.0f;
    }
}