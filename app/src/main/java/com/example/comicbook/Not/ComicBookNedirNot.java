/*
Şimdi bu obje odaklı programlama bölümünde öğrenilen şeyleri kullanarak bir uygulama yapıcağız aslında daha önce yaptığımız landmarkbook uygulaması ile neredeyse birebir aynı yani bir tarafta
Comic karakterlerin listesi olucak tıklayınca diğer tarafta o comic karakterinin görselini ismini mesleğini vs gösteren kolay bir uygulama yapıcağız fakar
bunu yaparken gayet proffesionel bir şekilde modelleri kullanarak oop getirdiği güzel özellikleri kullanarak yapıcağız
o yüzden keza yeni bir proje başlattım ve empty activity'i seçerek devam ettim
Projemin adına ComicBook dedim Language java seçtim.
Diyebilirizki daha önce zaten landmarkbook yaptık "https://github.com/Zeomarino/AndsJLandmarkBook"
Tabiki onu yaparken tabiki ideal bir şekilde yazmamıştık yani ne model kullandık bütün bitmapleri vs ilk aktivite tanıttık
diğer aktiviteye aktardık falan filan bunların hepsini yapmamızın bir sebebi vardı örneğin singleton
kullanmayı öğrenmek için vs fakat bu sefer gerçekten ben bunu google play'e koysaydım kod olarak ne kullanırdım onu birazcık size aktarmaya çalışacağım

Bunun için evvela layout klasörüme geliyorum
"Activity_main.xml" e giriyorum içindeki textView'ide atıyorum
Ve içerisine 1 tane listView koyucağım
mainActivity'mizde sadece 1 tane kocaman listView olucak
Ekliyorum ve id'sinede "listView" diyorum ve infer constrainlerini otomatikmen veriyorum.
 Aslında burdaki tasarımım bukadar.
 mainActivity.java'mada gelip onCreate altında hemen bir listView'imi tanımliyim.
    Kod Zamanı 1)
    1)ListView listView = findViewById(R.id.listview);
Ne yapıcağız birtane daha activity lazım.
New - Activity- Gallery - Empty Activity
Adınada mesela "DetailsActivity" diyorum
Dediğim gibi landmarkbooktan sonra bunu tekrar bakmak istemeyebilirsiniz bu normal ama ben kesinlikle notlara bakmanızı tavsiye ederim çünkü oop'nin getirdiği avantajları burda kullanıcağız
arka planda neler dönüyor daha iyi anlıcağız
Eğerki "DetailsActivity" de bug olurda R.layoutta.activity.details'i kırmızı gösterirse.
Build  - Clean Project Yapıyorum yaptıktan sonra Build - Rebuild Project yaparsanız muhtemelen cözülür.
Ve run yaptıktan sonra hala kırmızı gözükürse
File - Invalidate Caches/Restart'a tıklıyabilirsiniz eğer dediğim gibi karşınıza app yazarken bu tarz sorunlar çıkarsa aynı şekilde kullanabilirsiniz.
Dediğim gibi ben comic book tasarlıcağım keza bir kaçtane comic resim indiririm ondan sonrada bunların isimlerini mesleklerini yaşlarını vs gösterebiliriz ben kolay tutmak için sadece
isim meslek ve görselden oluşan bir uygulama yapmayı düşünüyorum.
Dolayısıyla resimlerimide hazır ettim. Sizde uygulamanızı yapar iseniz küçük olan görselleri seçerseniz ands için daha etkili olucağı kanatindeyim.

Res/layout/activitiy_details.xml'e girelim.
Bir adet imageView kullanıcağım dolasıyla ekledim.
Resmi keyfimize göre seçebiliriz şu aşamada eklediğimiz imageView'in bir önemi olduğunu düşünmüyorum.
Daha sonra 2 adet textView'imiz olucak Bir : İsmini söylediğimiz - Birde kendisi hakkında bilgilerini yazıcağımız textView
Birinci : TextView'imin idsini nameText yapmayı uygun gördüm
İkincisi : idsini bioText - Yapmayı ve textine - Cartoon Bio yazmayı uygun gördüm.
Ve ondan sonra otomatikmen bir constraint verdim.

Tasarımla ilgili işim nerdeyse bitti
Geleyim - DetailsActivity.java'ya hemen bir tanımlıyalım. "onCreate" altında.
    Kod Zamanı 1)
    2) ImageView imageView = findViewById(R.id.imageView);
2.Kodun açıklaması - Birtane imageView'imiz var Cartoon eklediğimiz onun tanımlaması idsini imafeView olarak bırakmıştım.
Daha sonra 2 adet textView'im var onları bir tanımliyim.
    3) TextView nameText = findViewById(R.id.nameText);
    4) TextView bioText = findViewById(R.id.bioText);
 Diyorum. Herşeyimiz nerdeyse bitti.
Yüklüyeceğim resimlerimi drawble içerisine ctrl c + ctrl v yöntemi ile koydum.
drawble 24 değil drawbleye .
Şimdi buraya kadar herşeyimiz tamamsa burda bir duralım Genel layoutumuzu çıkarttık görsellerimizi felan aldık
Nasıl yazıcağız app'imizi bir sonraki aşamada üzerine düşünelim.
Sıradaki Aşama - "ComicBookModeliNot"
 */