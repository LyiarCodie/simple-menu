package com.mygdx.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.screens.MenuScreen;

public class QuitOption extends MenuOption
{
    public QuitOption(String text, Vector2 position, BitmapFont font, MenuScreen screen) {
        super(text, position, font, screen);
    }

    @Override
    public void update(int mouseX, int mouseY) {
        if (this.rect.contains(mouseX, mouseY) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            System.exit(0);
        }
    }
}
