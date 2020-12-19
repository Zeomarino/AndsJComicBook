/*
Şimdi kendi adapter'imizi nasıl yazarız onu öğreneceğiz peki neden adapter yazmayı öğreniyoruz ?
Keza bunu daha önce -

ArrayAdapter'ile yapmıştık neden yine yapmayalım.
 "Misal" "ArrayAdapter " demiştik ve içinde şu şekilde yapmıştık.
    "ArrayAdapter arrayAdapter = new ArrayAdapter()" demiştik
    () içerisinde bizden bazı şeyler istemişti misal context. Ve context'i MainActivity.this diyip verebilirim.
    Peki context'den sonra -  Resources istemişti - oda "android.R.layout.simple_list_item1," demiştik.
    Ve birde hangi objeleri göstereceğini sormuştu tam burada işler karışıyor yani şu şekilde hal alıyor.
    "ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,)"
    ,Den sonrasında işler karışıyor biz buraya gelip "comicList" dersek ortalık biraz karışacak.
    Çünkü "comicList" bize direk bir string vermiyorki daha önce simple_list_item_1 ne işe yarıyor üstünden geçmiştim.
    Birtane layout bu içinde sadece stringler var string gösterebilceğim birtane textView var comicList bana bir string vermiyorki
    Artık bir comics objesi veriyor Ne göstericek bu adam simpson objesinin kendisini nasıl göstersin listede
    o yüzden keza bu biraz karıştı artık bu basit arrayAdapter'i kullanmak yerine. Kendi adapter'imizi nasıl yazıcağız
    onu öğrenmemiz gerekiyor onu nasıl yapabiliriz ? Aslında buda kolay daha önce "simple_list_item1" şimdilik yapıyoruz ama
    sonrasında görselde eklemeyi listeye birden fazla textView koymayı vs button koymayıda öğreniceğiz demiştik.
    Şimdi ona bir giriş yapıcağız daha sonra daha net bir şekildede öğreniceğiz ama şimdilik.
    New - JavaClass - Yine bir sınıf oluşturucağız aslında adınada mesela "CustomAdapter" diyorum

Şimdi burda "CustomAdapter"imde bir extends kullanıcağım .
"public class CustomAdapter {" içerisinde neydi bu ınheritanceydi şimdiye kadar encapsulation'u kullandık
constructor'ları kullandık şimdide "extends diyiceğim " ve
    Kod Zamanı 1 -
    1) public classs CustomAdapter extends ArrayAdapter {
1.Kodun açıklaması - Array Adapter'e extends ediceğim diyorum ne yapıyordu bu - Bu sınıfım ArrayAdapter'in özelliklerini kullanabiliyordu
Ve böyle yapınca bakın nediyor " default constructorun yok diyor" neden ?
ArrayAdapter'in içinde demekki default bir constructor varmış alt enter yaparsak nasıl yapılcağını bize gösteriyor zaten.
İşte super'in içinde bir context istenen ve birde resources istenen bir constructor varmış bunu yapmak zorundasın diyor
okey'e basarsak zaten bizim icin oluşturcak
"public CustomAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }"
Şeklinde neden bunu yapıyordu  ? Aynı şey bizimde başımıza gelmişti daha önce musicians ve superMusicians sınıflarını yaptığım bir projede
Oldu ama fakat tam istediğim gibi olmadı aslında neden ? ben sadece bunları almak istemiyorumki ne işe yarıyor hatta belirtim.
Context dediği - Sen bu customAdapter'i hangi aktivite kullanıcaksın onu soruyor birde
Hangi layoutta kullanıcak onu soruyor "int resource" işte r.simple_list_item_1 de kullanıyorduk daha önce şimdi onu değiştirceğiz onu burayaa yazıcağız
Eğer mainActivity'de kullanacaksak onuda context'e yazıcağız ama mainActivity dışında başka bir yerdede kullanmak istiyebiliriz diye
bunu gerçekten kendimiz bir context veya bir aktivite olarak alıp kendimiz yazıcağız o yüzden bu alt enter'i siliyorum baştan kendimiz yazalım. daha iyi olur
Ama neden yazarken context alıyorum veya neden bir layoutu almak zorundayım vs anlıyabilmemiz için bunu belirttim.
hatta ve hatta class'ımızın içinde yine alt enter yapıp seçeneklere bakarsak bağlıyabildiğimiz objeleri ve listeleri sordugu özellikte var
direk misal bir comicListesi yapıp onu buraya bağlıyabiliriz şimdi hepsini yapıcağız zaten.
Fakat önce bu class'a gelmeden layout kısmına geliyorum apk'min sağ tıklayıp new layout resources file diyorum ve
LinearLayoutmu constraintLayoutmu vs diyor farketmez biz basit birşey yapıcağız zaten adına custom_view diyorum
Ne yapıcağız - bu custom_view'de her bir liste elemanın nasıl görülceğini belirticeğim misal
TextView'i gelip buraya atabilirim textView'imin gravity sini center yapıyorum ortada olması için
textAlignment'te istediğimiz gibi yapabiliriz açıkcası solda sağda ortada vs.
Ama bu benim için yeterli ilerde bunun içine bunu büyütüp görsel koymayı başka TextViewler koymayıda görüceğiz
çokta bi farkı yok burda yaptığımızdan id vermemiz lazım "customTextView" diyorum idsine
Şimdi artık layoutum var geleyim "customAdapter.java" ya
Burda ne dedik birtane constructor yapmak zorundayız ve constructor'ın içinde bir context'i iki hangi layoutu kullancağımı üç hangi listeyi kullancağımızı belirtmemiz gerekiyor
Şimdi bu listeyi ve aktiviteyi tabiki burda mainActivity yazarken burdaki developerden yani kendimizden isticeğiz
o yüzden bunları evvela bir property olarak buraya tanımlamam gerekiyor.

    "customAdapter.java class içerisine"
    Kod Zamanı 2-
    1)private ArrayList<>
1.Kodun açıklaması - Listemin içerisinde "ArrayList<>" Comics objeleri olucak ve adına yine comics diyebilirim
Birde
    2)private Activity
2.Kodun açıklaması - Birde activity alıcağız bununda adına context diyelim mesela tabiki bunu diğer tarafta alırken
mainActivity'nin kendisini vericeğiz ve bu arrayAdapter'de hatırlarsak şu şekilde <> obje alıyordu bunada "comics" objesi olucağını söylüyebilirim
Yani class'daki arrayADaptere bunu yaptıktan sonra gelelim kendimiz baştan şu constructor'u yazma işine
    3) public CustomAdapter(ArrayList<Comics> comics, Activity context) { } diyip parantezlerimi açıyorum
3.Kodun Açıklaması :"()" içerisine bir Ne isticeğim "ArrayList<Comics>" bir comics arrayList'i isticeğim
adına comics diyiceğim , koyucağım ve iki Activity isticeğim "Activity context" adına context diyiceğim bu ikisini istedikten sonra
method içine gelip
    4) this.comics = comics;
Diyorum ve
    5)this.context = context; diyorum bunların ne olduğunu biliyoruz.
Fakat benim derdim burda bitmiyor thislerin üstünde birde super yapmam gerekiyordu
    6)super(context,R.layout.custom_view,comics);
6.Kodun açıklaması - () içerisinde bizden contextResource ve hangi liste ile bağlıyacağım "context" contextim
Resources'im "R.layout.custom_view" hangi liste ile bağlıcağım "comics"
Adapter'i nerdeyse bitirdik son birtane aslında esas bütün bu işlemi yapmamızın sebebi olan bir methodu kullanıcağız
Şimdi ArrayAdapter'e extend ettik ya class'ımızı o yüzden ArrayAdapter'in methodlarını cağırabiliriz
Code - Generate dersek tekrar Override methods'a bakarsak override edebilceğimiz arrayAdapter methodlarını arıyoruz
içerisinde getView diye bir method var bunu arıyoruz neden bunu arıyoruz

Yani bunu "    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }"
Bu getView şu işe yarıyor bize bir "int position" pozisyon veriyor bu senelerdir position ama bakarsınız i koyarlar adını
başka birşey koyarlar şuan position oldugu için bunu diyom bu gerçekten listedeki pozisyonu veriyor yani her bir sırada
hangiView'in ne iş yapıcağını burda yazabiliyoruz nasıl yazıcağız şöyle yazabiliriz
Bir öncelikle customView'imizi buraya bağlıcağız sonra customView'in içerisinde oluşturudugum textView'i burda tanımlıyacağız
TextView'dada burda geleen "private ArrayList<Comics> comics;" içerisindeki elemanları tek tek al ve bunların isimlerini göster
diyiceğiz bütün bunları yapıcağımız method bu getView methodu şimdi burda duralım bir sonraki aşamamızda bu methodu yazalım.
Sıradaki Aşama "ListedeGösterimNot"
 */