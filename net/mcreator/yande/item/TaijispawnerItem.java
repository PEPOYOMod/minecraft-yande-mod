package net.mcreator.yande.item;

import net.mcreator.yande.procedures.TaijispawnerDangYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.context.UseOnContext;

/* loaded from: TaijispawnerItem.class */
public class TaijispawnerItem extends PickaxeItem {
    public TaijispawnerItem() {
        super(new 1(), 1, -3.0f, new Item.Properties());
    }

    public InteractionResult m_6225_(UseOnContext context) {
        m_6225_(context);
        TaijispawnerDangYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.m_43725_(), (double) context.m_8083_().m_123341_(), (double) context.m_8083_().m_123342_(), (double) context.m_8083_().m_123343_(), context.m_43723_());
        return InteractionResult.SUCCESS;
    }
}