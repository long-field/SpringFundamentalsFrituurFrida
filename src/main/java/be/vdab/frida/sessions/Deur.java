package be.vdab.frida.sessions;

public class Deur {
    private static final long serialVersionUID = 1L;
    private final int index;
    private final boolean metFriet;
    private boolean open;

    public Deur(int index, boolean metFriet) {
        this.index = index;
        this.metFriet = metFriet;
    }

    public void open() {
        open = true;
    }

    public int getIndex() {
        return index;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isMetFriet() {
        return metFriet;
    }

}
