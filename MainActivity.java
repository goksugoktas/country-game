package com.example.recepgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Integer hp;
    private Integer score;
    private Integer questionScore;

    private String answer;

    private List<Integer> imageResourceIds; // Integer tipinde kaynak ID'lerini tutacak liste

    private List<Integer> kullanilmisIndisler;
    private List<String> imgNames;
    private ImageView imageView;
    private Integer indis;
    private Map<String, List<String>> imgMap;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.img);
        hp = 3;
        counter = 4;
        score = 0;
        questionScore = 100;

        kullanilmisIndisler = new ArrayList<>();

        Button ok_btn = findViewById(R.id.btn1);
        Button cheat1_btn = findViewById(R.id.btn2);
        Button cheat2_btn = findViewById(R.id.btn3);
        Button cheat3_btn = findViewById(R.id.btn4);
        Button cheat4_btn = findViewById(R.id.btn5);
        EditText editText = findViewById(R.id.textinp);


        // drawable içindeki resim adlarını liste yerine, kaynak ID'leriyle tutmak için değiştik
        imageResourceIds = new ArrayList<>();
        imageResourceIds.add(R.drawable.arjantin);
        imageResourceIds.add(R.drawable.avustralya);
        imageResourceIds.add(R.drawable.guney_afrika);
        imageResourceIds.add(R.drawable.hindistan);
        imageResourceIds.add(R.drawable.ispanya);
        imageResourceIds.add(R.drawable.japonya);
        imageResourceIds.add(R.drawable.kanada);
        imageResourceIds.add(R.drawable.meksika);
        imageResourceIds.add(R.drawable.norvec);
        imageResourceIds.add(R.drawable.vietnam);

        //sırasıyla kabul edilen cevaplar
        imgNames = new ArrayList<>();
        imgNames.add("Arjantin");
        imgNames.add("Avustralya");
        imgNames.add("Güney afrika");
        imgNames.add("Hindistan");
        imgNames.add("Ispanya");
        imgNames.add("Japonya");
        imgNames.add("Kanada");
        imgNames.add("Meksika");
        imgNames.add("Norveç");
        imgNames.add("Vietnam");


        //sırasıyla seçili ülkelerin ipuçları
        imgMap = new HashMap<>();

        // Japonya
        imgMap.computeIfAbsent("Japonya", k -> new ArrayList<>()).add("Başkenti Tokyo'dur.");
        imgMap.computeIfAbsent("Japonya", k -> new ArrayList<>()).add("Bayrağında bir kırmızı daire bulunmaktadır.");
        imgMap.computeIfAbsent("Japonya", k -> new ArrayList<>()).add("Geleneksel kıyafeti 'kimono' olarak bilinir.");
        imgMap.computeIfAbsent("Japonya", k -> new ArrayList<>()).add("Sushi, ramen ve tempura gibi popüler yemekleri vardır.");
        imgMap.computeIfAbsent("Japonya", k -> new ArrayList<>()).add("Ünlü Fuji Dağı bu ülkede yer almaktadır.");


        imgMap.computeIfAbsent("Meksika", k -> new ArrayList<>()).add("Başkenti Mexico City'dir.");
        imgMap.computeIfAbsent("Meksika", k -> new ArrayList<>()).add("Bayrağında bir kartal ve yılan yer almaktadır.");
        imgMap.computeIfAbsent("Meksika", k -> new ArrayList<>()).add("Geleneksel dansları arasında mariachi müziği eşliğinde yapılan 'Jarabe Tapatío' bulunur.");
        imgMap.computeIfAbsent("Meksika", k -> new ArrayList<>()).add("Meksika mutfağı taco, guacamole ve enchilada gibi lezzetleri içerir.");
        imgMap.computeIfAbsent("Meksika", k -> new ArrayList<>()).add("Ünlü antik Maya piramitleri Meksika'da bulunmaktadır.");


        imgMap.computeIfAbsent("Güney Afrika", k -> new ArrayList<>()).add("Başkenti Pretoria'dır.");
        imgMap.computeIfAbsent("Güney Afrika", k -> new ArrayList<>()).add("Bayrağında altı renk bulunur.");
        imgMap.computeIfAbsent("Güney Afrika", k -> new ArrayList<>()).add("Ünlü lider Nelson Mandela bu ülkeden gelmektedir.");
        imgMap.computeIfAbsent("Güney Afrika", k -> new ArrayList<>()).add("Safarilerle ünlüdür ve 'Büyük Beş' (Aslan, Fil, Leopard, Bufalo, Gergedan) burada bulunur.");
        imgMap.computeIfAbsent("Güney Afrika", k -> new ArrayList<>()).add("Johannesburg ve Cape Town gibi büyük şehirlere sahiptir.");


        imgMap.computeIfAbsent("Kanada", k -> new ArrayList<>()).add("Başkenti Ottawa'dır.");
        imgMap.computeIfAbsent("Kanada", k -> new ArrayList<>()).add("Bayrağında bir akçaağaç yaprağı bulunur.");
        imgMap.computeIfAbsent("Kanada", k -> new ArrayList<>()).add("Niagara Şelalesi ülkede yer alır.");
        imgMap.computeIfAbsent("Kanada", k -> new ArrayList<>()).add("Kutup ayıları ve grizzly ayıları gibi vahşi yaşam barındırır.");
        imgMap.computeIfAbsent("Kanada", k -> new ArrayList<>()).add("İngilizce ve Fransızca resmi dilleridir.");


        imgMap.computeIfAbsent("Hindistan", k -> new ArrayList<>()).add("Başkenti Yeni Delhi'dir.");
        imgMap.computeIfAbsent("Hindistan", k -> new ArrayList<>()).add("Bayrağında bir tekerlek ve renkli çizgiler bulunur.");
        imgMap.computeIfAbsent("Hindistan", k -> new ArrayList<>()).add("Ganges Nehri kutsal kabul edilir.");
        imgMap.computeIfAbsent("Hindistan", k -> new ArrayList<>()).add("Taj Mahal, ünlü bir aşk hikayesini temsil eden muazzam bir anıttır.");
        imgMap.computeIfAbsent("Hindistan", k -> new ArrayList<>()).add("Hint mutfağı baharatlı yemekleriyle ünlüdür.");


        imgMap.computeIfAbsent("Avustralya", k -> new ArrayList<>()).add("Başkenti Canberra'dir.");
        imgMap.computeIfAbsent("Avustralya", k -> new ArrayList<>()).add("Bayrağında yedi uçlu bir yıldız ve güney haç takımyıldızı yer alır.");
        imgMap.computeIfAbsent("Avustralya", k -> new ArrayList<>()).add("Büyük Mercan Resifi dünyanın en büyük mercan resifidir ve Avustralya'nın kuzeydoğusunda bulunur.");
        imgMap.computeIfAbsent("Avustralya", k -> new ArrayList<>()).add("Ülkenin simgelerinden biri olan kangurular ve koalalar burada yaşar.");
        imgMap.computeIfAbsent("Avustralya", k -> new ArrayList<>()).add("Opera Evi, Sidney şehrinde ünlü bir simgedir.");

        // Arjantin
        imgMap.computeIfAbsent("Arjantin", k -> new ArrayList<>()).add("Başkenti Buenos Aires'tir.");
        imgMap.computeIfAbsent("Arjantin", k -> new ArrayList<>()).add("Bayrağında bir güneş yükselirken görüntüsü bulunur.");
        imgMap.computeIfAbsent("Arjantin", k -> new ArrayList<>()).add("Tango dansı bu ülkede ortaya çıkmıştır.");
        imgMap.computeIfAbsent("Arjantin", k -> new ArrayList<>()).add("And Dağları ve Pampas bozkırları Arjantin'in doğal güzellikleridir.");
        imgMap.computeIfAbsent("Arjantin", k -> new ArrayList<>()).add("Ülke futboluyla ünlüdür ve Diego Maradona gibi efsanevi futbolcular yetiştirmiştir.");


        imgMap.computeIfAbsent("Norveç", k -> new ArrayList<>()).add("Başkenti Oslo'dur.");
        imgMap.computeIfAbsent("Norveç", k -> new ArrayList<>()).add("Bayrağında kırmızı, beyaz ve mavi renkler bulunur.");
        imgMap.computeIfAbsent("Norveç", k -> new ArrayList<>()).add("Fiyortları ve dağlarıyla ünlüdür.");
        imgMap.computeIfAbsent("Norveç", k -> new ArrayList<>()).add("Viking tarihine ev sahipliği yapmıştır.");
        imgMap.computeIfAbsent("Norveç", k -> new ArrayList<>()).add("Aurora Borealis (Kuzey Işıkları), kuzey bölgelerinde görülebilir.");


        imgMap.computeIfAbsent("Vietnam", k -> new ArrayList<>()).add("Başkenti Hanoi'dir.");
        imgMap.computeIfAbsent("Vietnam", k -> new ArrayList<>()).add("Bayrağında yıldız ve kırmızı arka plan bulunur.");
        imgMap.computeIfAbsent("Vietnam", k -> new ArrayList<>()).add("Mekong Deltası ve Ha Long Körfezi gibi doğal güzelliklere sahiptir.");
        imgMap.computeIfAbsent("Vietnam", k -> new ArrayList<>()).add("Pho, ünlü bir Vietnamlı noodle çorbasıdır.");
        imgMap.computeIfAbsent("Vietnam", k -> new ArrayList<>()).add("Savaşa dair tarihi önem taşıyan yerlere ev sahipliği yapmıştır.");


        imgMap.computeIfAbsent("Ispanya", k -> new ArrayList<>()).add("Başkenti Madrid'dir.");
        imgMap.computeIfAbsent("Ispanya", k -> new ArrayList<>()).add("Bayrağında kırmızı ve altın sarısı renkler bulunur.");
        imgMap.computeIfAbsent("Ispanya", k -> new ArrayList<>()).add("Flamenco dansı ve boğa güreşleri İspanya kültürünün bir parçasıdır.");
        imgMap.computeIfAbsent("Ispanya", k -> new ArrayList<>()).add("Sagrada Familia, Antoni Gaudí'nin tasarladığı ünlü bir katedraldir.");
        imgMap.computeIfAbsent("Ispanya", k -> new ArrayList<>()).add("İspanyol mutfağı paella, tapas ve sangria gibi lezzetleri içerir.");


        refresh_status();
        showRandomImage();
        //getRandomImage();

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = editText.getText().toString();
                if (hp == 0)
                {
                    cheat1_btn.setText("İpucunu Göster");
                    cheat2_btn.setText("İpucunu Göster");
                    cheat3_btn.setText("İpucunu Göster");
                    cheat4_btn.setText("İpucunu Göster");
                    ok_btn.setText("Onayla");
                    hp = 3;
                    counter = 4;
                    score = 0;
                    questionScore = 100;
                    refresh_status();
                    kullanilmisIndisler.clear();
                    showRandomImage();
                }
                else if (answer.equals(imgNames.get(indis)))
                {
                    score += questionScore;
                    questionScore = 100;
                    counter = 4;
                    refresh_status();
                    if (imageResourceIds.size() == kullanilmisIndisler.size())
                    {
                        ok_btn.setText("Game Over!\nYour Score: " + score);
                        hp = 0;
                    }
                    else {
                        showRandomImage();
                        cheat1_btn.setText("İpucunu Göster");
                        cheat2_btn.setText("İpucunu Göster");
                        cheat3_btn.setText("İpucunu Göster");
                        cheat4_btn.setText("İpucunu Göster");
                        Toast.makeText(MainActivity.this, "Doğru Cevap!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    hp -= 1;
                    refresh_status();
                    if (hp == 0)
                    {
                        ok_btn.setText("Game Over!\nYour Score: " + score);
                    }
                    Toast.makeText(MainActivity.this, "Hatalı Cevap!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cheat1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    cheat1_btn.setText(imgMap.get(imgNames.get(indis)).get(0));
                    questionScore -= 10;
                    counter--;
                    refresh_status();
                }
            }
        });

        cheat2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    cheat2_btn.setText(imgMap.get(imgNames.get(indis)).get(1));
                    questionScore -= 20;
                    counter--;
                    refresh_status();
                }
            }
        });

        cheat3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    cheat3_btn.setText(imgMap.get(imgNames.get(indis)).get(2));
                    questionScore -= 25;
                    counter--;
                    refresh_status();
                }
            }
        });

        cheat4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    cheat4_btn.setText(imgMap.get(imgNames.get(indis)).get(3));
                    questionScore -= 30;
                    counter--;
                    refresh_status();
                }
            }
        });


    }

    protected void refresh_status()
    {
        TextView hpp = findViewById(R.id.can);
        TextView scoree = findViewById(R.id.puan);
        TextView question_scoree = findViewById(R.id.sorupuani);

        hpp.setText(Integer.toString(hp));
        scoree.setText(Integer.toString(score));
        question_scoree.setText(Integer.toString(questionScore));
    }

    private void showRandomImage() {
        int randomImageResourceId = getRandomImage();
        imageView.getLayoutParams().width = 500;
        imageView.getLayoutParams().height = 500;
        imageView.setImageResource(randomImageResourceId);
    }

    private int getRandomImage() {
        Random random = new Random();
        int randomIndex = random.nextInt(imageResourceIds.size());
        while (kullanilmisIndisler.contains(randomIndex))
            randomIndex = random.nextInt(imageResourceIds.size());
        indis = randomIndex;
        kullanilmisIndisler.add(indis);
        return imageResourceIds.get(randomIndex);
    }
}