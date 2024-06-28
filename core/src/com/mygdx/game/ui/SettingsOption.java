package com.mygdx.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.SettingsScreen;

public class SettingsOption extends MenuOption
{
    public SettingsOption(String text, Vector2 position, BitmapFont font, MenuScreen screen) {
        super(text, position, font, screen);
    }

    @Override
    public void update(int mouseX, int mouseY) {
        if (this.rect.contains(mouseX, mouseY) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            screen.getGame().setScreen(new SettingsScreen(screen.getGame()));
        }
    }
}
