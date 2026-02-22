# 🏎️ F1 Velké Finále

**✨ Hlavní lákadla hry:**
* Textová hra z prostředí Formule 1
* Napínavý příběh před posledním závodem o titul
* Opravování auta, rozhovory s inženýrem a ladění strategie
* Vlastní kvalifikace (kvíz) a strategický závod na 20 kol
* Dynamické počasí a safety car!

### O hře
Hrajete za jezdce, který má před úplně posledním závodem sezony v Abu Dhabí naprosto stejný počet bodů jako jeho největší rival Max. Vaším úkolem je připravit auto v garáži, projít kvalifikací a pak samotný závod vyhrát a získat titul mistra světa.

Před závodem a kvalifikací musíte nejdřív splnit pár úkolů. Není to jen tak, že přijdete a hned jedete. Musíte najít nářadí a opravit volant, dojít do technického centra s USB diskem stáhnout data, zjistit si z tabletu ideální strategii, nastavit podle toho křídlo u auta, bavit se s inženýrem a taky sehnat svoji helmu a rukavice. Jinak vás mechanik prostě do auta nepustí.

### ✍️ Autor
Jmenuji se Halas (Jiří Halásek) a tohle je moje hra o F1. Hru jsem dělal pro školní projekt

---

## 🚀 Jak to ovládat 

Hra se hraje tak, že píšete příkazy do konzole. Tady je seznam těch základních, co budete v paddocku a místnostech potřebovat k chození a sbírání věcí:

* `jdi [mistnost]` - přesune vás to jinam (např. jdi garaz)
* `prozkoumej` - vypíše co je zrovna v místnosti za věci a jestli tam někdo stojí
* `vezmi [vec]` - seberete věc ze země do batohu (např. vezmi helma)
* `zahod [vec]` - vyhodí věc z batohu na zem, kdybyste měli plno a potřebovali místo
* `batoh` - ukáže co máte zrovna u sebe a kolik je tam místa
* `mluv [jmeno]` - začnete se bavit s postavou (např. mluv james)
* `pouzij [vec]` - použije věc z batohu (např. naradi opraví auto)
* `nastav kridlo [cislo]` - nastavení aerodynamiky auta 
* `mapa` - ukáže vám mapu okruhu
* `napoveda` - vypíše nápovědu ke hře

Když všechno splníte a napíšete `jdi pitlane`, hra se přepne do další fáze a staré příkazy přestanou fungovat. Místo nich budete odpovídat na otázky nebo zadávat příkazy pro jízdu v autě.

---

## 🎭 Rozhovory a Postavy

Ve hře potkáte několik postav. Váš inženýr **James** vám říká co máte zrovna dělat a posouvá příběh. Pak je tam PR manažerka **Sarah**, se kterou musíte povinně udělat rozhovor (jinak nemůžete do závodu). Je to udělané tak, že se vás ptá a vy odpovídáte jak chcete. Taky si můžete jít popovídat s **Maxem** (rivalem) nebo **Christianem** (šéfem týmu), kde vybíráte z možností A, B nebo C. Z toho se dá občas získat dobrá rada k závodu.

---

## 🏁 Herní mechaniky a Závod

Ve hře je toho docela dost. Máte inventář s omezenou kapacitou. Další důležitá mechanika je samotná **kvalifikace**, což je takový kvíz na body ohledně F1. Začínáte automaticky jako druzí za Maxem. Dostanete 10 otázek a za každou špatnou odpověď (A, B nebo C) klesnete na startovním roštu o jedno místo dolů.

**Závod** se pak jede na 20 kol a to je asi ta nejsložitější část hry. Na začátku si vyberete gumy (Soft, Medium, Hard). Každá guma se jinak rychle ničí a máte na ní jinou šanci na předjetí.

V každém kole pak volíte tempo: `zrychli`, `neutral`, `setri` nebo `box` pro zastávku u mechaniků. Ničí se vám pneumatiky podle toho jak moc na to šlapete. Hra taky náhodně generuje události – může se stát, že začne pršet (pak musíte hned do boxů pro gumy WET, jinak ztrácíte kontrolu nad autem) nebo vyjede safety car. Když si ty gumy sjedete na 0%, tak vám bouchnou a celá hra končí prohrou.

---

## ⬇️ Jak hru spustit

Stáhnete soubor `.jar`, tak ho většinou stačí jen dvakrát prokliknout (pokud máte nainstalovanou Javu). Kdyby to nešlo, stačí si otevřít terminál nebo příkazovou řádku ve složce, kde soubor leží, a napsat tenhle příkaz:

java -jar nazev_souboru.jar   