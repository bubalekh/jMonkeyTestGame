package jmonkey_test.settings;

import com.jme3.system.AppSettings;

import java.awt.*;
import java.io.*;

public class GameSettings {

    public AppSettings loadOrDefault() {

        AppSettings settings = new AppSettings(true);

        try (InputStream settingsStream = new FileInputStream("settings")) {
            settings.load(settingsStream);
        } catch (IOException e) {
            GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            DisplayMode defaultMode = device.getDisplayModes()[0];
            settings.setResolution(defaultMode.getWidth(), defaultMode.getHeight());
            settings.setFrequency(defaultMode.getRefreshRate());
            settings.setBitsPerPixel(defaultMode.getBitDepth());
            settings.setFullscreen(device.isFullScreenSupported());
            settings.setVSync(true);
        }

        try (OutputStream settingStream = new FileOutputStream("settings")) {
            settings.save(settingStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return settings;
    }
}
