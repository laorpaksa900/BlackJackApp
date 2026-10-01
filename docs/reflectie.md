# Reflectie

## Toegepaste functionele concepten

Tijdens het maken van mijn Blackjack-project heb ik een aantal functionele concepten toegepast.

De belangrijkste concepten die ik heb gebruikt zijn `recursion`, `pure functions`, `higher-order functions` en `immutability`.

Een voorbeeld van een pure function in mijn programma is `cards-value`. Deze functie krijgt een kaart binnen en geeft de bijbehorende numerieke waarde terug. De functie verandert geen gegevens buiten de functie en geeft bij dezelfde invoer steeds hetzelfde resultaat.

Higher-order en first-class functions komen bijvoorbeeld terug bij het gebruik van `map`. Ik geef `cards-value` als functie mee aan `map`, zodat de kaarten uit een hand kunnen worden omgezet naar numerieke waarden.

Immutability komt terug doordat bestaande collecties niet direct worden aangepast. Wanneer bijvoorbeeld een kaart aan een hand wordt toegevoegd, wordt met `conj` een nieuwe collectie gemaakt.

Voor herhalingen heb ik onder andere `loop` en `recur` gebruikt. Hiermee kon ik door de kaarten heen gaan zonder hiervoor een traditionele `for`- of `while`-loop te gebruiken.

## Wat vond ik handig?

Toen ik begon met Clojure vond ik het erg lastig om te gebruiken, omdat ik een groot deel van de manier waarop ik normaal over code nadenk moest aanpassen. Dit kwam vooral doordat de syntax anders werkt dan ik gewend ben. Een goed voorbeeld hiervan is dat operatoren zoals `+`, `*` en `-` vooraan staan bij een berekening.

Later realiseerde ik me dat Clojure veel handige ingebouwde functies heeft waarmee bepaalde dingen juist makkelijker kunnen worden gedaan. Een voorbeeld hiervan is `recur`. Hiermee kun je makkelijk een functie of loop opnieuw uitvoeren met nieuwe waarden. Ook simpele functies zoals `take` en `drop` zijn handig om een deel van een collectie te pakken of juist over te slaan.

Functies zoals `map`, `reduce` en `filter` zijn handig voor het verwerken van collecties. In plaats van zelf voor alles een loop te schrijven, kan ik aangeven welke bewerking op de gegevens uitgevoerd moet worden.

Immutability vond ik ook interessant. Omdat bestaande gegevens niet steeds worden aangepast, is het duidelijker welke waarde een functie binnenkrijgt en welke nieuwe waarde eruit komt. Een goed voorbeeld hiervan is dat ik een functie heb gemaakt die kaarten uit het deck in de hand stopt en daarna een nieuw deck teruggeeft zonder de kaarten die zijn gepakt. Omdat het een immutable datastructuur is, wordt het originele deck niet direct aangepast en werk ik verder met een nieuwe versie van het deck.

## Wat vond ik lastig?

In het begin vond ik de syntax van Clojure lastig om te lezen. Ik ben meer gewend aan talen zoals Java en JavaScript, waarbij functies, variabelen en loops op een andere manier worden geschreven.

Vooral `loop` en `recur` vond ik in het begin lastiger dan een normale `for`- of `while`-loop. Bij `recur` moest ik anders nadenken over herhaling. In plaats van een bestaande variabele steeds aan te passen, geef je nieuwe waarden mee aan de volgende uitvoering.

Ook het grote aantal haakjes in Clojure maakte het in het begin moeilijker om te zien welke stukken code bij elkaar horen. Vooral wanneer meerdere `if`, `let` en andere functies in elkaar staan, kan één verkeerd haakje al voor een fout zorgen.

## Vergelijking met objectgeoriënteerd programmeren

Bij objectgeoriënteerd programmeren zou ik het Blackjack-algoritme waarschijnlijk sneller hebben geschreven, omdat ik daar al meer ervaring mee heb. Ik zou dan eerder gebruikmaken van variabelen en loops waarbij waarden tijdens de uitvoering worden aangepast.

In Java zou ik bijvoorbeeld eerder een `for`-loop gebruiken om door kaarten heen te lopen en een variabele gebruiken om het aantal bust-kaarten bij te houden. In Clojure wordt dit vaker opgelost door functies en nieuwe waarden te gebruiken. Ondanks dat vind ik wel dat je met Clojure voor sommige bewerkingen minder code hoeft te schrijven.

Bij objectgeoriënteerd programmeren zou ik waarschijnlijk classes maken voor bijvoorbeeld een `Card`, `Deck` en `Hand`. Deze objecten zouden vervolgens hun eigen gegevens kunnen bevatten en aanpassen. In mijn Clojure-oplossing bestaan deze gegevens voornamelijk uit datastructuren die door functies worden verwerkt.

Ik merkte daardoor dat functioneel programmeren een andere manier van nadenken vereist. Bij objectgeoriënteerd programmeren denk ik sneller na over objecten en hun verantwoordelijkheden, terwijl ik bij Clojure meer moest nadenken over het verwerken en omzetten van data met functies.

## Wat heb ik geleerd?

Voor deze challenge had ik nog weinig ervaring met Clojure. Tijdens het maken van het Blackjack-algoritme heb ik vooral geleerd hoe Clojure werkt en hoe je problemen op een andere manier kunt oplossen dan ik gewend ben vanuit bijvoorbeeld Java.

Ik heb geleerd om te werken met `map`, `reduce`, `loop` en `recur`. Ook heb ik geleerd dat je in Clojure meestal niet steeds de waarde van een variabele verandert, maar met nieuwe waarden verder werkt. Vooral `loop` en `recur` vond ik in het begin lastig, maar door deze te gebruiken voor het controleren van de kaarten begrijp ik nu beter hoe ze werken.

Mijn oorspronkelijke plan had nog een tweede doel: meerdere Blackjack-strategieën simuleren en daarna de winstpercentages vergelijken. Dit heb ik uiteindelijk niet meer geïmplementeerd. Hierdoor is mijn challenge kleiner geworden dan ik eerst had bedacht. Wel heb ik met het berekenen van de kans om bust te gaan verschillende onderdelen van Clojure kunnen gebruiken die ik tijdens mijn onderzoek heb geleerd.