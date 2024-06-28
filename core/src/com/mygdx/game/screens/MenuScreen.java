package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ui.PlayOption;
import com.mygdx.game.ui.QuitOption;
import com.mygdx.game.ui.SettingsOption;

public class MenuScreen implements Screen
{
    final private MyGdxGame game;
    private       Texture   logo;

    final private int screenWidth  = 640;
    final private int screenHeight = 480;

    //  Menu UI
    private BitmapFont font;

    private PlayOption     play;
    private SettingsOption settings;
    private QuitOption     quit;

    public MenuScreen(MyGdxGame game)
    {
        this.game = game;
    }

    @Override
    public void show()
    {
        logo = new Texture("logo.png");

        font = new BitmapFont();

        final Vector2 playPos = new Vector2(screenWidth / 2f - 10f, screenHeight / 2f + 50f);
        play = new PlayOption("Play", playPos, font, this);

        final Vector2 settingsPos = new Vector2(screenWidth / 2f - 10f, screenHeight / 2f);
        settings = new SettingsOption("Settings", settingsPos, font, this);

        final Vector2 quitPos = new Vector2(screenWidth / 2f - 10f, screenHeight / 2f - 50f);
        quit = new QuitOption("Quit", quitPos, font, this);

        System.out.println("krlho");
    }

    private void update(float dt)
    {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        play.update(mouseX, mouseY);
        settings.update(mouseX, mouseY);
        quit.update(mouseX, mouseY);
    }

    @Override
    public void render(float delta)
    {
        update(delta);

        ScreenUtils.clear(0.67f, 0.67f, 1f, 1f);

        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        float logoWidth  = logo.getWidth() / 2f;
        float logoHeight = logo.getHeight() / 2f;
        float logoX      = screenWidth / 2f - logoWidth / 2f;
        float logoY      = screenHeight - logoHeight - 50f;

        game.batch.begin();

        game.batch.draw(logo, logoX, logoY, logoWidth, logoHeight);

        font.draw(game.batch, "Mouse:", 5f, screenHeight - 5f);
        font.draw(game.batch, String.format("x: %d | y: %d", mouseX, mouseY), 5f, screenHeight - 20f);

        play.draw(game.batch, mouseX, mouseY);
        settings.draw(game.batch, mouseX, mouseY);
        quit.draw(game.batch, mouseX, mouseY);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
        System.out.printf("Screen Width: %d | Screen Height: %d%n", width, height);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        logo.dispose();
        font.dispose();
    }

    public int getScreenWidth()
    {
        return screenWidth;
    }

    public int getScreenHeight()
    {
        return screenHeight;
    }

    public MyGdxGame getGame() { return game; }
}
