package com.company;

import framework.Objects;

public class Chimney extends Objects {

    public Chimney(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public void Update()
    {
        setPosX(getPosX() - 2);
    }

}
