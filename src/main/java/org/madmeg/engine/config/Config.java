package org.madmeg.engine.config;

/**
 * @author Madmegsox1
 * @since 17/02/2022
 */

public final class Config {
    public boolean comicSans;
    public int testI;
    public double testD;
    public float testF;
    public String testS;

    public boolean isComicSans() {
        return comicSans;
    }

    public void setComicSans(boolean comicSans) {
        this.comicSans = comicSans;
    }

    public int getTestI() {
        return testI;
    }

    public void setTestI(int testI) {
        this.testI = testI;
    }

    public double getTestD() {
        return testD;
    }

    public void setTestD(double testD) {
        this.testD = testD;
    }

    public float getTestF() {
        return testF;
    }

    public void setTestF(float testF) {
        this.testF = testF;
    }

    public String getTestS() {
        return testS;
    }

    public void setTestS(String testS) {
        this.testS = testS;
    }
}
