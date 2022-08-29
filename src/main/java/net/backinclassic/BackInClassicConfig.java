package net.backinclassic;

import net.minecraftforge.common.ForgeConfigSpec;

public final class BackInClassicConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    //Config Variables
    public static final ForgeConfigSpec.ConfigValue<Boolean> old_combat;
    public static final ForgeConfigSpec.ConfigValue<Boolean> infinite_fluids;
    public static final ForgeConfigSpec.ConfigValue<Boolean> old_hunger;
    public static final ForgeConfigSpec.ConfigValue<Boolean> instant_bow;
    public static final ForgeConfigSpec.ConfigValue<Boolean> reach_around_block;
    public static final ForgeConfigSpec.ConfigValue<Boolean> after_death_explosion;

    public static final ForgeConfigSpec.ConfigValue<Boolean> generate_biomes;


    static {
    BUILDER.push("Config for Back in Classic!");
    //Config Variables in file
    old_combat = BUILDER.comment("(NOT USED) Reintroduce the old combat system. Default is False.").define("(Broken) Old Combat",false);
    infinite_fluids = BUILDER.comment("Make Lava and Water Spawners infinite. Default is False.").define("Infinite Fluids",false);
    old_hunger = BUILDER.comment("Reintroduce the old hunger system. Default is False.").define("Old Hunger",false);
    instant_bow = BUILDER.comment("Have the bow have no drawback. Default is True.").define("Instant Bow",true);
    reach_around_block = BUILDER.comment("Add in the Bedrock edition system of reaching around block edges. Default is True.").define("Reach Around Block",true);
    after_death_explosion = BUILDER.comment("Have creepers explode upon death. Default is False.").define("Creepers Explode on Death",false);
    generate_biomes = BUILDER.comment("(NOT USED) Have the Back in Classic biomes in your world. Default is True.").define("(Broken) Back in Classic Biomes",true);

    BUILDER.pop();
    SPEC = BUILDER.build();
    }
}
