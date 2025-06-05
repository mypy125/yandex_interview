package com.mygitgor.photoeditionplugin;

public interface Plugin {
    String getName();
    void applyImage(Image image,Object parameter);
    boolean validateParameter(Object parameter);
}
