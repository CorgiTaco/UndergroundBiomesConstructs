package com.aang23.undergroundbiomes.registrar.pack;

import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import net.minecraft.resources.IPackFinder;
import net.minecraft.resources.IPackNameDecorator;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackInfo.IFactory;

import java.util.Map;
import java.util.function.Consumer;

public class UBPackFinder implements IPackFinder {
    @Override
    public void findPacks(Consumer<ResourcePackInfo> infoConsumer, IFactory infoFactory) {
        String s = "mod:undergroundbiomesores";
        ResourcePackInfo packInfo = ResourcePackInfo.createResourcePack(s, true, () -> new UBResourcePack(UBOreRegistrar.packDir), infoFactory, ResourcePackInfo.Priority.TOP, IPackNameDecorator.BUILTIN);
        if (packInfo != null) {
            infoConsumer.accept(packInfo);
        }
    }
}