package io.github.consistencyplus.consistency_plus.data.providers;

import com.withertech.mine_tags.tags.PlatformTags;
import io.github.consistencyplus.consistency_plus.base.ConsistencyPlusMain;
import io.github.consistencyplus.consistency_plus.core.extensions.CPlusFenceGateBlock;
import io.github.consistencyplus.consistency_plus.data.ConsistencyPlusTagProvider;
import io.github.consistencyplus.consistency_plus.data.ConsistencyPlusTags;
import io.github.consistencyplus.consistency_plus.registry.CPlusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ConsistencyPlusTagProviderFabric {

    public static class CommonBlockTagProvider extends FabricTagProvider.BlockTagProvider {

        public CommonBlockTagProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {
            ConsistencyPlusTagProvider.CommonBlockTagProvider.createAndFillTags(this::getOrCreateTagBuilder);
//            Registry.BLOCK.getEntries().stream().filter((entry) -> Objects.equals(entry.getKey().getValue().getNamespace(), ConsistencyPlusMain.ID))
//                    .forEach((entry) -> {
//                        Identifier identifier = entry.getKey().getValue();
//                        Block block = entry.getValue();
//
//                        boolean isNormalBlock = true;
//
//                        LOGGER.info("[CommonBlockTagProvider]: " + identifier + " / " + block);
//
//                        if(block instanceof StairsBlock){
//                            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.STAIRS).add(block);
//                            isNormalBlock = false;
//                        }else if(block instanceof SlabBlock){
//                            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.SLABS).add(block);
//                            isNormalBlock = false;
//                        }else if(block instanceof WallBlock){
//                            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.WALLS).add(block);
//                            isNormalBlock = false;
//                        }else if(block instanceof CPlusFenceGateBlock){
//                            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.FENCE_GATES).add(block);
//                            isNormalBlock = false;
//                        }
//
//
//                        String[] splitIdentifier = identifier.getPath().split("_");
//                        boolean isCryingObs = false;
//
//                        for(String string :  splitIdentifier){
//                            switch(string) {
//                                case "obsidian":
//                                    this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.DRAGON_IMMUNE).add(block);
//                                    this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.NEEDS_DIAMOND_TOOL).add(block);
//
//                                    break;
//                                case "crying":
//                                    isCryingObs = true;
//                                    break;
//                                case "prismarine":
//                                    this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.VALID_CONDUIT_BLOCKS).add(block);
//                                    break;
//                            }
//
//                            if(isNormalBlock){
//                                boolean shouldBreakForLoop = false;
//
////                                if(string.equals("bricks"))
////                                    this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.BRICKS).add(block);
//
//                                if(string.equals("terracotta"))
//                                    this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.TERRACOTTA).add(block);
//
//                                if(string.equals("terracotta"))
//                                    this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.TERRACOTTA).add(block);
//
//                                switch(string){
//                                    case "obsidian":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.Common.OBSIDIAN).add(block);
//
//                                        if(!isCryingObs)
//                                            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.VALID_PORTAL_BLOCKS).add(block);
//
//                                        break;
//                                    case "glass":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.IMPERMEABLE).add(block);
//                                        shouldBreakForLoop = true;
//                                        break;
//                                    case "end":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.DRAGON_IMMUNE).add(block);
//                                        shouldBreakForLoop = true;
//                                        break;
//                                    case "soul":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.SOUL_FIRE_BASE_BLOCKS).add(block);
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.SOUL_SPEED_BLOCKS).add(block);
//                                        shouldBreakForLoop = true;
//                                        break;
//                                    case "netherrack":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.Common.NETHERRACK);
//                                    case "nether":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.INFINIBURN_OVERWORLD).add(block);
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.INFINIBURN_NETHER).add(block);
//                                        shouldBreakForLoop = true;
//                                        break;
//                                    case "sandstone":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.Common.SANDSTONE);
//                                        shouldBreakForLoop = true;
//                                        break;
//                                    case "stone":
//                                        this.getOrCreateTagBuilder(ConsistencyPlusTags.Common.STONE);
//                                        shouldBreakForLoop = true;
//                                        break;
//                                }
//
//                                if(shouldBreakForLoop){
//                                    break;
//                                }
//                            }
//                        }
//
////                        if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "obsidian"))){
////                            boolean isCryingObs = getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "crying"));
////
////                            if(!isCryingObs) {
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.VALID_PORTAL_BLOCKS).add(block);
////                            }
////
////                            if(isNormalBlock) {
////                                this.getOrCreateTagBuilder(PlatformTags.Blocks.OBSIDIAN).add(block);
////                            }
////
////                            this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.DRAGON_IMMUNE).add(block);
////                            this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.NEEDS_DIAMOND_TOOL).add(block);
////                        }else if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "prismarine"))){
////                            this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.VALID_CONDUIT_BLOCKS).add(block);
////                        }
////
////                        if(isNormalBlock){
////
////                            if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "bricks"))){
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.STONE_BRICKS).add(block);
////                            }
////
////                            if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "glass"))){
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.IMPERMEABLE).add(block);
////                            }else if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "end"))){
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.DRAGON_IMMUNE).add(block);
////                            }else if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "soul"))){
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.SOUL_FIRE_BASE_BLOCKS).add(block);
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.SOUL_SPEED_BLOCKS).add(block);
////                            }else if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "nether") || Objects.equals(string, "netherrack"))){
////                                if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "netherrack"))){
////                                    this.getOrCreateTagBuilder(PlatformTags.Blocks.NETHERRACK);
////                                }
////
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.INFINIBURN_OVERWORLD).add(block);
////                                this.getOrCreateTagBuilder(ConsistencyPlusTags.CommonBlocks.INFINIBURN_NETHER).add(block);
////                            }else if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "sandstone"))){
////                                this.getOrCreateTagBuilder(PlatformTags.Blocks.SANDSTONE);
////                            } else if(getStream(splitIdentifier).anyMatch((string) -> Objects.equals(string, "stone"))){
////                                this.getOrCreateTagBuilder(PlatformTags.Blocks.STONE);
////                            }
////                        }
//            });
//
//            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.NEEDS_DIAMOND_TOOL).add(CPlusBlocks.NETHERITE_STAIRS);
//
//            this.getOrCreateTagBuilder(ConsistencyPlusTags.ConsistencySpecificTags.VALID_CONDUIT_BLOCKS).add(
//                    Blocks.PRISMARINE,
//                    Blocks.PRISMARINE_BRICK_SLAB,
//                    Blocks.PRISMARINE_BRICK_STAIRS,
//                    Blocks.PRISMARINE_BRICKS,
//                    Blocks.PRISMARINE_SLAB,
//                    Blocks.PRISMARINE_STAIRS,
//                    Blocks.PRISMARINE_WALL,
//                    Blocks.DARK_PRISMARINE,
//                    Blocks.DARK_PRISMARINE_SLAB,
//                    Blocks.DARK_PRISMARINE_STAIRS);
//
//            this.getOrCreateTagBuilder(BlockTags.STAIRS).addTag(ConsistencyPlusTags.ConsistencySpecificTags.STAIRS);
//            this.getOrCreateTagBuilder(BlockTags.SLABS).addTag(ConsistencyPlusTags.ConsistencySpecificTags.SLABS);
//            this.getOrCreateTagBuilder(BlockTags.WALLS).addTag(ConsistencyPlusTags.ConsistencySpecificTags.WALLS);
//            this.getOrCreateTagBuilder(BlockTags.FENCE_GATES).addTag(ConsistencyPlusTags.ConsistencySpecificTags.FENCE_GATES);
//
//            this.getOrCreateTagBuilder(BlockTags.IMPERMEABLE).addTag(ConsistencyPlusTags.ConsistencySpecificTags.IMPERMEABLE);
//
//            this.getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).addTag(ConsistencyPlusTags.ConsistencySpecificTags.DRAGON_IMMUNE);
//
//            this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).addTag(ConsistencyPlusTags.ConsistencySpecificTags.NEEDS_DIAMOND_TOOL);
//
//            this.getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS).addTag(ConsistencyPlusTags.ConsistencySpecificTags.SOUL_SPEED_BLOCKS);
//            this.getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS).addTag(ConsistencyPlusTags.ConsistencySpecificTags.SOUL_FIRE_BASE_BLOCKS);
//
//            this.getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD).addTag(ConsistencyPlusTags.ConsistencySpecificTags.INFINIBURN_OVERWORLD);
//            this.getOrCreateTagBuilder(BlockTags.INFINIBURN_NETHER).addTag(ConsistencyPlusTags.ConsistencySpecificTags.INFINIBURN_NETHER);
//
//            //-----------------------------------------------------------------------------------------------------------------------------//
        }

    }

    public static class DyeableBlockTagProvider extends FabricTagProvider.BlockTagProvider {

//        private static final Logger LOGGER = LogManager.getLogger(DyeableBlockTagProvider.class);
//
//        private static final DyeColor[] DYE_VALUES = DyeColor.values();
//
//        private static final List<String> BLOCK_PREFIXES = List.of("cobbled", "smooth", "cut", "chiseled", "carved", "polished");
//
//        private static final Map<String, String> BLOCK_SUFFIXES = Map.of(
//                "brick", "bricks",
//                "tile", "tiles",
//                "corner", "corner_pillar",
//                "pillar", "pillar",
//                "glass", "glass");
//
//        private static final Map<String, String> BLOCK_TYPE = Map.of(
//                "gates", "gate",
//                "slabs", "slab",
//                "stairs", "stairs",
//                "walls", "wall");
//
//        private static final Map<String, Identifier> TERRACOTA_BRICK_REMAP = Map.of(
//                "brick", new Identifier("bricks"),
//                "slabs",  new Identifier("brick_slab"),
//                "stairs",  new Identifier("brick_stairs"),
//                "walls", new Identifier("brick_wall"),
//                "gates", new Identifier(ConsistencyPlusMain.ID,"brick_gate"));

        public DyeableBlockTagProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {
            ConsistencyPlusTagProvider.DyeableBlockTagProvider.createAndFillTag(this::getOrCreateTagBuilder);
//            ConsistencyPlusTags.DyeableBlocks.ALL_DYEABLE_BLOCK_TAGS.forEach(this::createAndFillTag);
        }

//        private void createAndFillTag(Tag.Identified<Block> identified){
//            String[] nameParts = identified.getId().getPath().split("_");
//
//            String blockNamePrefix;
//            String blockNameSuffix;
//
//            if(BLOCK_PREFIXES.contains(nameParts[0])){
//                blockNamePrefix = nameParts[0];
//                blockNameSuffix = nameParts[1];
//
//                if(nameParts.length == 3){
//                    blockNameSuffix = blockNameSuffix + "_" + BLOCK_TYPE.get(nameParts[nameParts.length - 1]);
//                }
//            }else if(nameParts.length > 1 && BLOCK_SUFFIXES.containsKey(nameParts[1])){
//                blockNamePrefix = null;
//
//
//                if(nameParts.length == 3 && !(Objects.equals(nameParts[1], "corner"))){
//                    blockNameSuffix = nameParts[0] + "_" + nameParts[1];
//
//                    blockNameSuffix = blockNameSuffix + "_" + BLOCK_TYPE.get(nameParts[nameParts.length - 1]);
//                }else{
//                    blockNameSuffix = nameParts[0] + "_" + BLOCK_SUFFIXES.get(nameParts[1]);
//                }
//            }else{
//                blockNamePrefix = null;
//
//                if(nameParts.length > 1){
//                    blockNameSuffix = nameParts[0] + "_" + BLOCK_TYPE.get(nameParts[1]);
//                }else{
//                    blockNameSuffix = nameParts[0];
//                }
//            }
//
//            Block defaultBlock;
//
//            boolean minecraftNameSpace = Objects.equals(nameParts[0], "tinted") || (nameParts.length == 1 && (Objects.equals(nameParts[0], "ice") || Objects.equals(nameParts[0], "glowstone")));
//
//            if(blockNamePrefix != null){
//                defaultBlock = Registry.BLOCK.get(new Identifier(minecraftNameSpace ? "minecraft" : ConsistencyPlusMain.ID, blockNamePrefix + "_" + blockNameSuffix));
//                LOGGER.info("[1]:" +  new Identifier(minecraftNameSpace ? "minecraft" : ConsistencyPlusMain.ID, blockNamePrefix + "_" + blockNameSuffix));
//            }else{
//                defaultBlock = Registry.BLOCK.get(new Identifier(minecraftNameSpace ? "minecraft" : ConsistencyPlusMain.ID, blockNameSuffix));
//                LOGGER.info("[2]:" + new Identifier(minecraftNameSpace ? "minecraft" : ConsistencyPlusMain.ID, blockNameSuffix));
//            }
//
//            if(defaultBlock == Blocks.AIR) {
//                if (nameParts.length >= 2 && nameParts[0].equals("terracotta")) {
//                    if (Objects.equals(nameParts[1], "brick") || Objects.equals(nameParts[1], "bricks")) {
//                        LOGGER.info("FUCKFUCKFUCKF");
//                        defaultBlock = Registry.BLOCK.get(TERRACOTA_BRICK_REMAP.get(nameParts[nameParts.length - 1]));
//                    }
//                }
//            }
//
//            if(defaultBlock == Blocks.AIR){
//                if(blockNamePrefix != null){
//                    LOGGER.info("[1]:" + blockNamePrefix + "_" + blockNameSuffix);
//                }else{
//                    LOGGER.info("[2]:" + blockNameSuffix);
//                }
//            }
//
//            for(int i = 0; i < DYE_VALUES.length; i++){
//                boolean isItBlueIce = nameParts[0] == "ice" && DYE_VALUES[i].getName() == "blue";
//
//                if(blockNamePrefix != null){
//                    this.getOrCreateTagBuilder(identified).add(Registry.BLOCK.get(new Identifier(ConsistencyPlusMain.ID, blockNamePrefix + "_" + DYE_VALUES[i].getName() + "_" + blockNameSuffix)));
//                }else{
//                    this.getOrCreateTagBuilder(identified).add(Registry.BLOCK.get(new Identifier(isItBlueIce ? "minecraft" : ConsistencyPlusMain.ID, DYE_VALUES[i].getName() + "_" + blockNameSuffix)));
//                }
//            }
//
//            if(defaultBlock != Blocks.AIR){
//                this.getOrCreateTagBuilder(identified).add(defaultBlock);
//            }else{
//                LOGGER.info(nameParts[0] + " / " + defaultBlock + " / " + identified.getId());
//                //System.out.println(identified.getId() + " / " +  defaultBlock.toString());
//            }
//        }
    }
}
