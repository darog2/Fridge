package com.dungeon;

public class IncorrectVolumeException extends Exception{
    public IncorrectVolumeException(double value) {
        super("Difference between full volume and inner volume must be 15% or more. Current difference "+(value-1));
    }
}
