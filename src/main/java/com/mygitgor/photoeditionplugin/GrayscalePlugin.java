package com.mygitgor.photoeditionplugin;

public class GrayscalePlugin implements Plugin{
    @Override
    public String getName() {
        return "grayscale";
    }

    @Override
    public void applyImage(Image image, Object parameter) {
        System.out.println("Applying grayscale to " + image.name());
    }

    @Override
    public boolean validateParameter(Object parameter) {
        return parameter == null;
    }
}
