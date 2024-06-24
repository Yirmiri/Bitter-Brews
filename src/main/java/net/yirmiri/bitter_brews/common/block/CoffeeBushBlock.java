package net.yirmiri.bitter_brews.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.bitter_brews.core.registry.BBBlocks;
import net.yirmiri.bitter_brews.core.registry.BBDamageTypes;
import net.yirmiri.bitter_brews.core.registry.BBItems;

public class CoffeeBushBlock extends BushBlock {
    public static final IntegerProperty AGE;
    private static final VoxelShape TOP_BOX_SHAPE;
    private static final VoxelShape BOTTOM_BOX_SHAPE;
    private static final VoxelShape LARGE_SHAPE;
    private static final VoxelShape SMALL_SHAPE;

    public CoffeeBushBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    public static final MapCodec<CoffeeBushBlock> CODEC = simpleCodec(CoffeeBushBlock::new);

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CoffeeBushBlock.CODEC;
    }

    public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
        return new ItemStack(BBBlocks.COFFEE_BUSH.get());
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        if (state.getValue(AGE) > 1) {
            return LARGE_SHAPE;
        } else {
            return SMALL_SHAPE;
        }
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        int age = state.getValue(AGE);
        if (age < 3 && random.nextInt(5) == 0 && world.getRawBrightness(pos.above(), 0) >= 9) {
            BlockState blockState = state.setValue(AGE, age + 1);
            world.setBlock(pos, blockState, 2);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
        }
    }

    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(state, new Vec3(0.800000011920929, 0.75, 0.800000011920929));
            if (!world.isClientSide() && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.xOld);
                double e = Math.abs(entity.getZ() - entity.zOld);
                if (d >= 0.003000000026077032 || e >= 0.003000000026077032) {
                    DamageSource damagesource = new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(BBDamageTypes.COFFEE_BUSH));
                    if (state.getValue(AGE) > 1) {
                        entity.hurt(damagesource, 2);
                    } else {
                        entity.hurt(damagesource, 1);
                    }
                }
            }
        }
    }

    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int age = state.getValue(AGE);
        boolean bl = age == 3;
        InteractionHand hand = player.getUsedItemHand();
        if (!bl && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (bl) {
            popResource(world, pos, new ItemStack(BBItems.COFFEE_BEANS.get(), 2));
            world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = state.setValue(AGE, 2);
            world.setBlock(pos, blockState, 2);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
            return InteractionResult.sidedSuccess(world.isClientSide());
        } else {
            return super.useWithoutItem(state, world, pos, player, hit);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

//    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
//        return state.getValue(AGE) < 3;
//    }
//
//    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
//        return true;
//    }
//
//    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
//        int i = Math.min(3, state.getValue(AGE) + 1);
//        world.setBlock(pos, state.setValue(AGE, i), 2);
//    }

    static {
        AGE = BlockStateProperties.AGE_3;
        BOTTOM_BOX_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
        TOP_BOX_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 26.0, 15.0);
        LARGE_SHAPE = Shapes.or(BOTTOM_BOX_SHAPE, new VoxelShape[]{TOP_BOX_SHAPE});
        SMALL_SHAPE = Shapes.or(BOTTOM_BOX_SHAPE);
    }
}
