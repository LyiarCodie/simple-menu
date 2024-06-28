package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.objects.Player;

public class PlayScreen implements Screen
{
    final private MyGdxGame game;

    private BitmapFont font;

    private Rectangle floorRect;

    final private float gravity = 0.25f;

    private Player player;

    public PlayScreen(MyGdxGame game)
    {
        this.game = game;
    }

    @Override
    public void show()
    {
        font = new BitmapFont();

        floorRect = new Rectangle(0f, 10f, game.getScreenWidth(), 10f);

        player = new Player(gravity, game);
    }

    private void update(float dt)
    {
        player.update(dt, floorRect);
    }

    @Override
    public void render(float delta)
    {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        update(delta);

        ScreenUtils.clear(1f, 1f, 1f, 1f);

        player.draw();

        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        game.shape.setColor(Color.BLACK);
        game.shape.rect(floorRect.x, floorRect.y, floorRect.width, floorRect.height);
        game.shape.end();

        game.batch.begin();
        font.draw(game.batch, "Mouse:", 5f, game.getScreenHeight() - 5f);
        font.draw(game.batch, String.format("x: %d | y: %d", mouseX, mouseY), 5f, game.getScreenHeight() - 20f);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

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
        font.dispose();
    }
}
