package jmonkey_test;

import org.junit.jupiter.api.Test;

public class GuiTest {

    @Test void testNiftyGui() {
        NiftyGuiApp app = new NiftyGuiApp();
        app.setPauseOnLostFocus(false);
        app.start();
    }
}
