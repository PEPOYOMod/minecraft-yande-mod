package net.mcreator.yande.entity;

import java.util.List;
import net.mcreator.yande.init.YandeModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
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
/* loaded from: TaijiEntity.class */
public class TaijiEntity extends TamableAnimal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.m_135353_(TaijiEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.m_135353_(TaijiEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.m_135353_(TaijiEntity.class, EntityDataSerializers.f_135030_);
    private final AnimatableInstanceCache cache;
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure;
    String prevAnim;

    public TaijiEntity(PlayMessages.SpawnEntity packet, Level world) {
        this((EntityType) YandeModEntities.TAIJI.get(), world);
    }

    public TaijiEntity(EntityType<TaijiEntity> type, Level world) {
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
        this.f_19804_.m_135372_(TEXTURE, "taiji");
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
        this.f_21346_.m_25352_(1, new OwnerHurtTargetGoal(this));
        this.f_21345_.m_25352_(2, new OwnerHurtByTargetGoal(this));
        this.f_21345_.m_25352_(3, new FollowOwnerGoal(this, 1.0d, 10.0f, 2.0f, false));
        this.f_21345_.m_25352_(4, new OpenDoorGoal(this, true));
        this.f_21345_.m_25352_(5, new 1(this, this, 2.0d, false));
        this.f_21345_.m_25352_(6, new RandomStrollGoal(this, 1.0d));
        this.f_21346_.m_25352_(7, new HurtByTargetGoal(this, new Class[0]));
        this.f_21345_.m_25352_(8, new RandomLookAroundGoal(this));
        this.f_21345_.m_25352_(9, new FloatGoal(this));
    }

    public MobType m_6336_() {
        return MobType.f_21640_;
    }

    public double m_6048_() {
        return super.m_6048_() - 0.1d;
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
    }

    public void m_7378_(CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128441_("Texture")) {
            setTexture(compound.m_128461_("Texture"));
        }
    }

    public InteractionResult m_6071_(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.m_21120_(hand);
        InteractionResult retval = InteractionResult.m_19078_(m_9236_().m_5776_());
        Item item = itemstack.m_41720_();
        if (itemstack.m_41720_() instanceof SpawnEggItem) {
            retval = super.m_6071_(sourceentity, hand);
        } else if (m_9236_().m_5776_()) {
            retval = ((m_21824_() && m_21830_(sourceentity)) || m_6898_(itemstack)) ? InteractionResult.m_19078_(m_9236_().m_5776_()) : InteractionResult.PASS;
        } else if (m_21824_()) {
            if (m_21830_(sourceentity)) {
                if (item.m_41472_() && m_6898_(itemstack) && m_21223_() < m_21233_()) {
                    m_142075_(sourceentity, hand, itemstack);
                    m_5634_(item.m_41473_().m_38744_());
                    retval = InteractionResult.m_19078_(m_9236_().m_5776_());
                } else if (m_6898_(itemstack) && m_21223_() < m_21233_()) {
                    m_142075_(sourceentity, hand, itemstack);
                    m_5634_(4.0f);
                    retval = InteractionResult.m_19078_(m_9236_().m_5776_());
                } else {
                    retval = super.m_6071_(sourceentity, hand);
                }
            }
        } else if (m_6898_(itemstack)) {
            m_142075_(sourceentity, hand, itemstack);
            if (this.f_19796_.m_188503_(3) == 0 && !ForgeEventFactory.onAnimalTame(this, sourceentity)) {
                m_21828_(sourceentity);
                m_9236_().m_7605_(this, (byte) 7);
            } else {
                m_9236_().m_7605_(this, (byte) 6);
            }
            m_21530_();
            retval = InteractionResult.m_19078_(m_9236_().m_5776_());
        } else {
            retval = super.m_6071_(sourceentity, hand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
                m_21530_();
            }
        }
        sourceentity.m_20329_(this);
        return retval;
    }

    public void m_6075_() {
        super.m_6075_();
        m_6210_();
    }

    public EntityDimensions m_6972_(Pose p_33597_) {
        return super.m_6972_(p_33597_).m_20388_(0.8f);
    }

    public AgeableMob m_142606_(ServerLevel serverWorld, AgeableMob ageable) {
        TaijiEntity retval = ((EntityType) YandeModEntities.TAIJI.get()).m_20615_(serverWorld);
        retval.m_6518_(serverWorld, serverWorld.m_6436_(retval.m_20183_()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    public boolean m_6898_(ItemStack stack) {
        return List.of((Object[]) new Item[]{Items.f_42579_, Items.f_42580_, Items.f_42526_, Items.f_42527_, Items.f_42528_, Items.f_42529_, Items.f_42530_, Items.f_42531_, Items.f_42485_, Items.f_42486_, Items.f_42581_, Items.f_42582_, Items.f_42697_, Items.f_42698_, Items.f_42648_, Items.f_42649_, Items.f_42699_, Items.f_42658_, Items.f_42659_, Items.f_42583_}).contains(stack.m_41720_());
    }

    public void m_7023_(Vec3 dir) {
        Entity entity = m_20197_().isEmpty() ? null : (Entity) m_20197_().get(0);
        if (m_20160_()) {
            m_146922_(entity.m_146908_());
            this.f_19859_ = m_146908_();
            m_146926_(entity.m_146909_() * 0.5f);
            m_19915_(m_146908_(), m_146909_());
            this.f_20883_ = entity.m_146908_();
            this.f_20885_ = entity.m_146908_();
            if (entity instanceof LivingEntity) {
                LivingEntity passenger = (LivingEntity) entity;
                m_7910_((float) m_21133_(Attributes.f_22279_));
                float forward = passenger.f_20902_;
                float strafe = passenger.f_20900_;
                super.m_7023_(new Vec3(strafe, 0.0d, forward));
            }
            double d1 = m_20185_() - this.f_19854_;
            double d0 = m_20189_() - this.f_19856_;
            float f1 = ((float) Math.sqrt((d1 * d1) + (d0 * d0))) * 4.0f;
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            this.f_267362_.m_267771_(this.f_267362_.m_267731_() + ((f1 - this.f_267362_.m_267731_()) * 0.4f));
            this.f_267362_.m_267590_(this.f_267362_.m_267756_() + this.f_267362_.m_267731_());
            m_267651_(true);
            return;
        }
        super.m_7023_(dir);
    }

    public void m_8107_() {
        super.m_8107_();
        m_21203_();
    }

    public static void init() {
        SpawnPlacements.m_21754_((EntityType) YandeModEntities.TAIJI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, entityType, world, reason, pos, random -> {
            return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_219009_(world, pos, random) && Mob.m_217057_(entityType, world, reason, pos, random);
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.m_21552_();
        return builder.m_22268_(Attributes.f_22279_, 0.3d).m_22268_(Attributes.f_22276_, 30.0d).m_22268_(Attributes.f_22284_, 2.0d).m_22268_(Attributes.f_22281_, 15.0d).m_22268_(Attributes.f_22277_, 40.0d);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("asfdesr"));
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