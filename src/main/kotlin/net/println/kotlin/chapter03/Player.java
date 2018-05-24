package net.println.kotlin.chapter03;

public class Player {
    private String name;
    private int time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    enum State {
        IDLE, BUFFERING, PLAYING, PAUSED
    }

    private State state = State.IDLE;

    public void pause() {
        switch (state) {
            case BUFFERING:
            case PLAYING:
                doPause();
                break;
            default:
                doOther();//什么都不做
        }
    }

    private void doOther() {
        System.out.println("doOther");
    }

    private void doPause() {
        System.out.println("doPause");
    }
}
