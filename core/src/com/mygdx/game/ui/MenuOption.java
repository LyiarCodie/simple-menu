package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.screens.MenuScreen;

public abstract class MenuOption
{
    final private   BitmapFont font;
    final private   String     text;
    final private   Vector2    position;
    final protected Rectangle  rect;
    final protected MenuScreen screen;

    public MenuOption(String text, Vector2 position, BitmapFont font, MenuScreen screen)
    {
        this.font     = font;
        this.text     = text;
        this.position = position;
        this.screen   = screen;

        this.rect = new Rectangle(position.x - 10f, (float) screen.getScreenHeight() - position.y,
                10f * (text.length() + 1), 20f);

        System.out.printf("%S option:\n", text);
        System.out.printf("x: %f | %f\n", position.x, position.y);
        System.out.println("Actual text position:");
        System.out.printf("x: %f | %f\n", position.x, (float) screen.getScreenHeight() - position.y);
    }

    abstract void update(int mouseX, int mouseY);

    public void draw(SpriteBatch batch, int mouseX, int mouseY)
    {
        if (rect.contains(mouseX, mouseY))
            font.setColor(1f, 1f, 0f, 1f);
        else
            font.setColor(1f, 1f, 1f, 1f);

        font.draw(batch, text, position.x, position.y);
        font.setColor(1f, 1f, 1f, 1f);
    }
}
