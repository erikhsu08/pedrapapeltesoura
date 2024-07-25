package com.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionaPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionaPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionaTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        //Referenciando ids da activity_main.xml
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        //Gera número aleatório como "escolha" do app
        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[num];

        //Switch para mudar a imagem de acordo com a opção escolhida pelo app
        switch(opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //Ver quem é o vencedor
        if (
                (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura")) ||
                        (opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra"))
        ){//App ganha
            textResultado.setText("Você perdeu :(");
        }else if(
                (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura")) ||
                        (opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                        (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra"))
        ){//Usuário ganha
            textResultado.setText("Você ganhou! :)");
        }else{//Empate
            textResultado.setText("Empate!");
        }
    }
}