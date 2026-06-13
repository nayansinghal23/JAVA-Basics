package AbstractFactoryDesignPattern.UILibrary.factories;

import AbstractFactoryDesignPattern.UILibrary.ui.Button;
import AbstractFactoryDesignPattern.UILibrary.ui.Checkbox;

public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
