package com.tuleninov.portaone.task;

public interface Returnable {

    /**
     * The method accepts an arbitrary text as input and finds in each word of this text
     * the very first symbol that is no longer repeated in the analyzed word.
     * From the received set of characters, the method selects the first unique character
     * (that is, the one that no longer occurs in the set) and returns it.
     *
     * @param text an arbitrary text
     * @return the first unique character
     */
    char returnFirstUniqueChar(String text);

}
