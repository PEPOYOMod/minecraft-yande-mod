package net.mcreator.yande.entity;

import net.mcreator.yande.init.YandeModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
/* loaded from: ShindeEntity.class */
public class ShindeEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.m_135353_(ShindeEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.m_135353_(ShindeEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.m_135353_(ShindeEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<Boolean> DATA_bing = SynchedEntityData.m_135353_(ShindeEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<Integer> DATA_trigger = SynchedEntityData.m_135353_(ShindeEntity.class, EntityDataSerializers.f_135028_);
    private final AnimatableInstanceCache cache;
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure;
    String prevAnim;

    public ShindeEntity(PlayMessages.SpawnEntity packet, Level world) {
        this((EntityType) YandeModEntities.SHINDE.get(), world);
    }

    public ShindeEntity(EntityType<ShindeEntity> type, Level world) {
        super(type, world);
        this.cache = GeckoLibUtil.createInstanceCache(this);
        this.animationprocedure = "empty";
        this.prevAnim = "empty";
        this.f_21364_ = 0;
        m_21557_(false);
        m_274367_(0.6f);
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SHOOT, false);
        this.f_19804_.m_135372_(ANIMATION, "undefined");
        this.f_19804_.m_135372_(TEXTURE, "shinde");
        this.f_19804_.m_135372_(DATA_bing, false);
        this.f_19804_.m_135372_(DATA_trigger, 0);
    }

    public void setTexture(String texture) {
        this.f_19804_.m_135381_(TEXTURE, texture);
    }

    public String getTexture() {
        return (String) this.f_19804_.m_135370_(TEXTURE);
    }

    public Packet<ClientGamePacketListener> m_5654_() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.m_25352_(1, new FollowMobGoal(this, 1.0d, 10.0f, 5.0f));
        this.f_21345_.m_25352_(2, new 1(this, this, 1.2d, false));
        this.f_21345_.m_25352_(3, new RandomStrollGoal(this, 1.0d));
        this.f_21346_.m_25352_(4, new HurtByTargetGoal(this, new Class[0]));
        this.f_21345_.m_25352_(5, new RandomLookAroundGoal(this));
        this.f_21345_.m_25352_(6, new FloatGoal(this));
    }

    public MobType m_6336_() {
        return MobType.f_21640_;
    }

    public SoundEvent m_7975_(DamageSource ds) {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    public SoundEvent m_5592_() {
        return (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    public void m_7380_(CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128359_("Texture", getTexture());
        compound.m_128379_("Databing", ((Boolean) this.f_19804_.m_135370_(DATA_bing)).booleanValue());
        compound.m_128405_("Datatrigger", ((Integer) this.f_19804_.m_135370_(DATA_trigger)).intValue());
    }

    public void m_7378_(CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128441_("Texture")) {
            setTexture(compound.m_128461_("Texture"));
        }
        if (compound.m_128441_("Databing")) {
            this.f_19804_.m_135381_(DATA_bing, Boolean.valueOf(compound.m_128471_("Databing")));
        }
        if (compound.m_128441_("Datatrigger")) {
            this.f_19804_.m_135381_(DATA_trigger, Integer.valueOf(compound.m_128451_("Datatrigger")));
        }
    }

    public void m_6075_() {
        super.m_6075_();
        m_6210_();
    }

    public EntityDimensions m_6972_(Pose p_33597_) {
        return super.m_6972_(p_33597_).m_20388_(0.8f);
    }

    public static void init() {
        SpawnPlacements.m_21754_((EntityType) YandeModEntities.SHINDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, entityType, world, reason, pos, random -> {
            return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_219009_(world, pos, random) && Mob.m_217057_(entityType, world, reason, pos, random);
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.m_21552_();
        return builder.m_22268_(Attributes.f_22279_, 0.3d).m_22268_(Attributes.f_22276_, 1000.0d).m_22268_(Attributes.f_22284_, 0.0d).m_22268_(Attributes.f_22281_, 3.0d).m_22268_(Attributes.f_22277_, 16.0d);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            if (event.isMoving() || event.getLimbSwingAmount() <= -0.15f || event.getLimbSwingAmount() >= 0.15f) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("animation.shinde.walk"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.shinde.ambient"));
        }
        return PlayState.STOP;
    }

    private PlayState attackingPredicate(AnimationState event) {
        double d1 = m_20185_() - this.f_19790_;
        double d0 = m_20189_() - this.f_19792_;
        float sqrt = (float) Math.sqrt((d1 * d1) + (d0 * d0));
        if (m_21324_(event.getPartialTick()) > 0.0f && !this.swinging) {
            this.swinging = true;
            this.lastSwing = m_9236_().m_46467_();
        }
        if (this.swinging && this.lastSwing + 7 <= m_9236_().m_46467_()) {
            this.swinging = false;
        }
        if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().forceAnimationReset();
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.shinde.attack"));
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
        } else if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
        }
        this.prevAnim = this.animationprocedure;
        return PlayState.CONTINUE;
    }

    protected void m_6153_() {
        this.f_20919_++;
        if (this.f_20919_ == 20) {
            m_142687_(Entity.RemovalReason.KILLED);
            m_21226_();
        }
    }

    public String getSyncedAnimation() {
        return (String) this.f_19804_.m_135370_(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.f_19804_.m_135381_(ANIMATION, animation);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
        data.add(new AnimationController[]{new AnimationController(this, "attacking", 4, this::attackingPredicate)});
        data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}