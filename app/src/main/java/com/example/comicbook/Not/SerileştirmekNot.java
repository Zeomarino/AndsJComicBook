/*
Şimdi bu apk'mizde isimlere tıklayınca diğer tarafı nasıl açarız bunu zaten daha önce gördük.
mainActivity.java'ya gelip "onCreate altında"
    Kod Zamanı 1 -
    1)"listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    });"
1.Kodun açıklaması - setOnItemClickListener yapıyorduk daha önce ve böylece listeye tıklandığında nereye tıklandığını vs hepsini bize veriyordu
()içerisine (new OnItem) yazarsak adapterView şeklinde bir cağırma yapabiliyorduk.
Ve bu method override şeklinde kendisi oluşturuluyordu şimdi onItemClick methodu içerisinde ne yapıcağız ?
Aslında sadece intent yapıcağız
    2) Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
2.Kodun açıklaması - (içerisinde) MainActivitiy.this, context'indeyiz ve gitmek istediğimiz yer "DetailsActivity.class"
ve
    3)startActivity(intent);
Dersem diğer tarafa beni götürücek fakat götürmeden önce 3.Koddan önce yani.
    4)intent.putExtra("selectedComics",comicList.get(position));
4.Kodun açıklaması - Extrada daha önce ne yapmıştım  ismi ayrı görseli ayrı resmi cismi ayrı hepsini yollamıştım.
Bu sefer sadece modeli yolluyağım  mesela "selectedComics" diyiceğim adına seçilen comics ismine ek keye anahtar kelime.
Değere ne diyiceğim , koyduktan sonra booleanmı yolliyim bytemi yolliyim charactermi yolliyim sequencemi yolliyim
ne yolliyim diyor ands bizim comics'imiz burda çıkmıyor bizim comics'imizi nasıl yolluyacağız ?
Şimdi comics'i "," de "Serializable " diye birşey görüyoruz serileştirerek yollama diye birşey var bu şekilde yollarsak modelimizi böyle yollayıp diğer tarafta kolaylıkla
alabiliyoruz fakat şu dakika gelirsek aklımızdan diyebilirizki :
"comicList.get" yaparım hangi comic listi aliyim der burdaki methodda Onıtemdeki bana ne veriyordu "int i" tıklanan index neyse
onu veriyordu alırım onu (position) şeklinde yazarım buda tıklanan model hangisi ise onu yollar der.
    "intent.putExtra("selectedComics",comicList.get(position));" yani bu şekilde aklımıza gelebilir.
Daha önceden yaptığımız bir şeydi bu şuan olmuyor çünkü "comicList.get(i));" aslında şuan ne serileştirilmiş ne boolean ne integer yani
ands tanımıyor bunu bu şekilde yolluyabilmek için "comics.jc" ı bir şekilde değiştirmemiz gerekicek.
Ve değiştirmekten öte aslında serileştirebilir yapmamız lazım onuda yapmanın yolu kolay sayılır.
Peki nasıl yaparım :
    5) "public class Comics" class'ıma gelip . "public class Comics implements Serializable "
5.Kodun açıklaması - Neydi implements ne yapıyorduk bir interface abstract bir sınıf  bir arayüzden bir extend etmem veya kalıtım alma
Bunu bir uygulama işlemi yaparken kullanıyorduk ve bu sefer implements den sonra şunu kullanıcağım.
    "implements Serializable"
Seriazable - Serileştirebilir bu şekilde tıklıyorum  güncelliyorum yani.
Ve hiç birşey olmuyor ama mainActivity'e geri dönersek 4.kodda olusan hata gidiyor çünkü artık bunu serileştirebilceğim bir şekilde
yolluyabiliyorum
Ve comic class'a geliyim.
5.Koduma bakarsam . command veya ctrl tusuna basılı tutarsak serializablede üzerinde "public inteface Serializable" şeklinde yazıyor zaten
üstüne tıklarsak Bir lisans soruyor accept dersem burda içerigini görebilceğim pencere acılıyor dowloand etmem gerekiyor.
çok önemli değil sadece anlatmak istemiştim herhangi bir daha önceden yazılmış public arayüzü yada sınıfı görmek istersek
CTRL'ye basılı tutarken üstüne tıklamamız yeterli bu bize bunun içerigini göstericektir tabiki bazı yerlerde dowloand etmemiz gerekebilir önemli değil
yapmak zorunda değiliz detaylarını merak ediyorsak ama yapabiliyoruz sonuçta.
Biz bu 5.kodumuzda bu serializableyi uygulayarak
burdaki comics.java'daki sınıfımı serileştirebiliyorum bu şekilde objelerimizi intent ile başka bir aktiviteye aktarabiliyoruz
hatta ve hatta "DetailsActivity" içerisinde "onCreate" altında bir intent oluşturayim.
    6)Intent intent = getIntent();
Nasıl alıyorduk mesela
    7)intent.getSerializableExtra("selectedComics");
7-Kodun açıklaması - intent.get dediğimizde getBoolean getString byte felan derken biz bu sefer getSerializableExtra'yı seçiceğiz.
Diğer taraftan serileştirerek yolladığımız şey neyse mesela "selectedComics"se bu sefer bu şekilde alabiliriz.
Şimdi bunu alırken ne yapıcağız tabiki bu bir comicsObjesi olucak o yüzden bu 7.Kodumu şu şekilde güncelliyim.
    7)Comics selectedComics = intent.getSerializableExtra("selectedComics");
 Bu bana bir hata vericek diyorki sen comics alıcağım diyorsun fakat burda serileştirilmiş bir objeden bahsediyorsun diyor
 önemli değil comics olduğundan eminim ben bunu o yüzden
    7)Comics selectedComics = (Comics) intent.getSerializableExtra("selectedComics");
Şeklinde güncelliyorum bu şekilde comics'e cast et bunu diyorum  (Comics) olarak zorla tanımla ben eminim
bu bir comics objesi diyorum
    Ve daha önce yazdığım detailsActivity.jc'ında
    "        //Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.maasai);
        //imageView.setImageBitmap(bitmap);"
        Kodunu yorum halinden cıkarıp artık şu şekilde güncellersem.
        "        //Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),selectedComics.getPictureInteger);
        //imageView.setImageBitmap(bitmap);"

Bakın sonuç olarak şuan nekadar kolaylıştı işim tek bir obje üstünden bütün işlemlerimi yapabilirim.
altına hemen gelip misal
    8)nameText.setText(selectedComics.getName());
    9)bioText.setText(selectedComics.getBio());
İlk başta bize çok uzunmuş gibi gelen bu süreç aslında 50 tane property'miz olsaydı yüzlerce binlerce objemiz olsaydı tek tek burda arrayListlerle uğraşmak yerine
tek bir model üstünden bu şekilde yapmak nekadar akıllıca ve nekadar zaman tasarufu sağlardı bir düşünelim.
O yüzden misal apk'mi şuan acıp herhangi eklediğim bir comic'e tıkladığımda karakterim burda cıkıyor ve ufak bir biosuda aşağıda beliriyor
Diğer yaptığımız uygulamadan bir farkı yok fakat şuan nekadar güçlendik şimdi istersem ben comics sınıfıma gelip bir sürü property ekliyebilirim.
tek bir liste üzerinde mainActivity.java üzerinde çalışabilirim bu customAdapter'de birazcık kafamız karışmış olabilir
aslında 3 satır kod yazıyoruz önümüzde bununla ilgili farklı projeler zaten github reposunda paylaşıcağım.
Ben özellikle yeni teknolojiler öğrenirken misal firebase vs öğrenirken kafa karıştırmamak için çok model işlerine girmiyeceğim
fakat artık nasıl obje odaklı programlama consepti kullanılır vs gördük bazı internette gördüğümüz uygulamalarda şu şekilde sınıflandırmalar görebiliriz
Genelde şu şekilde yaparlar com.example.comicbook'a sağ tıklarsak eğer new dersek yeni yeni klasörler oluşturabiliyoruz
misal Package dersek adına model diyelim comics'i alıyor misal modelin içine koyuyor tıpkı bu benim not klasörlerim gibi.
Refact ediyor artık 1 tane model şeyi var işte packageyi açıyor yine activity diyor vs activitylerin hepsini burda o packageye atıyor
Atıyorum birtane daha package açıyor ismine Adapter diyor adapterleri bunun içine koyuyor gibi klasörlere bölüyor yani.
bu şekilde uygulamalar görebiliriz olası bu şekildede kullanım tabiki mümkün çok karışık uygulamalarda özellikle bu şekilde klasörleme yapmamız tabiki daha düzenli olmamıza olanak sağlar
farketmez misal calıstırısak aynı şekilde app'imiz calısmaya devam edicek bir proglemle karşılaşmayız aynen çalışıyor.
Umarım daha net kafanızda bazı şeyler oturmuştur


Son Aşama.
 */