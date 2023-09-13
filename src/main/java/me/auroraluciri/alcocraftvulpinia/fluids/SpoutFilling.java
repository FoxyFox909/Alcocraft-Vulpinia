package me.auroraluciri.alcocraftvulpinia.fluids;


import com.simibubi.create.api.behaviour.BlockSpoutingBehaviour;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.RegisteredObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

//Test class
public class SpoutFilling extends BlockSpoutingBehaviour {

    ResourceLocation MUG = new ResourceLocation("alcocraftvulpinia", "mug_empty");
    //ResourceLocation BASIN = new ResourceLocation("tconstruct", "basin");

    @Override
    public int fillBlock(Level level, BlockPos pos, SpoutBlockEntity spout, FluidStack availableFluid,
                         boolean simulate) {

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity == null) {
            return 0;
        }

        IFluidHandler handler = blockEntity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP)
                .orElse(null);

        if (handler == null) {
            return 0;
        }
        if (handler.getTanks() != 1) {
            return 0;
        }

        ResourceLocation registryName = RegisteredObjects.getKeyOrThrow(blockEntity.getType());
        if (!registryName.equals(MUG)) {
            return 0;
        }

        if (!handler.isFluidValid(0, availableFluid)) {
            return 0;
        }

        FluidStack containedFluid = handler.getFluidInTank(0);
        if (!(containedFluid.isEmpty() || containedFluid.isFluidEqual(availableFluid))) {
            return 0;
        }

        // Do not fill if it would only partially fill the table (unless > 250mb)
        int amount = availableFluid.getAmount();
        if (amount < 250
                && handler.fill(FluidHelper.copyStackWithAmount(availableFluid, amount + 1), IFluidHandler.FluidAction.SIMULATE) > amount) {
            return 0;
        }

        // Return amount filled into the table/basin
        return handler.fill(availableFluid, simulate ? IFluidHandler.FluidAction.SIMULATE : IFluidHandler.FluidAction.EXECUTE);

    }

}
