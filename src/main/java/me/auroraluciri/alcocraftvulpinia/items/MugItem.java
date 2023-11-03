package me.auroraluciri.alcocraftvulpinia.items;

import me.auroraluciri.alcocraftvulpinia.blocks.mugs.beer.BeerEnum;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MugItem extends ItemNameBlockItem {
    public MugItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean canPlace(BlockPlaceContext pContext, BlockState pState) {
        Player player = pContext.getPlayer();
        if (player != null && !player.isCrouching()) {
            return false;
        }
        return super.canPlace(pContext, pState);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack item) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack item) {
        return 32;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pLevel.isClientSide) {
            return super.use(pLevel, pPlayer, pUsedHand);
        }

        setNbt(pPlayer);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

//        @Override
//    public void fillItemCategory(CreativeModeTab pGroup, NonNullList<ItemStack> pItems) {
//
//        ItemStack stack = new ItemStack(this);
//        CompoundTag nbt = new CompoundTag();
//        nbt.putInt("AlcoholContent", 100);
//        stack.setTag(nbt);
//        pItems.add(stack);
//    }

    public void setNbt(Player player) {

        ItemStack stack = player.getInventory().getSelected();

        try {
            System.out.println(stack.getTag().getInt("AlcoContent"));
            if (stack.getTag().getInt("AlcoContent") >= 0) {
                return;
            }
        } catch (NullPointerException ignored) {

        }

        String dId = stack.getDescriptionId();
        String mugId = dId.substring(dId.indexOf('.') + 1).replace(".", ":") ;

        BeerEnum beerType = BeerEnum.CHORUS_ALE;

        if (mugId.equals(AlcoItems.MUG_OF_CHORUS_ALE.getId().toString())) {
            beerType = BeerEnum.CHORUS_ALE;
        } else if (mugId.equals(AlcoItems.MUG_OF_DIGGER_BITTER.getId().toString())) {
            beerType = BeerEnum.DIGGER_BITTER;
        } else if (mugId.equals(AlcoItems.MUG_OF_DROWNED_ALE.getId().toString())) {
            beerType = BeerEnum.DROWNED_ALE;
        } else if (mugId.equals(AlcoItems.MUG_OF_GRONGLE_LAMBIC.getId().toString())) {
            beerType = BeerEnum.GRONGLE_LAMBIC;
        } else if (mugId.equals(AlcoItems.MUG_OF_ICE_BEER.getId().toString())) {
            beerType = BeerEnum.ICE_BEER;
        } else if (mugId.equals(AlcoItems.MUG_OF_KVASS.getId().toString())) {
            beerType = BeerEnum.KVASS;
        } else if (mugId.equals(AlcoItems.MUG_OF_LEPRECHAUN_CIDER.getId().toString())) {
            beerType = BeerEnum.LEPRECHAUN_CIDER;
        } else if (mugId.equals(AlcoItems.MUG_OF_MAGNET_PILSNER.getId().toString())) {
            beerType = BeerEnum.MAGNET_PILSNER;
        } else if (mugId.equals(AlcoItems.MUG_OF_NETHER_PORTER.getId().toString())) {
            beerType = BeerEnum.NETHER_PORTER;
        } else if (mugId.equals(AlcoItems.MUG_OF_NETHER_STAR_LAGER.getId().toString())) {
            beerType = BeerEnum.NETHER_STAR_LAGER;
        } else if (mugId.equals(AlcoItems.MUG_OF_NIGHT_RAUCH.getId().toString())) {
            beerType = BeerEnum.NIGHT_RAUCH;
        } else if (mugId.equals(AlcoItems.MUG_OF_SUN_PALE_ALE.getId().toString())) {
            beerType = BeerEnum.SUN_PALE_ALE;
        } else if (mugId.equals(AlcoItems.MUG_OF_WITHER_STOUT.getId().toString())) {
            beerType = BeerEnum.WITHER_STOUT;
        }

        int alcoContent = beerType.getAlcoContent();

//        System.out.println("Found beer: " + beerType + " with " + alcoContent + " AlcoContent");

        CompoundTag nbt = new CompoundTag();
        nbt.putInt("AlcoContent", alcoContent);
        stack.setTag(nbt);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack item, Level world, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty())
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(AlcoItems.MUG_EMPTY.get()));
            else if (!player.getInventory().add(new ItemStack(AlcoItems.MUG_EMPTY.get())))
                player.drop(new ItemStack(AlcoItems.MUG_EMPTY.get()), false);
        }

        return super.finishUsingItem(item, world, entity);
    }
}
