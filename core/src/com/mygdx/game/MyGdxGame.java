package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.screens.MenuScreen;

public class MyGdxGame extends Game
{
    final private int screenWidth  = 640;
    final private int screenHeight = 480;

    public SpriteBatch batch;

    public ShapeRenderer shape;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();

        setScreen(new MenuScreen(this));
    }

    @Override
    public void render()
    {
        super.render();
    }

    @Override
    public void dispose()
    {
        super.dispose();

        batch.dispose();
    }

    public int getScreenWidth()
    {
        return screenWidth;
    }
    public int getScreenHeight()
    {
        return screenHeight;
    }
}
