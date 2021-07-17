package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {

    static public int IN = 1;
    static public int OUT = -1;
    static public int CLOSED = 0;
    private int mSwing;

    public Gate() {
    }

    public boolean setSwing(int direction) {
        if (direction == 0 || direction == 1 || direction == -1) {
            mSwing = direction;
            return true;
        } else
            return false;
    }

    public boolean open(int direction) {
        if (direction == CLOSED) {
            return false;
        }
        return setSwing(direction);
    }

    public void close() {
        mSwing = 0;
    }

    public int getSwingDirection() {
        return mSwing;
    }


    public int thru(int count) {
        if (mSwing == IN)
            return count;

        else if (mSwing == OUT)
            return -count;

        else
            return 0;
    }

    public String toString() {
        String message;
        if (mSwing == CLOSED)
            message = "This gate is closed";

        else if (mSwing == IN)
            message = "This gate is open and swings to enter the pen only";

        else if (mSwing == OUT)
            message = "This gate is open and swings to exit the pen only";

        else
            message = "This gate has an invalid swing direction";

        return message;
    }
}