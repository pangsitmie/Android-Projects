package com.example.e_tuku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView productsRecView;
    private ProductsRecViewAdapter adapter;
    private CardView checkoutCard;
    private TextView checkoutPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


        productsRecView = findViewById(R.id.productsRecView);
        checkoutCard = findViewById(R.id.checkoutCard);
        checkoutPrice = findViewById(R.id.checkoutPrice);

        adapter = new ProductsRecViewAdapter(this,checkoutPrice);

        productsRecView.setAdapter(adapter);
        productsRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ProductData> products = new ArrayList<>();
        products.add(new ProductData("Beras","Beras ini diproduksi secara organik sehingga terbebas dari bahan kimia dan pestisida","https://st.depositphotos.com/1801791/3663/i/600/depositphotos_36635085-stock-photo-polished-long-rice-basmati-in.jpg",6000,0));
        products.add(new ProductData("Gula Pasir","Gula putih nol kalori serta memiliki tekstur kristal yang sangat halus dan mudah larut, bahkan pada air dingin","https://i.dlpng.com/static/png/6960500_preview.png",10000,0));
        products.add(new ProductData("Minyak Goreng","Produk ini terbuat dari biji kelapa sawit pilihan yang berkualitas baik","https://www.hdenergi.com/wp-content/uploads/2018/12/oil-hdenergi-801x1030.png",12000,0));
        products.add(new ProductData("Telur Ayam","Telur dari ayam yang tidak pernah diberi tambahan bahan kimia sehingga 100% natural","https://images.tokopedia.net/img/cache/700/product-1/2020/6/4/8116801/8116801_f3e706d7-ace0-45da-8eeb-e04c0271074c_441_441.jpg",24700,0));
        products.add(new ProductData("Garam","Garam premium dengan hanya 40% natrium, sehingga komposisi kalium dan iodium menjadi lebih tinggi.","https://pngimg.com/uploads/salt/salt_PNG98684.png",600,0));
        products.add(new ProductData("Jagung","Ditanam dari biji pilihan terbaik kami, dan diproses dengan tenaga profesional","https://wasit.id/wallpaper/wallpaper/20220317/Unduh-gambar-buah-jagung-kupas-Gratis-Wallpaper-jual-jagung-manis-kupas-2-buah-250-gr-buah-preview.jpg",3600,0));
        products.add(new ProductData("Daging Ayam","Dagging fresh diolah pada hari pemesanan, 100% tanpa bahan pengawet dan kimia,","https://www.pasarayairsyad.com.my/wp-content/uploads/2020/02/AYAM-SEGAR.jpg",24750,0));

        adapter.setProducts(products);


    }



}