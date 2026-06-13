package AbstractFactoryDesignPattern.UILibrary;

import AbstractFactoryDesignPattern.UILibrary.factories.UIFactory;
import AbstractFactoryDesignPattern.UILibrary.factories.UIFactoryProvider;
import AbstractFactoryDesignPattern.UILibrary.ui.Button;
import AbstractFactoryDesignPattern.UILibrary.ui.Checkbox;

public class Main {
    public static void main() {
        UIFactory factory =
        UIFactoryProvider.getFactory(OS.WINDOWS);

        Button button =
        factory.createButton();

        Checkbox checkbox =
        factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
