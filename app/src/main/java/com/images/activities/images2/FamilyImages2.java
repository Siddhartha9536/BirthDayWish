package com.images.activities.images2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.images.activities.MultiItemActivity;
import com.images.activities.ShowImageActivity;
import com.images.adapters.AdapterFamilyImages2;
import com.images.adapters.AdapterHomeCategory;
import com.images.apiurl.ApiUrl;
import com.images.common.Utility;
import com.images.models.homeitems.HomeItems;
import com.images.models.slider.SliderItem;
import com.images.widgets.SpacingItemDecoration;
import com.restaurant.birthdaywish.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FamilyImages2 extends AppCompatActivity {
    Context context;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<SliderItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_images2);
        context = FamilyImages2.this;
        ButterKnife.bind(this);
        Animatoo.animateSplit(context);



        initRecycler();
    }
    public void initRecycler(){
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Utility.dpToPx(this, 5), true));
        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemViewCacheSize(20);
//        recyclerView.setDrawingCacheEnabled(true);
//        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);



        initImages();

        //set data and list adapter
        AdapterFamilyImages2 mAdapter = new AdapterFamilyImages2(this, items);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AdapterFamilyImages2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, SliderItem obj, int position) {
                Intent n = new Intent(context , ShowImageActivity.class);
                n.putExtra("image_url" , ApiUrl.BASE_URL+obj.getUrl());
                context.startActivity(n);
                Animatoo.animateSplit(context);
            }
        });
    }


    private void initImages(){
        items = new ArrayList<>();

        SliderItem s1 = new SliderItem("1az4oJi0FQJvHRpnsYKIOevfwD9sAFyNo");
//        SliderItem s2 = new SliderItem("1bNK0Dc_u_kDOPoO_1yxh3NiX8lL2qOXm");
//        SliderItem s3 = new SliderItem("1az4oJi0FQJvHRpnsYKIOevfwD9sAFyNo");
//        SliderItem s4 = new SliderItem("1bNK0Dc_u_kDOPoO_1yxh3NiX8lL2qOXm");
        SliderItem s5 = new SliderItem("1bNK0Dc_u_kDOPoO_1yxh3NiX8lL2qOXm");
        SliderItem s6 = new SliderItem("15h8OCi8mRPw9b_qV6rghOkqe0qDxlqSZ");
        SliderItem s7 = new SliderItem("16DesvrTzQfCrcjh6Hue37FSkEdwI_ftm");
        SliderItem s8 = new SliderItem("15hV2y6axDDVaVWERk9FTuD0OszyMCER8");
        SliderItem s9 = new SliderItem("167M9kN2fHEHf5kfUKC7RvyFr4z0q3Dug");
        SliderItem s10 = new SliderItem("15aX8JWg_Ty7yqcqEKJ_bjLFfVSzYP5CQ");

        items.add(s1);
//        items.add(s2);
//        items.add(s3);
//        items.add(s4);
        items.add(s5);
        items.add(s6);
        items.add(s7);
        items.add(s8);
        items.add(s9);
        items.add(s10);

        SliderItem s11 = new SliderItem("1f7VT0er0a_K_ZfWeIaGT3yhxOMNLPseL");
        SliderItem s12 = new SliderItem("172468iGIQkatKSzrtNoCXpQDOfbMLvOl");
        SliderItem s13 = new SliderItem("1f70XWJP5icUIdSnuBq9HNKTw9kTa2-0E");
        SliderItem s14 = new SliderItem("1ekgL4TxgfFsek_4Obq2MYLZEiN3Of6hB");
        SliderItem s15 = new SliderItem("1492fNjZfknUvAbT1Zo-6PYyMV39WBjh0");
        SliderItem s16 = new SliderItem("10c-hSojhq0juYDNv9eNHKYmFaCSWJHp0");
        SliderItem s17 = new SliderItem("10Zq22Q7Wzlc2f32PYYln-5h93nqKOQAd");
        SliderItem s18 = new SliderItem("10YnZ0n7hsdDbMVB4kf0Tpn3lqiU1mRIE");
        SliderItem s19 = new SliderItem("10YV8NXWz1BDn3CusozHDyeG4j5SULmEB");
        SliderItem s20 = new SliderItem("10OKyRJes7g04ukkbHSnIanWejYVUVfkY");

        items.add(s11);
        items.add(s12);
        items.add(s13);
        items.add(s14);
        items.add(s15);
        items.add(s16);
        items.add(s17);
        items.add(s18);
        items.add(s19);
        items.add(s20);


        SliderItem s21 = new SliderItem("10O0beNOEC_IFjJAK6UMTNhDijljusN2g");
        SliderItem s22 = new SliderItem("10KTpR8z0rlHmYm1YvqXogOJlDU56Cq1F");
        SliderItem s23 = new SliderItem("10GzZUh02NHoO5XzZcYVNdPpHrkXFdi57");
        SliderItem s24 = new SliderItem("10GotW9wAm414hPubs8VW0AUz-PnwAKxr");
        SliderItem s25 = new SliderItem("10DEOb48f65DcHKOe6qT2008lQFSXJkv4");
        SliderItem s26 = new SliderItem("102YTWtwGu7G62Rhaq9lx-6UD6XXZuSrw");
        SliderItem s27 = new SliderItem("100pj5Sd11J8iDCoJ8dtfoWg90G47hKEv");
        SliderItem s28 = new SliderItem("100ZZrBo9jIXaW-1NvlNOon8q-8NoskPS");
        SliderItem s29 = new SliderItem("1-z3O-8lgabmezxYa3Q9d7kR8noBdeLZC");
        SliderItem s30 = new SliderItem("1-VhgfjXVh6cNO0ORYWMAauE4h_zpU9ao");

        items.add(s21);
        items.add(s22);
        items.add(s23);
        items.add(s24);
        items.add(s25);
        items.add(s26);
        items.add(s27);
        items.add(s28);
        items.add(s29);
        items.add(s30);



        SliderItem s31 = new SliderItem("10dxYsKYDbPY-N7kPB09B55RB6HMfFglX");
        SliderItem s32 = new SliderItem("1-TKU6avrzTz2Phch-FNJb53CbYNqemj8");
        SliderItem s33 = new SliderItem("1-EEpj8wCSR32yllykp3yzrwjPtsK8dMe");
        SliderItem s34 = new SliderItem("1dFmdd0W-ayMX6TnCn8171q9MF2iWfOur");
        SliderItem s35 = new SliderItem("1d9QxKcey6WlpS4_XdAu186JVHB5MNwsY");
        SliderItem s36 = new SliderItem("1cxOUGyn6uwD1nM6uMxT4RhpoYnOpU5zD");
        SliderItem s37 = new SliderItem("1-Bg5YKPAbxdMmk8eAw_7LCyILte0T609");
        SliderItem s38 = new SliderItem("1cdbEIarc1tpgHEPblFh8t6GSj-0u6qKn");
        SliderItem s39 = new SliderItem("1-A5egZd8EJ3Dv_8u-OJWyuZxkGwuiclR");
        SliderItem s40 = new SliderItem("1-A2QsXtEbvJ3C7a0eVnh0Gr3zZH40lvN");

        items.add(s31);
        items.add(s32);
        items.add(s33);
        items.add(s34);
        items.add(s35);
        items.add(s36);
        items.add(s37);
        items.add(s38);
        items.add(s39);
        items.add(s40);



        SliderItem s41 = new SliderItem("1-5sQy30zFib-U--f0FvEWGG6-Gt_2lIx");
        SliderItem s42 = new SliderItem("12Y8pY2F8xH3jCP60BCd2HEB2GHlHtpjF");
        SliderItem s43 = new SliderItem("16UdgbkoZIzBIf1zd3ryfvRZme8ENClqT");
        SliderItem s44 = new SliderItem("16UUxzOOQOEEksA_imCL0CYOcLKN2hUCM");
        SliderItem s45 = new SliderItem("16UUxzOOQOEEksA_imCL0CYOcLKN2hUCM");
        SliderItem s46 = new SliderItem("16QFnGeP82u-kyXiwC429z7KQTD-fHTbk");
        SliderItem s47 = new SliderItem("16N3M6-A2n1R1lruEScR4W1NNg44JFCLK");
        SliderItem s48 = new SliderItem("16EXopHrw6i-cgfaJkmbC_lsCubHelojL");
        SliderItem s49 = new SliderItem("16Erqsa_UTJwQsm_afSVidoOV0o12SYg-");
        SliderItem s50 = new SliderItem("16paniQC8_oYY8kDSPuGTm_kH5NlEGa4j");


        items.add(s41);
        items.add(s42);
        items.add(s43);
        items.add(s44);
        items.add(s45);
        items.add(s46);
        items.add(s47);
        items.add(s48);
        items.add(s49);
        items.add(s50);

        SliderItem s51 = new SliderItem("16gRiPYc7HQib2ka8V40ucfOxvLGQgjHE");
        SliderItem s52 = new SliderItem("16rBmkW0JqdjI4k_UKAiyuSEJjwhgj1r4");
        SliderItem s53 = new SliderItem("16vgJ2nXYsPIEewu5d0RAmgho8pK9EPnX");
        SliderItem s54 = new SliderItem("1f5rlhDuF23zcu8Tnjh44LG5KtXlKaJp_");
        SliderItem s55 = new SliderItem("17JgqXjBtlp8_0_-VWRvz1S8V5Ilpa965");
        SliderItem s56 = new SliderItem("17EXQuXNYrEsZigX3eVJTk4AVM5jnkWkq");
        SliderItem s57 = new SliderItem("17BcMrO9KxGnh0ySs6xyOwr1zhu1HW3NP");
        SliderItem s58 = new SliderItem("1f5O3JjxpmO59yztMz2gCH49fybHK4mpE");
        SliderItem s59 = new SliderItem("1f4kjklsTU7DylY8-IQ0ok8tp__-ycPvh");
        SliderItem s60 = new SliderItem("1f3YOzTRU9kJSfkaxig0Ms3zt8WoGAMXz");

        items.add(s51);
        items.add(s52);
        items.add(s53);
        items.add(s54);
        items.add(s55);
        items.add(s56);
        items.add(s57);
        items.add(s58);
        items.add(s59);
        items.add(s60);



        SliderItem s61 = new SliderItem("1f39uUznsXIb8FEwBAg13Ab6rirHKi07b");
        SliderItem s62 = new SliderItem("1f-JHN3ONIQPN0YMKJbZ29uVRjUlUJ7jW");
        SliderItem s63 = new SliderItem("14L4Q8Qnig71W9ySAuRlFFj43DRke_yFn");
        SliderItem s64 = new SliderItem("15W1ZENtSHxm5XEeuYF286kUEHu5S53gW");
        SliderItem s65 = new SliderItem("1evZTH-KZnGGa-UHzv-_9h8jheQ3HLspJ");
        SliderItem s66 = new SliderItem("15V7rqz9uVgr0B1e6ScA13p1fiFH_Plas");
        SliderItem s67 = new SliderItem("15KsbDViu4kF7hWn0sCVErxUAHwe8yEmD");
        SliderItem s68 = new SliderItem("156DQOchErHZesq6uxvM0jSXtL_AoUZ30");
        SliderItem s69 = new SliderItem("14zsHpx8iCEjU_05FewSZkvmj-8Or__YP");
        SliderItem s70 = new SliderItem("14s8Eo9ldShVVVj1PqYlJD8BVIdqY6CBb");

        items.add(s61);
        items.add(s62);
        items.add(s63);
        items.add(s64);
        items.add(s65);
        items.add(s66);
        items.add(s67);
        items.add(s68);
        items.add(s69);
        items.add(s70);

        SliderItem s71 = new SliderItem("14kfNOSsoCCKG34gDtaB9hva53fDoGFst");
        SliderItem s72 = new SliderItem("14ltBkebHOl8a54ztRvh2gdnwehifufVf");
        SliderItem s73 = new SliderItem("14T9cEBhtZShd26Mu_TEIpfUNt5Aiy7ft");
        SliderItem s74 = new SliderItem("1epzjAFMZqemqjz12A72QXknS-WMf0nsN");
        SliderItem s75 = new SliderItem("1eYbZGBgXL1rg6Pb2jVtf9lCqfs3LSa1N");
        SliderItem s76 = new SliderItem("14TaEWo8HydRLDz48W69SVjLbLbpfZNiH");
        SliderItem s77 = new SliderItem("14FElNxbgWp4CKntJC7N1WK0xYNgvw6Gj");
        SliderItem s78 = new SliderItem("14QIi8tr5Drn8NWXWVmc0gpLhQQWQ9MIm");
        SliderItem s79 = new SliderItem("1efBvg0docsBWSn7D2CRJhbM9y7gc40TA");
        SliderItem s80 = new SliderItem("14SFvbxMsRqVLKE96skTY8YOGmOj3-TNJ");


        items.add(s71);
        items.add(s72);
        items.add(s73);
        items.add(s74);
        items.add(s75);
        items.add(s76);
        items.add(s77);
        items.add(s78);
        items.add(s79);
        items.add(s80);
        SliderItem s81 = new SliderItem("14FeSiOL1sD4x9Vj4QsC1jNZwlIRnzMPc");
        SliderItem s82 = new SliderItem("145p8s9fyiD_Rk8p9DgdCgtSTni2FsY3O");
        SliderItem s83 = new SliderItem("13yBwB7g59zdP3xMd4eV5vRcLnaYkYyYX");
        SliderItem s84 = new SliderItem("13zQ_6BJ-lbAPYhLJuKSeZHLvCStK-ogi");
        SliderItem s85 = new SliderItem("13ikZhXHA1a8kBFaETDRGTn-HYDyIf2ny");
        SliderItem s86 = new SliderItem("13ilgwReJOJXPDrnjmFScVgPMy04jWqEO");
        SliderItem s87 = new SliderItem("13eGBnUxNf5tSIeLcfyIz6wv-mx7c2UcC");
        SliderItem s88 = new SliderItem("1eUVULImQitJQV-oL7D8GE4Aqs0A64o3Y");
        SliderItem s89 = new SliderItem("1eUI0JNcUesKONTYVB-fKbBSYSyi-5rr1");
        SliderItem s90 = new SliderItem("1eJSmghCmarNCVSQlvPf211newixyZf1l");

        items.add(s81);
        items.add(s82);
        items.add(s83);
        items.add(s84);
        items.add(s85);
        items.add(s86);
        items.add(s87);
        items.add(s88);
        items.add(s89);
        items.add(s90);


        SliderItem s91 = new SliderItem("13NlxgegBuErB-vg1ApD5tVC0SfvmEY2X");
        SliderItem s92 = new SliderItem("1eEErtliKgIM7kUQEmdSbi2NViSYPsRMV");
        SliderItem s93 = new SliderItem("1eCOOSHK1yTXx06QCxaJQjasBCkyqDzI5");
        SliderItem s94 = new SliderItem("13TekHp98xRF3N3p64QARWHTNJUcVlBNx");
        SliderItem s95 = new SliderItem("1e6eNdCZteaYBDCdjR_II0nYw-xG4xpzA");
        SliderItem s96 = new SliderItem("1e6ZldRXFCLLg9PBGzl4I42j4E72psVpz");
        SliderItem s97 = new SliderItem("1e68eCN-sVtT_znsmeU_8p7ctT2d5lQG0");
        SliderItem s98 = new SliderItem("1e2JXltg0ixG5x4TxZ4aZWuSTi5xvyIUt");
        SliderItem s99 = new SliderItem("13FEwwyiQz_Zqr1NrQEK8YLqSGEy5gXT6");
        SliderItem s100 = new SliderItem("1e0eMvsp_mP8BvM47jxqlwODiPCAx2kid");

        items.add(s91);
        items.add(s92);
        items.add(s93);
        items.add(s94);
        items.add(s95);
        items.add(s96);
        items.add(s97);
        items.add(s98);
        items.add(s99);
        items.add(s100);

        SliderItem s101 = new SliderItem("1e0KmquoNH12nhR9ux5RUyBX5BKHfvaH3");
        SliderItem s102 = new SliderItem("12yii4OktVw2IZttuBleK4Qig-OCnX18K");
        SliderItem s103= new SliderItem("12gXmT-rmSUjRspyf7mvRRhfbKl741slL");
        SliderItem s104= new SliderItem("1drfnA1cLyOMe15v-qKJ0v9UOGiPf6GmL");
        SliderItem s105= new SliderItem("12XY7TAd-0M0Bc7Aqw0buCQ-lZqg7S_Pu");
        SliderItem s106= new SliderItem("1dkKMqcDhd3vd6g5qxAc-1RjR9lAYuhAT");
        SliderItem s107= new SliderItem("12EO2QuSATYlsg3T93dUEP_slVfgyZTrl");
        SliderItem s108= new SliderItem("12Fg1Zy0tq7wbKu-tOarPrhvhQs0rq-20");
        SliderItem s109= new SliderItem("12TLlPF7OdgdqI6zhOvlI3xJmAjID_gzu");
        SliderItem s110= new SliderItem("12RIP8qLaug7NhYDA31dIGrWhQNB-yCiL");

        items.add(s101);
        items.add(s102);
        items.add(s103);
        items.add(s104);
        items.add(s105);
        items.add(s106);
        items.add(s107);
        items.add(s108);
        items.add(s109);
        items.add(s110);

        SliderItem s111= new SliderItem("126IkpHJOsQTB2AaJ3HPmAuvYFdYoich3");
        SliderItem s112= new SliderItem("12Mql6RJHpM6CWbFYLipUyp2LDaqPD3ne");
        SliderItem s113= new SliderItem("12I1vTK8iVzMdprD21rAXU9-9GDMklcTu");
        SliderItem s114= new SliderItem("12CknG0GKHmSb4rZFmaGVvDG_WTUC13wI");
        SliderItem s115= new SliderItem("124zwb4doC3pgZzZDSXzqdnqMoFT5C6tP");
        SliderItem s116= new SliderItem("124zVgkQYpWXbSU1bWaLhLbOZhq9av5xD");
        SliderItem s117= new SliderItem("120JWhVuh_gxHJryqDRTCfzv0DHqJW0qh");
        SliderItem s118= new SliderItem("11zjJOQsaQVH0cJnkHz1q7CBvw0nz7YPT");
        SliderItem s119= new SliderItem("1dedAgi8_2mN66V3pTL94SkPAjI4svjLx");
        SliderItem s120= new SliderItem("11tiJS06yGsgXJj5DmjccL57JWQMnZIZj");


        items.add(s111);
        items.add(s112);
        items.add(s113);
        items.add(s114);
        items.add(s115);
        items.add(s116);
        items.add(s117);
        items.add(s118);
        items.add(s119);
        items.add(s120);
        SliderItem s121= new SliderItem("11t5u7euqLmXZnDwwuOhMBAOMlgsnnyA8");
        SliderItem s122= new SliderItem("1dbZzrnkMc4NfTmpyQ5GqTlCIxSfTE1X9");
        SliderItem s123= new SliderItem("11qgvfmKjx3eR1mAlQnFQ9HtLA5pLW8mE");
        SliderItem s124= new SliderItem("11lCieenKMlW-MPBS-Kse7BPVHHlpufr-");
        SliderItem s125= new SliderItem("1dPfPh_2LBYOIHrJef11JeW7mNQ8DA5Ys");
        SliderItem s126= new SliderItem("1dPCJMOG8WDKhLJoeBsDFvxo8WBa-IyjU");
        SliderItem s127= new SliderItem("11YAOuBvkJa78PlLeQzPaMPJpqc8SuHlw");
        SliderItem s128= new SliderItem("11WPIaZ7W4N1cXX9YCcOlgvNrydfLwKST");
        SliderItem s129= new SliderItem("1dIhwDsL-eUqSpTGfo-qMOQJ8gi0DT-PX");
        SliderItem s130= new SliderItem("11Sei3nihrw9loWJ05mnqHbvz7Josmifr");


        items.add(s121);
        items.add(s122);
        items.add(s123);
        items.add(s124);
        items.add(s125);
        items.add(s126);
        items.add(s127);
        items.add(s128);
        items.add(s129);
        items.add(s130);
        SliderItem s131= new SliderItem("11B1QKwzIuES2DZqEy9uodqsL0ZEYVdbr");
        SliderItem s133= new SliderItem("10cKYbDzbKt6HxGvzF8unnwMQr8IYs3Ir");
        SliderItem s132= new SliderItem("11-deq8PTjHRlwySu6Qr3zj_9odOduS2L");
        SliderItem s134= new SliderItem("1133Ky32NFb76d1_NjGYcb6M4duQ2x4ZY");
        SliderItem s135= new SliderItem("1133Ky32NFb76d1_NjGYcb6M4duQ2x4ZY");
        SliderItem s136= new SliderItem("10sxvqMPATauEaStvTkvEHR3zJPxkJbZQ");
        SliderItem s137= new SliderItem("10mLw5Ks3P1TeoRL8NWNWR7qLkSvYYl2O");
        SliderItem s138= new SliderItem("10qZC7FKXoHgyLMaklBfLczPvf2Kx-v9F");
        SliderItem s139= new SliderItem("1ccXp5aTSuZwf6y7m2KI-rRX0c9M--9MM");
        SliderItem s140= new SliderItem("10jsY3LJKx-XtChhR-0hJR0HI-xeW4WOJ");
        items.add(s131);
        items.add(s132);
        items.add(s133);
        items.add(s134);
        items.add(s135);
        items.add(s136);
        items.add(s137);
        items.add(s138);
        items.add(s139);
        items.add(s140);


        SliderItem s141= new SliderItem("14Gf27szeUmmx8xVGTFxETfaNlEXi7XuX");
        SliderItem s142= new SliderItem("14HSYbf67jXqt1vIGCgMi01-9482sK85n");
        SliderItem s143= new SliderItem("1cY_pcgq5c47Sq7fL-kN43qdYAAutXWSK");
        SliderItem s144= new SliderItem("10iShtBRn6jtOm7i3ojrecOMauRX2_WYl");
        SliderItem s145= new SliderItem("10cKYbDzbKt6HxGvzF8unnwMQr8IYs3Ir");
        items.add(s141);
        items.add(s142);
        items.add(s143);
        items.add(s144);
        items.add(s145);

    }

    @OnClick(R.id.back_icon)
    public void backPress(){
        onBackPressed();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(context);
    }
}
