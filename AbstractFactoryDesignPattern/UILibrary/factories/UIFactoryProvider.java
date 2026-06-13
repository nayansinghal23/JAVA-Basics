package AbstractFactoryDesignPattern.UILibrary.factories;

import AbstractFactoryDesignPattern.UILibrary.OS;

public class UIFactoryProvider {
    public static UIFactory getFactory(OS os) {
        if(os == OS.WINDOWS) return new WindowsFactory();
        throw new IllegalArgumentException("OS not supported");
    }
}
