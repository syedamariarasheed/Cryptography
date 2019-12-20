package com.example.user.ns;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Playfair extends Fragment {
    EditText plainText,Key;
    TextView CipherText,Matrix;
    Button Encrypt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.playfair,container,false);
        plainText=v.findViewById(R.id.plaintext);
        Key=v.findViewById(R.id.key);
        Matrix=v.findViewById(R.id.Matrix);
        CipherText=v.findViewById(R.id.CipherText);
        Encrypt=v.findViewById(R.id.Encrypt);
        Encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Matrix.setText("");
                String k=Key.getText().toString();
                String KeyWord = new String();
                String Key = new String();
                char matrix_arr[][] = new char[5][5];
                String K_adjust = new String();
                boolean flag = false;
                K_adjust = K_adjust + k.charAt(0);
                for (int i = 1; i < k.length(); i++) {
                    for (int j = 0; j < K_adjust.length(); j++) {
                        if (k.charAt(i) == K_adjust.charAt(j)) {
                            flag = true;
                        }
                    }
                    if (flag == false)
                        K_adjust = K_adjust + k.charAt(i);
                    flag = false;
                }
                KeyWord = K_adjust;

               //Key generate
                    boolean flag2 = true;
                    char current;
                    Key = KeyWord;
                    for (int i = 0; i < 26; i++)
                    {
                        current = (char) (i + 97);
                        if (current == 'j')
                            continue;
                        for (int j = 0; j < KeyWord.length(); j++)
                        {
                            if (current == KeyWord.charAt(j))
                            {
                                flag2 = false;
                                break;
                            }
                        }
                        if (flag2)
                            Key = Key + current;
                        flag = true;
                    }
                    //Showing as a Matrix
                int counter = 0;
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        matrix_arr[i][j] = Key.charAt(counter);
                        Matrix.append(matrix_arr[i][j] + "  ");
                        counter++;
                    }
                    Matrix.append("\n");
                }

//Format
            String old_text=plainText.getText().toString().trim();
                int i = 0;
                int len = 0;
                String text = new String();
                len = old_text.length();
                for (int tmp = 0; tmp < len; tmp++)
                {
                    if (old_text.charAt(tmp) == 'j')
                    {
                        text = text + 'i';
                    }
                    else
                        text = text + old_text.charAt(tmp);
                }
                len = text.length();
                for (i = 0; i < len; i = i + 2)
                {
                    if (text.charAt(i + 1) == text.charAt(i))
                    {
                        text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
                    }
                }
//Divide TWO
                String Original = text;
                int size = Original.length();
                if (size % 2 != 0)
                {
                    size++;
                    Original = Original + 'x';
                }
                String x[] = new String[size / 2];
                int counter1 = 0;
                for (int m = 0; m < size / 2; m++)
                {
                    x[m] = Original.substring(counter1, counter1 + 2);
                    counter1 = counter1 + 2;
                }
//Encrypt
                String src_arr[] = x;
                char one;
                char two;
                String Code = new String();
                int part1[] = new int[2];
                int part2[] = new int[2];
                for (int l = 0; l < src_arr.length; l++)
                {
                    one = src_arr[l].charAt(0);
                    two = src_arr[l].charAt(1);

                    //Get Dimension

                    int[] KEYY = new int[2];
                    if (one == 'j')
                        one = 'i';
                    for (int M = 0; M < 5; M++)
                    {
                        for (int j = 0; j < 5; j++)
                        {
                            if (matrix_arr[M][j] == one)
                            {
                                KEYY[0] = M;
                                KEYY[1] = j;
                                break;
                            }
                        }
                    }
                    part1 = KEYY;
                    int[] KEYY2 = new int[2];
                    if (two == 'j')
                        two = 'i';
                    for (int N = 0; N < 5; N++)
                    {
                        for (int j = 0; j < 5; j++)
                        {
                            if (matrix_arr[N][j] == two)
                            {
                                KEYY2[0] = N;
                                KEYY2[1] = j;
                                break;
                            }
                        }
                    }
                    part2 = KEYY2;
                    if (part1[0] == part2[0])
                    {
                        if (part1[1] < 4)
                            part1[1]++;
                        else
                            part1[1] = 0;
                        if (part2[1] < 4)
                            part2[1]++;
                        else
                            part2[1] = 0;
                    }
                    else if (part1[1] == part2[1])
                    {
                        if (part1[0] < 4)
                            part1[0]++;
                        else
                            part1[0] = 0;
                        if (part2[0] < 4)
                            part2[0]++;
                        else
                            part2[0] = 0;
                    }
                    else
                    {
                        int temp = part1[1];
                        part1[1] = part2[1];
                        part2[1] = temp;
                    }
                    Code = Code + matrix_arr[part1[0]][part1[1]]
                            + matrix_arr[part2[0]][part2[1]];
                }
              //
                CipherText.append(Code);

            }
        });
        return v;
    }
}
