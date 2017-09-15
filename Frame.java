public class Frame {
    
    // Corresponding to the first and second roll, respectively.
    int a, b;
    
    public Frame(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    /**
     *      Check if the frame is a STRIKE. That is, if in the first roll all 10 pins are knocked down.
     */
    public boolean isStrike() {
        return a == 10;
    }
    
    /**
     *      Check if the frame is a SPLIT. That is, if with both rolls all 10 pins are knocked down.
     */
    public boolean isSplit() {
        return (a + b == 10);
    }
    
    /**
     *      Return the sum of both rolls. The points obtained in this frame.
     */
    public int getSum() {
        return a + b;
    }
    
    /**
     *      Return only the points obtained in the first roll.
     */
    public int getFirstRoll() {
        return a;
    }
    
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
    
}