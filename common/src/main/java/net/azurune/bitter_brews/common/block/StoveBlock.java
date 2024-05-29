package net.azurune.bitter_brews.common.block;

import net.azurune.bitter_brews.core.registry.BBDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class StoveBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private final int stoveDamage;

    public StoveBlock(BlockBehaviour.Properties settings, int stoveDamage) {
        super(settings);
        this.stoveDamage = stoveDamage;
        registerDefaultState(getStateDefinition().any().setValue(LIT, true));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            DamageSource damagesource = new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(BBDamageTypes.STOVE));
            if (!state.getValue(LIT)) {
                entity.hurt(damagesource, stoveDamage);
            } else if (state.getValue(LIT)) {
                entity.hurt(damagesource, stoveDamage * 2);
            }
        }
        super.stepOn(world, pos, state, entity);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        Item heldItem = stackHand.getItem();

        if (stackHand.is(ItemTags.SHOVELS) && state.getValue(LIT)) {
            extinguish(state, world, pos);
            if (!player.isCreative()) {
                stackHand.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            }
            return InteractionResult.SUCCESS;
        }

        if (heldItem instanceof FlintAndSteelItem && !state.getValue(LIT)) {
            ignite(state, world, pos);
            if (!player.isCreative()) {
                stackHand.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos blockPos = hit.getBlockPos();
        if (!world.isClientSide() && projectile.isOnFire() && projectile.mayInteract(world, blockPos) && !state.getValue(LIT)) {
            world.setBlock(blockPos, state.setValue(LIT, true), 11);
        }
    }

    public static boolean burntOut(BlockState state) {
        return !state.getValue(LIT);
    }

    public void ignite(BlockState state, Level world, BlockPos pos) {
        world.setBlockAndUpdate(pos, state.setValue(LIT, true));
        double posX = pos.getX();
        double posY = pos.getY();
        double posZ = pos.getZ();
        world.playSound(null, posX, posY, posZ, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 0.5f, 1.0f);
    }

    public void extinguish(BlockState state, Level world, BlockPos pos) {
        world.setBlockAndUpdate(pos, state.setValue(LIT, false));
        double posX = pos.getX();
        double posY = pos.getY();
        double posZ = pos.getZ();
        world.playSound(null, posX, posY, posZ, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5f, 1.0f);
    }
}
