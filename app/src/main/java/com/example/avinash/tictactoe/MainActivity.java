package com.example.avinash.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox ivCellR1C1;
    private CheckBox ivCellR3C3;
    private CheckBox ivCellR3C2;
    private CheckBox ivCellR3C1;
    private CheckBox ivCellR2C3;
    private CheckBox ivCellR2C2;
    private CheckBox ivCellR2C1;
    private CheckBox ivCellR1C3;
    private CheckBox ivCellR1C2;
    private Button btnReset;
    private boolean circleTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        checkChangeListener();
        gameReset();
    }

    private void gameReset() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllBox();
            }
        });
    }

    private void resetAllBox() {
        ivCellR1C1.setFocusable(true);
        ivCellR1C2.setFocusable(true);
        ivCellR1C3.setFocusable(true);
        ivCellR2C1.setFocusable(true);
        ivCellR2C2.setFocusable(true);
        ivCellR2C3.setFocusable(true);
        ivCellR3C1.setFocusable(true);
        ivCellR3C2.setFocusable(true);
        ivCellR3C3.setFocusable(true);

        ivCellR1C1.setBackground(null);
        ivCellR1C2.setBackground(null);
        ivCellR1C3.setBackground(null);
        ivCellR2C1.setBackground(null);
        ivCellR2C2.setBackground(null);
        ivCellR2C3.setBackground(null);
        ivCellR3C1.setBackground(null);
        ivCellR3C2.setBackground(null);
        ivCellR3C3.setBackground(null);
    }

    private void initViews() {
        ivCellR1C1 = findViewById(R.id.iv_cell_r1_c1);
        ivCellR1C2 = findViewById(R.id.iv_cell_r1_c2);
        ivCellR1C3 = findViewById(R.id.iv_cell_r1_c3);
        ivCellR2C1 = findViewById(R.id.iv_cell_r2_c1);
        ivCellR2C2 = findViewById(R.id.iv_cell_r2_c2);
        ivCellR2C3 = findViewById(R.id.iv_cell_r2_c3);
        ivCellR3C1 = findViewById(R.id.iv_cell_r3_c1);
        ivCellR3C2 = findViewById(R.id.iv_cell_r3_c2);
        ivCellR3C3 = findViewById(R.id.iv_cell_r3_c3);
        btnReset = findViewById(R.id.btn_reset);
    }

    private void checkChangeListener() {
        ivCellR1C1.setOnCheckedChangeListener(this);
        ivCellR1C2.setOnCheckedChangeListener(this);
        ivCellR1C3.setOnCheckedChangeListener(this);
        ivCellR2C1.setOnCheckedChangeListener(this);
        ivCellR2C2.setOnCheckedChangeListener(this);
        ivCellR2C3.setOnCheckedChangeListener(this);
        ivCellR3C1.setOnCheckedChangeListener(this);
        ivCellR3C2.setOnCheckedChangeListener(this);
        ivCellR3C3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        turnDecider();
        switch (buttonView.getId()) {
            case R.id.iv_cell_r1_c1:
               getResourceAndDisableBox(isChecked, ivCellR1C1);
                break;
            case R.id.iv_cell_r1_c2:
                getResourceAndDisableBox(isChecked, ivCellR1C2);
                break;
            case R.id.iv_cell_r1_c3:
               getResourceAndDisableBox(isChecked, ivCellR1C3);
                break;
            case R.id.iv_cell_r2_c1:
               getResourceAndDisableBox(isChecked, ivCellR2C1);
                break;
            case R.id.iv_cell_r2_c2:
               getResourceAndDisableBox(isChecked, ivCellR2C2);
                break;
            case R.id.iv_cell_r2_c3:
               getResourceAndDisableBox(isChecked, ivCellR2C3);
                break;
            case R.id.iv_cell_r3_c1:
                getResourceAndDisableBox(isChecked, ivCellR3C1);
                break;
            case R.id.iv_cell_r3_c2:
               getResourceAndDisableBox(isChecked, ivCellR3C2);
                break;
            case R.id.iv_cell_r3_c3:
                getResourceAndDisableBox(isChecked, ivCellR3C3);
                break;

        }
    }

    private void turnDecider() {
        circleTurn = !circleTurn;
    }

    private void getResourceAndDisableBox(boolean isChecked, CheckBox checkBox) {
        int resouceId = -1;
        if (checkBox.getFocusable()==View.FOCUSABLE) {
            if (circleTurn) {
                checkBox.setBackground(getDrawable(R.drawable.ic_circle_black));
            } else {
                checkBox.setBackground(getDrawable(R.drawable.ic_cross_black));
            }
        checkBox.setFocusable(false);
        }
    }
}
