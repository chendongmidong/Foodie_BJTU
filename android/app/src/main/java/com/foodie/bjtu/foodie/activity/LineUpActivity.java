package com.foodie.bjtu.foodie.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;

import java.nio.charset.Charset;

/**
 * Created by zhao on 2016/5/15.
 */
public class LineUpActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback {
    NfcAdapter mNfcAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_up_activity);
        // Check for available NFC Adapter
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(this, this);
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        String text = ("Beam me up, Android!\n\n" +
                "Beam Time: " + System.currentTimeMillis());

        SharedPreferences mSharedPreferences = getSharedPreferences("userInfo",MODE_PRIVATE);
        String userInfo = mSharedPreferences.getString("userId","-1") + ","+mSharedPreferences.getString("phoneNum","0");

        NdefMessage msg = new NdefMessage(
                new NdefRecord[] { NdefRecord.createMime(
                        "application/vnd.com.example.android.beam",userInfo.getBytes(Charset.forName("US-ASCII")))
                        /**
                         * The Android Application Record (AAR) is commented out. When a device
                         * receives a push with an AAR in it, the application specified in the AAR
                         * is guaranteed to run. The AAR overrides the tag dispatch system.
                         * You can add it back in to guarantee that this
                         * activity starts when receiving a beamed message. For now, this code
                         * uses the tag dispatch system.
                        */
                        //,NdefRecord.createApplicationRecord("com.example.android.beam")
                });
        return msg;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        // Check to see that the Activity started due to an Android Beam
//        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
//            processIntent(getIntent());
//        }
//    }

//    @Override
//    public void onNewIntent(Intent intent) {
//        // onResume gets called after this to handle the intent
//        setIntent(intent);
//    }

    /**
     * Parses the NDEF Message from the intent and prints to the TextView
     */
//    void processIntent(Intent intent) {
//        textView = (TextView) findViewById(R.id.line_up_hint);
//        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
//                NfcAdapter.EXTRA_NDEF_MESSAGES);
//        // only one message sent during the beam
//        NdefMessage msg = (NdefMessage) rawMsgs[0];
//        // record 0 contains the MIME type, record 1 is the AAR, if present
//        textView.setText(new String(msg.getRecords()[0].getPayload()));
//    }
}
