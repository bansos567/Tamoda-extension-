package com.tamoda.security;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import android.content.Context; // Import tambahan untuk mengenali konteks sistem

@DesignerComponent(version = 1,
    description = "Tamoda Security - Anti Clone & Emulator",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")
@SimpleObject(external = true)
public class TamodaGuard extends AndroidNonvisibleComponent {

    private Context context; // Variabel untuk menyimpan konteks aplikasi

    public TamodaGuard(ComponentContainer container) {
        super(container.$form());
        // Mengambil konteks dengan cara yang benar di App Inventor
        this.context = container.$context(); 
    }

    @SimpleFunction(description = "Deteksi apakah user pakai aplikasi kloning")
    public boolean IsCloned() {
        // Menggunakan variabel context yang sudah didefinisikan di atas
        String path = context.getFilesDir().getPath();
        return (path.contains("/dual/") || path.contains("/virtual/") || path.contains("/parallel/"));
    }

    @SimpleFunction(description = "Deteksi apakah user pakai Emulator PC")
    public boolean IsEmulator() {
        return (android.os.Build.MODEL.contains("google_sdk") ||
                android.os.Build.MODEL.contains("Emulator") ||
                android.os.Build.HARDWARE.contains("goldfish"));
    }
}
