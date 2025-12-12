package club.tesseract.fabric.mixins;

import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.resources.SplashManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SplashManager.class)
public class SplashManagerMixin {

    @Unique
    private final static SplashRenderer SPLASH_RENDERER = new SplashRenderer("beep beep I'm a mod");


    /**
     * @author TropicalShadow
     * @reason Funny
     */
    @Overwrite
    public @Nullable SplashRenderer getSplash() {
        return SPLASH_RENDERER;
    }

}
