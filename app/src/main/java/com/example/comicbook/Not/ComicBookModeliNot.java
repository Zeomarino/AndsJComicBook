/*
Şimdi bu App'imizde sınıfları modelleri kullanıcağız şimdi bi comic book modeli oluşturucağım bir simpson sınıfı oluşturacağım yani.
Ve aslında eklediğim comicleri tek tek tek tek isimleri resimleri vs yapıp ayrı ayrı arraylistlere tanımlamak yerine tek bir obje içerisinde yapıcağım.
Daha önce "LandmarkBook" projemde Landmark'ın isimlerini aynı sırayla bir arraylist'e işte landmark'ın görsellerini aynı sırayla
Bir arrayList'e koymuştum 3 tane arrayList'im olmuştu ve hepsini diğer tarafa aktarmıştım bu sefer tek bir ArrayList ile
tek bir obje türü üstünde çalışma yapıcağız Ne demek istiyorum.
"com.example.comicbook'a" gelip sağ tıklayıp yeni bir java sınıfı oluşturuyorum.
Adına "Comics" diyorum
Gelelim comics sınıfımıza
Comic karakterlerimizin neyi olucak  -
Bir ismi olucak .
İki mesleği - biografisi olucak -
Üç görseli olucak -

Kod zamanı 1 -
class'ımın içerisine "public class Comics {
    1) String name;
    2) String bio;
Ekledim ve görseli nasıl yapıcağız.
Daha önce ne yapmıştık .

DetailsActivity'de anlatayim çünkü imageView burda.Sonra deaktif ediceğim zaten.
Şimdi daha önce : Bitmapleri tek tek tanımlamıştık ve bit mapleri r.drawble kütüphanesinden aldıktan sonra aslında.
Bir bitmapFactory kullanarak almıştık ve imageView'imize öyle koymuştuk ne demek istiyorum.
Mesela -
"onCreate altında - Details.java" içerisine.
    Try kod 1 -
    1) Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.maasai);
1.Kodun açıklaması - () içerisinde bir resources istiyordu benden "getApllicationContext().getResources şeklinde alıyorduk.
ve , koyup birde hangi şeyi koyucağız misal R.drawble.resimimizin ismi.
Burda R.drawable.maasai aslında bir integer "Ands" bu drawableleri bir sayı atarak tutuyor misal
masaai ( =-700137) şeklinde bunlara otomatik sayı atamış şimdi biz buraya bu şekilde. koyarsak alıcak
Ve sonra gelip.
    2)imageView.setImageBitmap(bitmap);
Diyebilirim Peki ben öyleyse landmarkbook uygulamasında tek tek bu bitmapleri bir yerde oluşturup buraya aktarmak yerine
sadece "R.drawable.maasai" değerini bir integer olarak kaydedip onu aktarsam olmazmıydı ?
Aynen olurdu hatta çok daha verimli olurdu singleton ile ulaşmak zorunda kalmazdım intent ilede yolluyabilirdim vs vs
Tabiki landmarkbook'ta bunu yapmamızın sebebi singleton yapısını daha iyi kavrayabilmemizdi.
fakat şuanda artık bunu biliyoruz ve bunu daha verimli bir şekilde nasıl yazıcağımızıda biliyoruz .
Bu try kod  1  - şimdilik yorum satırı haline alıyorum.
Bu r.drawable.maasai'yi integer olarak aktarıcağım için modelimde

Gelip birde "comics.java" class'ımın içerisine kaldığım yerden devam edeyim.
    Kod Zamanı 1 -
    3) int pictureInteger;
3-Kodun açıklaması - Adına pictureInteger dedim bu pictureInteger'i artık aktarıcağız.
Şimdi bunu yaptık tabiki constructor ile çalışmak istiyeceğim.Daha düzgün yapabilmek için

O yüzden constructor'u seçiyorum - Code -Generate'yi sçerek yapabilirsiniz."Alt-Instert" yada vs vs.
Ve hem name , hem bio , hemde picture'yi seçiyorum.
" public Comics(String name, String bio, int pictureInteger) {
        this.name = name;
        this.bio = bio;
        this.pictureInteger = pictureInteger;
    }"
Şeklinde oluyor hepsini isticeğim yani.
Ve bunu yaptıktan sonra şöyle birşey istiyorum - yine ancapsulation'u kullanmak için
Hepsini private yapıcağım çünkü birkere oluşturulduktan sonra birdaha hiçbiryerde değiştirilsin istemiyorum.
name; , bio; , pictureInteger'e private ekliceğim yani .
Keza şuan private yaptığımdan dolayı getter'i koymam gerekicek çünkü : sonra bu değerleri almamız gerekicek fakat şimdilik yapmama gerek yok
Daha sonra geleyim misal mainActivity.java'ma diyimki misal "onCreate" altında
    4)Comics maaSai = new Comics("MaaSai Mysterious","Unkown Job , Maasai gizemli kişiliği ile bir bilinmeyendir.Adı duyulmuştur ama kendisini gören tanıyan yoktur",R.drawable.maasai);
4.Kodun açıklaması - () içerisinde bizden bir isim isticek " Maasai Mysterious" diyorum ismine misal
Bir bio - meslek isticek "Unkown" diyorum ve ufak çaplı bir bio ekliyorum.Birde integer isticek bunada "r.drawable.maasai" diyerek
Çözüyorum daha sonra aynısını misal
pirate için yapalım.
    5)Comics pirate = new Comics("Captain Canny","Pirate Job , Canny denizde korsanlık yapan yaptıgı yağmacılıkla hayatta kalan kurnazlıgı ile nam salmış bir korsandır",R.drawable.pirate);
Daha sonra tekrar bir comic oluşturuyorum.
    6)Comics santaClaus = new Comics("Santa Claus","Motorcyle Gang Leader , Santa Fimazen adlı motor siklet çetesinin gizemli lideridir seri kanlılığı ve atikliği ile bilinir.",R.drawable.santaclaus);
    7)Comics scareCrow = new Comics("Scare Crow","ScareCrow , ScareCrow gizemli bir karakterdir. Kendisinin en korku dolu zamanlarda ortaya cıktığı söylenmektedir.",R.drawable.scarecrow);
    8)Comics witch = new Comics("Witch","Witch, Büyü ile haşır neşir olan cadımız gizemli bir ormanda hüküm sürmektedir.Birgün yolunuz düşürse kurnazlıklarına karşı tetikte olmanız gerekmektedir.",R.drawable.witch);
şeklinde karakterlerimi ekliyorum ve birtane ArrayList oluşturacağım bunları koymak için
Arraylist'im ne ArrayList'i olucak  : Comics.
    9)ArrayList<Comics> comicsList = new ArrayList<>();
9) Kodun açıklaması - comicsList dedim adına
Daha sonra
    10) comicsList.add(maaSai);
    11) comicsList.add(pirate);
    12) comicsList.add(santaClaus);
    13) comicsList.add(scareCrow);
    14) comicsList.add(witch);
Şeklinde ekliyorum böylece listemde bunlar oluştu geriye ne kalıyor -
ArrayList'i listView'E eşitlemek tıklandığında bu comics'lerden birtanesini "detailsActivity" e yollamak
Yolladıktan sonrada içindeki ismi mesleği biosunu alıp detailsactivity.javada göstermek kalıyor.
Bunları aslında listede göstermek vs kolay fakat daha ileri seviye şekilde bunu öğrenebilmemiz için listeleri biz nasıl customize edebiliriz
yani kendimiz istediğimiz gibi kullanırız birazdan onları anlatıcağım o yüzden burda duracağım bir sonraki aşamada devam ediceğim.
Sıradaki Aşama "CustomAdapterNot"
 */