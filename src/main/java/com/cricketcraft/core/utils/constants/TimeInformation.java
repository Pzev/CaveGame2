package com.cricketcraft.core.utils.constants;

public class TimeInformation
{
    public static final int MILLION = 1000000;
    public static final int BILLION = 1000000000;
    public static final long TRILLION = 1000000000000L;

    public static long Milliseconds50 = System.nanoTime() / MILLION;
    public static long Milliseconds200 = System.nanoTime() / MILLION;
    public static long Seconds1 = System.nanoTime() / BILLION;
    public static long Seconds3 = System.nanoTime() / BILLION;
    public static long Seconds10 = System.nanoTime() / BILLION;
    public static long Seconds30 = System.nanoTime() / BILLION;
    public static long Minutes1 = System.nanoTime();
    public static long Minutes5 = System.nanoTime();
    public static long Hours1 = System.nanoTime();
    public static long Days1 = System.nanoTime();
}
