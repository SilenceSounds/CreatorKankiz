package com.example.ccreator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Creator extends AppCompatActivity {

    private DatabaseReference DR;

    Button typeB, sizeB, colorB, motiveB;
    TextView typeT, sizeT, colorT, motiveT;

    CharSequence[] type = {"Lego", "Crochet", "Plastico", "Algodon", "Puzzle"};
    CharSequence[] size = {"Llavero", "Chico", "Mediano", "Grande", "Jumbo"};
    CharSequence[] color = {"Negro", "Blanco", "Verde", "Rojo", "Amarillo", "Azul", "Cafe", "Rosa"};
    CharSequence[] motivo = {"Cumpleaños", "Personal", "Intercambio", "Regalo Casual", "Festividad"};

    boolean[] selectedType = {false, false, false, false, false};
    boolean[] selectedSize = {false, false, false, false, false};
    boolean[] selectedColor = {false, false, false, false, false, false, false, false};
    boolean[] selectedMotive = {false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);

        DR = FirebaseDatabase.getInstance().getReference("Juguetes");

        //Botones
        typeB = findViewById(R.id.materialButton);
        sizeB = findViewById(R.id.sizeButton);
        colorB = findViewById(R.id.colorButton);
        motiveB = findViewById(R.id.razonButton);

        //TextViews
        typeT = findViewById(R.id.materialText);
        sizeT = findViewById(R.id.sizeText);
        colorT = findViewById(R.id.colorText);
        motiveT = findViewById(R.id.razonText);

        typeT.setText(itemsToString(selectedType, type));
        sizeT.setText(itemsToString(selectedSize, size));
        colorT.setText(itemsToString(selectedColor, color));
        motiveT.setText(itemsToString(selectedMotive, motivo));

        //Tipo
        typeB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Creator.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Tipo de juguete");
                alertDialogBuilder.setMultiChoiceItems(type, selectedType, new DialogInterface.OnMultiChoiceClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedType[i] = b;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        typeT.setText(itemsToString(selectedType, type));
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();

            }
        });

        //Motivo
        motiveB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Creator.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Motivo de compra");
                alertDialogBuilder.setMultiChoiceItems(motivo, selectedMotive, new DialogInterface.OnMultiChoiceClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedMotive[i] = b;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        motiveT.setText(itemsToString(selectedMotive, motivo));
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();

            }
        });

        //Color
        colorB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Creator.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Color del juguete");
                alertDialogBuilder.setMultiChoiceItems(color, selectedColor, new DialogInterface.OnMultiChoiceClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedColor[i] = b;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        colorT.setText(itemsToString(selectedColor, color));
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();

            }
        });

        //Size
        sizeB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Creator.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Tamaño");
                alertDialogBuilder.setMultiChoiceItems(size, selectedSize, new DialogInterface.OnMultiChoiceClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedSize[i] = b;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sizeT.setText(itemsToString(selectedSize, size));
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();

            }
        });
    }

    private String itemsToString(boolean[] array, CharSequence[] charArray){
        String text = "";
        for (int i = 0; i<array.length; i++){
            if (array[i]){
                text = text + charArray[i] + " ";
            }
        }
        return text.trim();
    }


    public void Random(View view) {
        Random random = new Random();
        int rType, rSize, rColor, rMotive;
        rType = random.nextInt(6-1) + 1;
        rSize = random.nextInt(6-1) + 1;
        rColor = random.nextInt(9-1) + 1;
        rMotive = random.nextInt(6-1) + 1;

        selectedType[rType-1] = true;
        selectedSize[rSize-1] = true;
        selectedColor[rColor-1] = true;
        selectedMotive[rMotive-1] = true;

    }

    public void Confirmar(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Creator.this);
        builder.setCancelable(true);
        System.out.println("Holaaaaaaaa2a");
        builder.setTitle("Confirmar orden");
        builder.setMessage("¿Esta seguro de crear un KanFriend con estas caracteristicas");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("Holaaaaaaaaa");
                        String Color = colorT.getText().toString();
                        String Size = sizeT.getText().toString();
                        String Material = typeT.getText().toString();
                        String Motive = motiveT.getText().toString();

                        List<String> Data = new ArrayList<>();

                        Data.add(Color);
                        Data.add(Size);
                        Data.add(Material);
                        Data.add(Motive);

                        String[] Datos = {Color, Size, Material, Motive};

                        String id = DR.push().getKey();
                        DR.child("Juguetes").child(id).setValue(Data);
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();




    }
}