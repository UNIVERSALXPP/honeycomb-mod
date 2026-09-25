package com.example.purplehoney;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class PurpleHoneyMod implements ModInitializer {

    public static final String MOD_ID = "purplehoney";

    public static final Block HONEYCOMB_STAIRS = new StairsBlock(
            net.minecraft.block.Blocks.HONEYCOMB_BLOCK.getDefaultState(),
            FabricBlockSettings.copyOf(net.minecraft.block.Blocks.HONEYCOMB_BLOCK)
                    .sounds(BlockSoundGroup.WOOL)
    );

    public static final Item HONEYCOMB_STAIRS_ITEM = new BlockItem(
            HONEYCOMB_STAIRS, new Item.Settings()
    );

    @Override
    public void onInitialize() {
        Identifier blockId = Identifier.of(MOD_ID, "honeycomb_stairs");

        Registry.register(Registries.BLOCK, blockId, HONEYCOMB_STAIRS);
        Registry.register(Registries.ITEM, blockId, HONEYCOMB_STAIRS_ITEM);

        // Put it in the Building Blocks creative tab, right after honeycomb block
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(HONEYCOMB_STAIRS_ITEM);
        });
    }
}
