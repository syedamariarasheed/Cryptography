package com.example.user.ns;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PolyAlphabetic extends Fragment implements AdapterView.OnItemSelectedListener {
    EditText plaintext; Spinner sp1,sp2,sp3;
    TextView textView;
    int[] Morder=new int[3];
    Button encryptButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.polyalphabetic,container,false);
        plaintext=v.findViewById(R.id.plaintext);
        encryptButton=v.findViewById(R.id.Encrypt);
        textView=v.findViewById(R.id.text);
        sp1=v.findViewById(R.id.spinner1);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array._array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Morder[0]=1;
                    Morder[1]=2;
                    Morder[2]=3;
                }else if(i == 1){
                    Morder[0]=1;
                    Morder[1]=3;
                    Morder[2]=2;}
                else if(i == 2){
                    Morder[0]=2;
                    Morder[1]=1;
                    Morder[2]=3;
                }
                else if(i == 3){
                    Morder[0]=2;
                    Morder[1]=3;
                    Morder[2]=1;
                }
                else if(i == 4){
                    Morder[0]=3;
                    Morder[1]=2;
                    Morder[2]=1;
                }
                else if(i == 5){
                    Morder[0]=3;
                    Morder[1]=1;
                    Morder[2]=2;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char[][] array=new char[26][4];
                array[0][0]='A';
                array[0][1]='A';
                array[0][2]='Q';
                array[0][3]='X';
                array[1][0]='B';
                array[1][1]='S';
                array[1][2]='A';
                array[1][3]='C';
                array[2][0]='C';
                array[2][1]='D';
                array[2][2]='Z';
                array[2][3]='V';
                array[3][0]='C';
                array[3][1]='D';
                array[3][2]='Z';
                array[3][3]='V';
                array[4][0]='C';
                array[4][1]='D';
                array[4][2]='Z';
                array[4][3]='V';
                array[5][0]='C';
                array[5][1]='D';
                array[5][2]='Z';
                array[5][3]='V';
                array[6][0]='C';
                array[6][1]='D';
                array[6][2]='Z';
                array[6][3]='V';
                array[7][0]='C';
                array[7][1]='D';
                array[7][2]='Z';
                array[7][3]='V';
                array[8][0]='C';
                array[8][1]='D';
                array[8][2]='Z';
                array[8][3]='V';
                array[9][0]='C';
                array[9][1]='D';
                array[9][2]='Z';
                array[9][3]='V';
                array[10][0]='C';
                array[10][1]='D';
                array[10][2]='Z';
                array[10][3]='V';
                array[11][0]='C';
                array[11][1]='D';
                array[11][2]='Z';
                array[11][3]='V';
                array[12][0]='C';
                array[12][1]='D';
                array[12][2]='Z';
                array[12][3]='V';
                array[13][0]='C';
                array[13][1]='D';
                array[13][2]='Z';
                array[13][3]='V';
                array[14][0]='C';
                array[14][1]='D';
                array[14][2]='Z';
                array[14][3]='V';
                array[15][0]='C';
                array[15][1]='D';
                array[15][2]='Z';
                array[15][3]='V';
                array[16][0]='C';
                array[16][1]='D';
                array[16][2]='Z';
                array[16][3]='V';
                array[17][0]='C';
                array[17][1]='D';
                array[17][2]='Z';
                array[17][3]='V';
                array[18][0]='C';
                array[18][1]='D';
                array[18][2]='Z';
                array[18][3]='V';
                array[19][0]='C';
                array[19][1]='D';
                array[19][2]='Z';
                array[19][3]='V';
                array[20][0]='C';
                array[20][1]='D';
                array[20][2]='Z';
                array[20][3]='V';
                array[21][0]='C';
                array[21][1]='D';
                array[21][2]='Z';
                array[21][3]='V';
                array[22][0]='C';
                array[22][1]='D';
                array[22][2]='Z';
                array[22][3]='V';
                array[23][0]='C';
                array[23][1]='D';
                array[23][2]='Z';
                array[23][3]='V';
                array[24][0]='C';
                array[24][1]='D';
                array[24][2]='Z';
                array[24][3]='V';
                array[25][0]='C';
                array[25][1]='D';
                array[25][2]='Z';
                array[25][3]='V';


                int k=0;String s = "";
                char[] plainText=plaintext.getText().toString().trim().toCharArray();
                for (int i=0;i<plainText.length;i++) {

                    for (int j = 0; j < array.length; j++) {
                    if(k == 3){
                        k=0;
                    }
                       else if (plainText[i] == array[j][0] ) {
                            s+=array[j][Morder[k]];
                            k++;
                    }
                }
                textView.setText(s);
            }}
        });

        return v;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
