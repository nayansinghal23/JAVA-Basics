package AbstractFactoryDesignPattern.UILibrary.windows;

import AbstractFactoryDesignPattern.UILibrary.OS;
import AbstractFactoryDesignPattern.UILibrary.ui.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println(OS.WINDOWS + " Button Rendered");
    }
}
