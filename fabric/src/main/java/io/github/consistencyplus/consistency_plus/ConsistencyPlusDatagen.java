package io.github.consistencyplus.consistency_plus;

import io.github.consistencyplus.consistency_plus.data.ConsistencyPlusTags;
import io.github.consistencyplus.consistency_plus.data.providers.ConsistencyPlusTagProviderFabric;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ConsistencyPlusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        ConsistencyPlusTags.init();
        fabricDataGenerator.addProvider(new ConsistencyPlusTagProviderFabric.DyeableBlockTagProvider(fabricDataGenerator));

        long startTime = System.currentTimeMillis();

        fabricDataGenerator.addProvider(new ConsistencyPlusTagProviderFabric.CommonBlockTagProvider(fabricDataGenerator));

        long finishTime = System.currentTimeMillis();

        System.out.printf("It took %f seconds for ConsistencyPlus CommonBlockTagProvider generating tags\n", (finishTime - startTime) / 1000.0F);
    }
}
