package com.company;

import framework.Objects;

public class Bird extends Objects {

    private float vt = 0;

    private boolean isFlying;
    public Bird(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public void setVt(int n)
    {
        this.vt = n;
    }

    public void update(long deltaTime)
    {
        vt += Main.g;
        this.setPosY(this.getPosY() + vt);

        if(vt < 0) isFlying = true;
        else isFlying = false;
    }
    public void fly()
    {
        vt = -3;
    }

    public boolean getIsFlying()
    {
       return isFlying;
    }

}
