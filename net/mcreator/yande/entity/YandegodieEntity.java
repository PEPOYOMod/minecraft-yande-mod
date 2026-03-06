package net.mcreator.yande.entity;

import javax.annotation.Nullable;
import net.mcreator.yande.init.YandeModEntities;
import net.mcreator.yande.procedures.YandeDangShiTiGengXinKeShiProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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
/* loaded from: YandegodieEntity.class */
public class YandegodieEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.m_135353_(YandegodieEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.m_135353_(YandegodieEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.m_135353_(YandegodieEntity.class, EntityDataSerializers.f_135030_);
    private final AnimatableInstanceCache cache;
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure;
    String prevAnim;

    public YandegodieEntity(PlayMessages.SpawnEntity packet, Level world) {
        this((EntityType) YandeModEntities.YANDEGODIE.get(), world);
    }

    public YandegodieEntity(EntityType<YandegodieEntity> type, Level world) {
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
        this.f_19804_.m_135372_(TEXTURE, "yande");
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
        this.f_21345_.m_25352_(1, new 1(this, this, 1.2d, false));
        this.f_21345_.m_25352_(2, new RandomStrollGoal(this, 1.0d));
        this.f_21346_.m_25352_(3, new HurtByTargetGoal(this, new Class[0]));
        this.f_21345_.m_25352_(4, new RandomLookAroundGoal(this));
        this.f_21345_.m_25352_(5, new FloatGoal(this));
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

    public boolean m_6469_(DamageSource source, float amount) {
        if (source.m_276093_(DamageTypes.f_268631_) || (source.m_7640_() instanceof AbstractArrow) || (source.m_7640_() instanceof Player) || (source.m_7640_() instanceof ThrownPotion) || (source.m_7640_() instanceof AreaEffectCloud) || source.m_276093_(DamageTypes.f_268671_) || source.m_276093_(DamageTypes.f_268585_) || source.m_276093_(DamageTypes.f_268722_) || source.m_276093_(DamageTypes.f_268450_) || source.m_276093_(DamageTypes.f_268565_) || source.m_276093_(DamageTypes.f_268714_) || source.m_276093_(DamageTypes.f_268526_) || source.m_276093_(DamageTypes.f_268482_) || source.m_276093_(DamageTypes.f_268493_) || source.m_276093_(DamageTypes.f_268641_)) {
            return false;
        }
        return super.m_6469_(source, amount);
    }

    public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
        YandeDangShiTiGengXinKeShiProcedure.execute(world, m_20185_(), m_20186_(), m_20189_(), this);
        return retval;
    }

    public void m_7380_(CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128359_("Texture", getTexture());
    }

    public void m_7378_(CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128441_("Texture")) {
            setTexture(compound.m_128461_("Texture"));
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
        SpawnPlacements.m_21754_((EntityType) YandeModEntities.YANDEGODIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, entityType, world, reason, pos, random -> {
            return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_219009_(world, pos, random) && Mob.m_217057_(entityType, world, reason, pos, random);
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.m_21552_();
        return builder.m_22268_(Attributes.f_22279_, 0.3d).m_22268_(Attributes.f_22276_, 100.0d).m_22268_(Attributes.f_22284_, 0.0d).m_22268_(Attributes.f_22281_, 3.0d).m_22268_(Attributes.f_22277_, 16.0d);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("asdaw"));
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