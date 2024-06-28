package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public class Player
{
    final private MyGdxGame game;

    private float gravity;
    private float moveSpeed = 6f;
    private float jumpHeight = 8f;

    private Rectangle rect;
    private Vector2 velocity;
    private Vector2 size;

    public Player(float gravity, MyGdxGame game) {
        this.gravity = gravity;
        this.game = game;

        size = new Vector2(32, 32);
        rect = new Rectangle(game.getScreenWidth() / 2f - size.x / 2, 300f, size.x, size.y);
        velocity = Vector2.Zero;
    }

    public void update(float dt, Rectangle otherRect) {
        int leftKey  = 0;
        int rightKey = 0;
        int jumpKey = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            leftKey = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            rightKey = 1;
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            jumpKey = 1;

        int move = leftKey + rightKey;

        velocity.x = move * moveSpeed;

        if (velocity.y < 10) velocity.y -= gravity;

        if (otherRect.contains(rect.x, rect.y - 1)) {
            velocity.y = jumpKey * jumpHeight;
        }

        rect.x += velocity.x;
        rect.y += velocity.y;
    }

    public void draw() {
        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        game.shape.setColor(Color.BLACK);
        game.shape.rect(rect.x, rect.y, rect.width, rect.height);
        game.shape.end();
    }
}
