package com.cham.enchantedgoldenapple;

import net.neoforged.neoforge.common.ModConfigSpec;

// 配置类骨架：后续需要配置项时，在 BUILDER 上 define 即可。
// 定义好配置项后，记得在主类构造函数里注册配置，例如：
//   modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // 示例（供参考）：
    // public static final ModConfigSpec.BooleanValue SOME_FLAG = BUILDER
    //         .comment("What this flag does")
    //         .define("someFlag", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
