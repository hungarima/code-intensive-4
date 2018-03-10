public class FrameCounter {
    private int count;
    private int max;

    public FrameCounter(int max) {
        this.max = max;
    }

    public boolean run() {
        if (this.count == this.max) {
            this.count = 0;
            return true;
        } else {
            this.count += 1;
            return false;
        }
    }

    public void setMax(int max) {
        this.max = max;
    }
}
