package net.mcreator.yande.entity;

import net.mcreator.yande.init.YandeModEntities;
import net.mcreator.yande.procedures.YandeDangShiTiGengXinKeShiawProcedure;
import net.mcreator.yande.procedures.YandeDangYouJiShiTiShiProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
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
/* loaded from: YandeEntity.class */
public class YandeEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.m_135353_(YandeEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.m_135353_(YandeEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.m_135353_(YandeEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<Boolean> DATA_withcar = SynchedEntityData.m_135353_(YandeEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<Boolean> DATA_action_allowed = SynchedEntityData.m_135353_(YandeEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<Integer> DATA_if_death = SynchedEntityData.m_135353_(YandeEntity.class, EntityDataSerializers.f_135028_);
    private final AnimatableInstanceCache cache;
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure;
    String prevAnim;

    public YandeEntity(PlayMessages.SpawnEntity packet, Level world) {
        this((EntityType) YandeModEntities.YANDE.get(), world);
    }

    public YandeEntity(EntityType<YandeEntity> type, Level world) {
        super(type, world);
        this.cache = GeckoLibUtil.createInstanceCache(this);
        this.animationprocedure = "empty";
        this.prevAnim = "empty";
        this.f_21364_ = 15;
        m_21557_(false);
        m_274367_(0.6f);
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SHOOT, false);
        this.f_19804_.m_135372_(ANIMATION, "undefined");
        this.f_19804_.m_135372_(TEXTURE, "yande");
        this.f_19804_.m_135372_(DATA_withcar, true);
        this.f_19804_.m_135372_(DATA_action_allowed, true);
        this.f_19804_.m_135372_(DATA_if_death, 0);
    }

    public void setTexture(String texture) {
        this.f_19804_.m_135381_(TEXTURE, texture);
    }

    public String getTexture() {
        return (String) this.f_19804_.m_135370_(TEXTURE);
    }

    protected float m_6431_(Pose poseIn, EntityDimensions sizeIn) {
        return 0.8f;
    }

    public Packet<ClientGamePacketListener> m_5654_() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.m_25352_(1, new 1(this, this, 1.2d, false));
        this.f_21345_.m_25352_(2, new RandomStrollGoal(this, 1.0d));
        this.f_21346_.m_25352_(3, new HurtByTargetGoal(this, new Class[0]));
        this.f_21345_.m_25352_(4, new RandomLookAroundGoal(this));
        this.f_21345_.m_25352_(5, new FloatGoal(this));
    }

    public MobType m_6336_() {
        return MobType.f_21641_;
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
        compound.m_128379_("Datawithcar", ((Boolean) this.f_19804_.m_135370_(DATA_withcar)).booleanValue());
        compound.m_128379_("Dataaction_allowed", ((Boolean) this.f_19804_.m_135370_(DATA_action_allowed)).booleanValue());
        compound.m_128405_("Dataif_death", ((Integer) this.f_19804_.m_135370_(DATA_if_death)).intValue());
    }

    public void m_7378_(CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128441_("Texture")) {
            setTexture(compound.m_128461_("Texture"));
        }
        if (compound.m_128441_("Datawithcar")) {
            this.f_19804_.m_135381_(DATA_withcar, Boolean.valueOf(compound.m_128471_("Datawithcar")));
        }
        if (compound.m_128441_("Dataaction_allowed")) {
            this.f_19804_.m_135381_(DATA_action_allowed, Boolean.valueOf(compound.m_128471_("Dataaction_allowed")));
        }
        if (compound.m_128441_("Dataif_death")) {
            this.f_19804_.m_135381_(DATA_if_death, Integer.valueOf(compound.m_128451_("Dataif_death")));
        }
    }

    public InteractionResult m_6071_(Player sourceentity, InteractionHand hand) {
        sourceentity.m_21120_(hand);
        InteractionResult retval = InteractionResult.m_19078_(m_9236_().m_5776_());
        super.m_6071_(sourceentity, hand);
        m_20185_();
        m_20186_();
        m_20189_();
        m_9236_();
        YandeDangYouJiShiTiShiProcedure.execute(this, sourceentity);
        return retval;
    }

    public void m_6075_() {
        super.m_6075_();
        YandeDangShiTiGengXinKeShiawProcedure.execute(m_9236_(), m_20185_(), m_20186_(), m_20189_(), this);
        m_6210_();
    }

    public EntityDimensions m_6972_(Pose p_33597_) {
        return super.m_6972_(p_33597_).m_20388_(0.8f);
    }

    public static void init() {
        SpawnPlacements.m_21754_((EntityType) YandeModEntities.YANDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, entityType, world, reason, pos, random -> {
            return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_219009_(world, pos, random) && Mob.m_217057_(entityType, world, reason, pos, random);
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.m_21552_();
        return builder.m_22268_(Attributes.f_22279_, 0.3d).m_22268_(Attributes.f_22276_, 40.0d).m_22268_(Attributes.f_22284_, 1.1d).m_22268_(Attributes.f_22281_, 7.0d).m_22268_(Attributes.f_22277_, 32.0d).m_22268_(Attributes.f_22278_, 0.2d);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.yande.ambient"));
        }
        return PlayState.STOP;
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
        data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}