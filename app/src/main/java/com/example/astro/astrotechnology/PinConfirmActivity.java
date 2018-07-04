package com.example.astro.astrotechnology;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;

/**
 * Created by vitinhHienAnh on 08-05-18.
 */

public class PinConfirmActivity extends AppCompatActivity {
    PinLockView mPinLockView;
    TextView tvPin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_pin_code);
        mPinLockView = (PinLockView) findViewById(R.id.pin_lock_view);
        tvPin = (TextView) findViewById(R.id.tvPin);
        mPinLockView.setPinLockListener(mPinLockListener);
        super.onCreate(savedInstanceState);
    }

    private PinLockListener mPinLockListener = new PinLockListener() {
        public static final String TAG = "PIN_Code_confirm " ;

        @Override
        public void onComplete(String pin) {
            Log.d(TAG, "Pin complete: " + pin);
            tvPin.setText(pin);
        }

        @Override
        public void onEmpty() {
            Log.d(TAG, "Pin empty");
            tvPin.setText("");
        }

        @Override
        public void onPinChange(int pinLength, String intermediatePin) {
            Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
            tvPin.setText(intermediatePin);
        }
    };
}
