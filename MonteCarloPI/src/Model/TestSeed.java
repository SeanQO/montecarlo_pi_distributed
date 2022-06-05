package model;

import java.io.Serializable;
import java.util.Random;

public class Test implements Serializable {

    private final int id;
    private final int seed;
    
    private int iterations;

    private final long points;
    private final long batchSize;

    private long remainingPoints;
    private long pointsInside;
    private long timeBeforeTest;  

    private Random rango;

    public Test(int id, int seed, long points, long batchSize) {
        this.id = id;
        this.seed = seed;
        this.points = points;
        this.remainingPoints = points;
        this.batchSize = batchSize;
        rango = new Random(seed);
        pointsInside = 0;
        iterations = 0;
    }

    public int getId() {
        return id;
    }

    public int getSeed() {
        return rng.nextInt();
    }
    public int getNextSeed() {
        return rng.nextInt();
    }

    public long getPoints() {
        return points;
    }

    public long getRemainingPoints() {
        return remainingPoints;
    }

    public void setRemainingPoints(long remainingPoints) {
        this.remainingPoints = remainingPoints;
    }

    public long getPointsInside() {
        return pointsInside;
    }

    public void addPointsInside(long pointsInside) {
        this.pointsInside += pointsInside;
        remainingPoints -= batchSize;
    }

    public void setTimeBeforeTest(long timeBeforeTest) {
        this.timeBeforeTest = timeBeforeTest;
    }

    public long execTime(long timeAfterTest) {
        return timeAfterTest - timeBeforeTest;
    }

    public int getIterations() {
        return iterations;
    }

    public void addIterations() {
        iterations++;
    }
}