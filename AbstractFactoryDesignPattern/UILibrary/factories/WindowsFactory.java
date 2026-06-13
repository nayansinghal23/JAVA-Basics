package AbstractFactoryDesignPattern.UILibrary.factories;

import AbstractFactoryDesignPattern.UILibrary.ui.Button;
import AbstractFactoryDesignPattern.UILibrary.ui.Checkbox;
import AbstractFactoryDesignPattern.UILibrary.windows.WindowsButton;
import AbstractFactoryDesignPattern.UILibrary.windows.WindowsCheckbox;

public class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
