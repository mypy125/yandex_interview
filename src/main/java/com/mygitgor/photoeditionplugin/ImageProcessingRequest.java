package com.mygitgor.photoeditionplugin;

import java.util.List;

public record ImageProcessingRequest(Image image, List<ImageEffect> effects) {
}
