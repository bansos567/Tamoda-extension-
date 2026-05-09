package com.tamoda.security;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1,
    description = "Tamoda Security - Anti Clone & Emulator",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")
@SimpleObject(external = true)
public class TamodaGuard extends AndroidNonvisibleComponent {

    public TamodaGuard(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Deteksi apakah user pakai aplikasi kloning")
    public boolean IsCloned() {
        String path = getContext().getFilesDir().getPath();
        return (path.contains("/dual/") || path.contains("/virtual/") || path.contains("/parallel/"));
    }

    @SimpleFunction(description = "Deteksi apakah user pakai Emulator PC")
    public boolean IsEmulator() {
        return (android.os.Build.MODEL.contains("google_sdk") ||
                android.os.Build.MODEL.contains("Emulator") ||
                android.os.Build.HARDWARE.contains("goldfish"));
    }
}
