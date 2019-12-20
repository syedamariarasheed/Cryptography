package com.example.user.ns;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CeaserCipher extends Fragment {
    EditText plaintext,key;
    Button encryptButton,decryptButton;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View v=inflater.inflate(R.layout.ceasercipher,container,false);
     plaintext=v.findViewById(R.id.plaintext);
        key=v.findViewById(R.id.key);
        decryptButton=v.findViewById(R.id.Decrypt);
     encryptButton=v.findViewById(R.id.Encrypt);
     textView=v.findViewById(R.id.text);
     encryptButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(key.getText().toString().isEmpty()){

                 textView.setTextColor(Color.rgb(200,0,0));
                 textView.setText("Key is missing");
             }
             else {
                 textView.setTextColor(Color.rgb(0,200,0));
             int KEY=Integer.parseInt(key.getText().toString());
             Editable msg = plaintext.getText();
             String s = "";
             int len = msg.length();
             for (int x = 0; x < len; x++) {
                 if (Character.isWhitespace(msg.charAt(x))) {
                     //s += " ";
                     continue;
                 }
                 char c = (char) (msg.charAt(x) + KEY);
                 if (c > 'z' || (c > 'Z' && c < 'b'))
                 {
                     c -= 26;
                 }

                 s += c;
             }
             textView.setText(s);
         }}
     });
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(key.getText().toString().isEmpty()){

                    textView.setTextColor(Color.rgb(200,0,0));
                    textView.setText("Key is missing");
                }
                else {
                    textView.setTextColor(Color.rgb(0,0,200));
                int KEY=Integer.parseInt(key.getText().toString());
                String msg = textView.getText().toString();
                String s = "";
                int len = msg.length();
                for (int x = 0; x < len; x++) {
                    if (Character.isWhitespace(msg.charAt(x))) {
                      //  s += " ";
                        continue;
                    }
                    char c = (char) (msg.charAt(x) - KEY);
                    if (c > 'z' || (c > 'Z' && c < 'a'))
                    {
                        c += 26;
                    }

                    s += c;
                }
                textView.setText(s);
            }}
        });
        return v;
    }

//    private void ceaserCipher() {
//       // int shift = 3;
//
//
//    }
}
