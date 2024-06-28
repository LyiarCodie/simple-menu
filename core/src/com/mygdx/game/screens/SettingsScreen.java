package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

public class SettingsScreen implements Screen
{
    private Stage stage;
    private Table table;
    private Skin  skin;

    private Texture bg1, bg2;

    final private float horVelocity = 50f;
    final private float bg1Scale    = 2.25f;

    private Vector2 bg1pos, bg2pos;

    final private MyGdxGame game;

    public SettingsScreen(MyGdxGame game)
    {
        this.game = game;
    }

    @Override
    public void show()
    {
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        bg1 = new Texture("bg1.png");
        bg2 = new Texture("bg1.png");

        bg1pos = new Vector2(0f, 0f);
        bg2pos = new Vector2(bg1.getWidth() / bg1Scale, 0f);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        //        table.debug();

        createOptions();
    }

    private void createOptions()
    {
        TextButton button2 = new TextButton("Button 1", skin);
        TextButton button3 = new TextButton("Button 2", skin);
        TextButton button4 = new TextButton("Button 3", skin);
        TextButton button5 = new TextButton("Button 4", skin);

        table.add(button2);
        table.row().pad(5, 0, 5, 0);
        table.add(button3);
        table.row();
        table.add(button4);
        table.row().pad(5, 0, 0, 0);
        table.add(button5);

        TextButton backBtn = new TextButton("Back", skin);

        table.row().pad(10, 0, 0, 0).fillX();
        table.add(backBtn);

        backBtn.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new MenuScreen(game));
            }
        });
    }

    private void update(float dt)
    {
        bg1pos.x -= horVelocity * dt;
        bg2pos.x -= horVelocity * dt;

        float bg1RightEdge = bg1pos.x + bg1.getWidth() / bg1Scale;
        float bg2RightEdge = bg2pos.x + bg2.getWidth() / bg1Scale;
        if (bg1RightEdge < 0)
            bg1pos.x = bg2RightEdge;
        else if (bg2RightEdge < 0)
            bg2pos.x = bg1RightEdge;
    }

    @Override
    public void render(float delta)
    {
        update(delta);

        ScreenUtils.clear(new Color(0f, 0, 0f, 1f));

        game.batch.begin();
        game.batch.draw(bg1, bg1pos.x, bg1pos.y, bg1.getWidth() / bg1Scale, bg1.getHeight() / bg1Scale);
        game.batch.draw(bg2, bg2pos.x, bg2pos.y, bg2.getWidth() / bg1Scale, bg2.getHeight() / bg1Scale);
        game.batch.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        skin.dispose();
        bg1.dispose();
        bg2.dispose();
    }

    public MyGdxGame getGame()
    {
        return game;
    }
}
