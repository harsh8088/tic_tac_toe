package com.droidrank.tictactoe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        block1 = (Button) findViewById(R.id.bt_block1);
        block2 = (Button) findViewById(R.id.bt_block2);
        block3 = (Button) findViewById(R.id.bt_block3);
        block4 = (Button) findViewById(R.id.bt_block4);
        block5 = (Button) findViewById(R.id.bt_block5);
        block6 = (Button) findViewById(R.id.bt_block6);
        block7 = (Button) findViewById(R.id.bt_block7);
        block8 = (Button) findViewById(R.id.bt_block8);
        block9 = (Button) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);
        block1.setOnClickListener(this);
        block2.setOnClickListener(this);
        block3.setOnClickListener(this);
        block4.setOnClickListener(this);
        block5.setOnClickListener(this);
        block6.setOnClickListener(this);
        block7.setOnClickListener(this);
        block8.setOnClickListener(this);
        block9.setOnClickListener(this);
        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (count == 0) {
            count++;
            setButtonView(v, "O");
        } else {
            if (count == 1 || count % 2 != 0) {
                 /*insert X here*/
                setButtonView(v, "X");
                count++;
            } else {
                   /*insert O here*/
                setButtonView(v, "O");
                count++;
            }
        }
        /* check if tic-tac-toe generated*/
        if (count >= 5) {
            if (isCreated("O"))
                showDialog("Player O Wins!!!!!");
            if (isCreated("X"))
                showDialog("Player X Wins!!!!!");
        }
    }

    private boolean isCreated(String value) {
        return (block1.getText().equals(value) && block2.getText().equals(value) && block3.getText().equals(value))
                || (block1.getText().equals(value) && block5.getText().equals(value) && block9.getText().equals(value))
                || (block1.getText().equals(value) && block4.getText().equals(value) && block7.getText().equals(value))
                || (block4.getText().equals(value) && block5.getText().equals(value) && block6.getText().equals(value))
                || (block7.getText().equals(value) && block8.getText().equals(value) && block9.getText().equals(value))
                || (block7.getText().equals(value) && block5.getText().equals(value) && block3.getText().equals(value))
                || (block3.getText().equals(value) && block6.getText().equals(value) && block9.getText().equals(value))
                || (block2.getText().equals(value) && block5.getText().equals(value) && block8.getText().equals(value));
    }

    private void showDialog(String s) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_result);
        dialog.setTitle(s);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                resetAll();
            }
        });
        dialog.show();
    }

    private void setButtonView(View view, String value) {
        switch (view.getId()) {
            case R.id.bt_block1:
                block1.setText(value);
                block1.setEnabled(false);
                break;
            case R.id.bt_block2:
                block2.setText(value);
                block2.setEnabled(false);
                break;
            case R.id.bt_block3:
                block3.setText(value);
                block3.setEnabled(false);
                break;
            case R.id.bt_block4:
                block4.setText(value);
                block4.setEnabled(false);
                break;
            case R.id.bt_block5:
                block5.setText(value);
                block5.setEnabled(false);
                break;
            case R.id.bt_block6:
                block6.setText(value);
                block6.setEnabled(false);
                break;
            case R.id.bt_block7:
                block7.setText(value);
                block7.setEnabled(false);
                break;
            case R.id.bt_block8:
                block8.setText(value);
                block8.setEnabled(false);
                break;
            case R.id.bt_block9:
                block9.setText(value);
                block9.setEnabled(false);
                break;
        }
    }

    private void resetAll() {
        block1.setText("");
        block1.setEnabled(true);
        block2.setText("");
        block2.setEnabled(true);
        block3.setText("");
        block3.setEnabled(true);
        block4.setText("");
        block4.setEnabled(true);
        block5.setText("");
        block5.setEnabled(true);
        block6.setText("");
        block6.setEnabled(true);
        block7.setText("");
        block7.setEnabled(true);
        block8.setText("");
        block8.setEnabled(true);
        block9.setText("");
        block9.setEnabled(true);
        count = 0;
    }
}
