package AbstractFactoryDesignPattern.UILibrary.windows;

import AbstractFactoryDesignPattern.UILibrary.OS;
import AbstractFactoryDesignPattern.UILibrary.ui.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println(OS.WINDOWS + " Checkbox Rendered");
    }
}
