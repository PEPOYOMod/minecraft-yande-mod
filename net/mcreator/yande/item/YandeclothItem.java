package net.mcreator.yande.item;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/* loaded from: YandeclothItem.class */
public class YandeclothItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public String animationprocedure = "empty";
    String prevAnim = "empty";

    public YandeclothItem(ArmorItem.Type type, Item.Properties properties) {
        super(new 1(), type, properties);
    }

    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new 2(this));
    }

    public void m_7373_(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        m_7373_(itemstack, world, list, flag);
    }

    public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
    }

    private PlayState predicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
        }
        event.getController().setAnimation(RawAnimation.begin().thenLoop("none"));
        if (((Entity) event.getData(DataTickets.ENTITY)) instanceof ArmorStand) {
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    private PlayState procedurePredicate(AnimationState event) {
        if ((!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) || (!this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty"))) {
            if (!this.animationprocedure.equals(this.prevAnim)) {
                event.getController().forceAnimationReset();
            }
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
            if (((Entity) event.getData(DataTickets.ENTITY)) instanceof ArmorStand) {
                return PlayState.CONTINUE;
            }
            return PlayState.CONTINUE;
        } else if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
        } else {
            this.prevAnim = this.animationprocedure;
            return PlayState.CONTINUE;
        }
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController[]{new AnimationController(this, "controller", 5, this::predicate)});
        data.add(new AnimationController[]{new AnimationController(this, "procedureController", 5, this::procedurePredicate)});
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}