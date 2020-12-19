 /*
Şimdi bu aşamda getView methodumuzu yazıcağız bu methodun içerisinde artık
layout custom_view'im ile customadapter jc 'ını birbirine bağlanmış olucak
Ve bunu yazabilmek için "LayoutInflater" isimli bir sınıfı kullanıcağız
    Kod zamanı 1
    Şu aşamada CustomAdapter.jc'ımda getView methodumun içerisinde yazıcağım.
    1)LayoutInflater layoutInflater = new
1.Kodun açıklaması - LayoutInflater ne işe yarıyor adınada "layoutInflater" diyorum "new LayoutInflater" dersem
{...} şeklinde bana farklı şeyler cıkarıyor bu böyle tanımlanmıyor yani şu şekilde. tanımlanmıyor.
    "LayoutInflater layoutInflater = new LayoutInflater" bunu contextden tanımlamamız gerekicek nedir context
"private Activity context;" diyerek almıştık context : hangi aktivite içerisinde çalıştırıyorsak ordan çalıştırılcak
MainActivity'de tanımlıyacağım ben bunu aslında mainActivity'de "getLayoutInflater" demek gibi birşey bu
    "LayoutInflater layoutInflater = context.getLayoutInflater()" demek gibi birşey yani
    1)LayoutInflater layoutInflater = context.getLAyoutInflater();
 Daha önce bunu nasıl kullanmıştık mesela mainActivity içinde.
 İşte menü eklerken menü activity'lerini inflate etmiştik daha doğrusu menüyü inflate etmiştik aynı şekilde burdada bir layout'u
 inflate ediceğiz layout'u göstericeğiz o yüzden burda context'i kullanarak bu işlemi yapıyoruz aslında bu mainActivity'de cağrılcak 1.kod yani.
 ve Şu işe yarıyacak CustomView'imi tanımlıyacağım bir view olarak görünüm olarak
    2) View customView = layoutInflater.inflate(R.layout.custom_view,null,true);
 2.Kodun açıklaması -  Adına customView dedim şöyle tanımlıyacağım = layoutInflater.inflate() dersem () içerisinde bana
 bir kaç şey isticek sorucak bir : hangi resources'i kullanmak istiyorsun. iki : root olucakmı root : kök grup demek
 bizim böyle birşeye ihtiyacağımız yok üç : rout'a bağlıyalımmı kendi kökümüze bağlıyalımmı.
 Şöyle yapıcağım dolayısıyla (R.layout.custom_view) ile bağlıcağım (,null,) root'a hayır null diyiceğim ve
 (,true) attachToRoot'a true diyiceğim.Bu res-layout-custom_view.xml'i birebir bir değişken olarak tanımlamama
 olanak sağlıyor hatta ve hatta bu dakikadan sonra
    3)customView.findViewById(R.id.customTextView);
3.Kodun açıklaması - findViewById() diyebilirim yani ve () içerisinde (R.id.customTextView) customTextView'i daha önce birlikte editlemiştim.
custom_view textView'imizin id'sdi idyi getir dedim yani.Bu şekilde bunu burda cağrabilirim.
Ama bunu cağırmışken birşeye eşitliyelim textView'e
    3)TextView nameView = customView.findViewById(R.id.customTextView);
Şu şekilde bir güncelleme getirdim nameView dedim mesela textView adına buraya tanımlamış oldum ve artık direk
    4)nameView.setText();
4.Kodun açıklaması - setText diyerek comic book karakterimin ismini artık direk buraya koyabilirim peki comicListemi nerden alıcağım.
Comics listem zaten activity'den buraya paslanacak "private ArrayList<Comics> comics;" ve comics.get diyiceğim.
hangi pozisyonda olduğumu nereden biliceğim getView methodunda veriliyor   (position) peki bu bana birtane comics objesi vericek
keza şu şekilde hata veriyor zaten "nameView.setText(comics.get(position)); comics objesi veriyor bu bana ben comics objesinin adını söylemek istiyorum
.name diyebilirmiyim diyemem. çünkü comics class'ımda private yapmıştım hepsini peki ozaman ne yapmalı.

"Comics.javaclass" ına gelip code generate - getter ekliyelim ve hepsi için birer getter oluşturalım daha önceki notumda bahsetmiştim daha sonra ekliyeceğim diye getteri.
ve oluşturtukdan sonra artık custom.adapter.java'ma gelip.4.Kodum olan nameView'den devam edeyim.
    "nameView.setText(comics.get(position).getName());"
getName diyebilelim
Şimdi en sonundada "return super.getView(position, convertView, parent);" return dediğim yerde bu customView'i döndür diyorum çünkü herşeyi
kendim baştan tanımladım yani "return super.getView(position, convertView, parent);" off edip
    5) return customView;
Kafa karıışıklığı olmus olabilir belki ama bunu tekrar pratik ediceğiz zaten hiç görmemişiz gibi
fakat extend ArrayAdapter" tarzı işlemleri arka planda ne döndüğünü daha iyi anlatmak için yapıyorum misal ArrayAdapter'e extend ediyor
extend ettiğimiz için getView methodunu yani onun methodlarını burda kullanabiliyoruz
onu methodunu kullanarak burda oluşturuduğumuz custom_view.xml ile customAdapter.jc 'ını birbirine bağlıyabiliyoruz
ve birazdan ben bu CustomAdapter'ı mainActivity içerisinde cağırdığımda bu constructor cağrılcak ve herşey birbirine bağlanmış olucak
ne gibi
misal geliyim mainActivit.javaclass'a onCreate altında.
    Kod zamanı 2
    1)CustomAdapter customAdapter = new CustomAdapter(comicsList,MainActivity.this);
1.Kodun açıklaması () içerisinde benden ne istiyor bir comics listesi istiyor burda hazır szaten daha önce eklemiştim.
comicsList, iki Activity istiyor    işte activity'i bu yüzden buraya koyduk ve ben buraya MainActivity.this'i verdiğimde.
artık bu activity'de bütün bu yaptığım getLayout ınflater vs calıştırılcak ve
    2)listView.setAdapter(customAdapter);
2.Kodun açıklaması - Bu şekildede dersem artık herşey birbirine bağlanmış olucak
Deniyelim hatta ands çalıştıralım görebiliyormuyuz bu isimleri şunu düsünebiliriz.
Biz isimleri 2 dakikada göstermiştik listede amma complex hale geldi ama şu aklımızda olsun gerçektne oop prensiplerini izliyerek modeller kurarak bu şekilde
uygulamalar yazabiliyoruz ve özellikle proffesionel dünyaya atılırsak görücezki herkes bu şekilde yapıyor uygulamalarını ve keza eklediğim isimler burda cıkıyor
biz yani burda modelimizin bir objesini ve objenin bir propert'sini görebilidik şimdi ne kaldı geriye tıklanınca diğer tarafa gitmek diğer tarafa bu bilgiyi modelin kendisini hatta aktarmak
ve diğer tarafta detaylarını göstermek şimdi esas oop'nin faydalı oldugu nokta burda baslıyor bu dakikadan itibaren şuan bütün yapıyı biz kurduk şimdi bundan sonrası bizim için çok kolay olucak
 Sıradaki Aşama "SerileştirmekNot"
 */