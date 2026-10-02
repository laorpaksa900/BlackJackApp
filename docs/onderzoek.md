# Onderzoek Clojure

## 1. Wat is Clojure?

Clojure is een programmeertaal die gebaseerd is op Lisp, een van de oudere programmeertalen. Clojure richt zich voornamelijk op functioneel programmeren en biedt hulpmiddelen om mutable state te vermijden. Daarnaast draait Clojure op de Java Virtual Machine (JVM), waardoor Clojure kan samenwerken met Java.

Bron: [Clojure – Rationale](https://clojure.org/about/rationale)

---

## 2. Zuiverheid (Pure Functions)

Een **pure function** is een functie die bij dezelfde input altijd dezelfde output geeft en geen veranderingen buiten de functie veroorzaakt.

```clojure
(defn add [a b]
  (+ a b))

(add 5 10)
;; 15
```

De functie `add` krijgt twee waarden binnen en geeft het resultaat van de optelling terug. `(add 5 10)` zal hierdoor steeds `15` teruggeven.

Clojure biedt hulpmiddelen om mutable state te vermijden, maar verplicht programma's niet om volledig puur te zijn.

Bron: [Clojure – Functional Programming](https://clojure.org/about/functional_programming)

---

## 3. First-class Functions

In Clojure zijn functies **first-class**. Dit betekent onder andere dat functies als waarden kunnen worden gebruikt. Ze kunnen bijvoorbeeld worden meegegeven als argument aan een andere functie en worden teruggegeven vanuit een functie.

```clojure
(defn bereken [functie a b]
  (functie a b))

(bereken + 5 10)
;; 15

(bereken * 5 10)
;; 50
```

Hier worden `+` en `*` als waarden meegegeven aan de functie `bereken`. De parameter `functie` verwijst vervolgens naar de meegegeven functie en voert deze uit met `a` en `b`.

Bron: [Clojure – First-class Functions](https://clojure.org/about/functional_programming#_first_class_functions)

---

## 4. Higher-order Functions

Een **higher-order function** is een functie die een andere functie als argument ontvangt of een functie teruggeeft.

Een voorbeeld hiervan is `map`:

```clojure
(map inc [1 2 3])
;; (2 3 4)
```

Hier ontvangt `map` de functie `inc` als argument. `inc` verhoogt iedere waarde met één. Hierdoor worden de waarden `1`, `2` en `3` omgezet naar `2`, `3` en `4`.

Clojure heeft verschillende functies voor het verwerken van sequences, waaronder `map`, `filter` en `reduce`.

Bronnen:  
[Clojure – Higher Order Functions](https://clojure.org/guides/higher_order_functions)  
[Clojure – Sequences](https://clojure.org/reference/sequences)

---

## 5. Immutability

**Immutability** betekent dat een waarde na het aanmaken niet wordt veranderd. In plaats van bestaande data aan te passen, wordt een nieuwe waarde gemaakt.

Clojure biedt immutable persistent datastructuren, waaronder lists, vectors, maps en sets.

```clojure
(def hand [10 5])

(conj hand 7)
;; [10 5 7]

hand
;; [10 5]
```

`conj` geeft hier een nieuwe vector terug met de waarde `7` toegevoegd. De originele `hand` wordt niet aangepast en blijft `[10 5]`.

Bron: [Clojure – Immutable Data Structures](https://clojure.org/about/functional_programming#_immutable_data_structures)

---

## 6. Recursie

Bij **recursie** roept een functie zichzelf opnieuw aan om een berekening te herhalen.

Clojure ondersteunt recursieve herhaling met `recur`. Een `recur` naar een functie of `loop` gebruikt geen extra stackruimte.

```clojure
(defn countdown [n]
  (when (> n 0)
    (println n)
    (recur (dec n))))
```

Bij bijvoorbeeld:

```clojure
(countdown 3)
```

wordt het volgende weergegeven:

```text
3
2
1
```

Na iedere uitvoering wordt `n` met één verlaagd door `(dec n)`. Met `recur` wordt de functie vervolgens opnieuw uitgevoerd met deze nieuwe waarde. Dit blijft doorgaan totdat `n` niet meer groter is dan `0`.

Bron: [Clojure – Recursive Looping](https://clojure.org/about/functional_programming#_recursive_looping)

---

## 7. Lazy Evaluation

Bij **lazy evaluation** wordt een berekening uitgesteld totdat het resultaat daadwerkelijk nodig is.

Clojure gebruikt hiervoor onder andere **lazy sequences**. Bij een lazy sequence worden waarden pas berekend wanneer ze nodig zijn. Functies zoals `map` en `filter` kunnen lazy sequences teruggeven.

Een eenvoudig voorbeeld is:

```clojure
(take 5 (range))
;; (0 1 2 3 4)
```

`(range)` kan een oneindige sequence van getallen produceren. Met `take` worden hier alleen de eerste vijf waarden opgevraagd. Hierdoor hoeft niet de volledige sequence berekend te worden.

Een ander voorbeeld is het combineren van `map` met `take`:

```clojure
(take 5 (map inc (range)))
;; (1 2 3 4 5)
```

`map` past hier `inc` toe op de waarden uit `(range)`. Omdat het resultaat lazy is en met `take` alleen om vijf waarden wordt gevraagd, worden alleen de benodigde resultaten gerealiseerd.

Lazy evaluation is dus het **uitstellen van een berekening totdat het resultaat nodig is**. Een lazy sequence is een sequence die van dit principe gebruikmaakt.

Bron: [Clojure – Sequences](https://clojure.org/reference/sequences)

---

## 8. Pattern Matching

**Pattern matching** wordt gebruikt om data te herkennen aan de hand van een bepaald patroon en op basis daarvan verschillende acties uit te voeren.

Clojure heeft geen ingebouwde algemene pattern-matchingfunctionaliteit zoals sommige andere functionele programmeertalen. Clojure heeft wel mogelijkheden zoals **destructuring**, `case` en `cond` waarmee data kan worden verwerkt en verschillende situaties kunnen worden afgehandeld.

Een eenvoudig voorbeeld met `case` is:

```clojure
(defn kaart-waarde [kaart]
  (case kaart
    "Aas" 11
    "Koning" 10
    "Vrouw" 10
    "Boer" 10
    kaart))
```

Bijvoorbeeld:

```clojure
(kaart-waarde "Koning")
;; 10

(kaart-waarde 7)
;; 7
```

Hier kijkt `case` naar de waarde van `kaart`. Wanneer de waarde overeenkomt met `"Aas"`, `"Koning"`, `"Vrouw"` of `"Boer"`, wordt de bijbehorende kaartwaarde teruggegeven. Wanneer er geen overeenkomst is, wordt `kaart` zelf teruggegeven.

Voor het uit elkaar halen van datastructuren biedt Clojure daarnaast destructuring:

```clojure
(let [[kaart1 kaart2] ["Aas" "Koning"]]
  (println kaart1)
  (println kaart2))
```

Hier worden de eerste en tweede waarde uit de vector gekoppeld aan `kaart1` en `kaart2`.

Bron: [Clojure – Destructuring](https://clojure.org/guides/destructuring)

---

## 9. Bronnen
- [onderzoek support](https://chatgpt.com/share/6abf9637-faa8-83eb-9b42-0052a91d3dc2)
- [Clojure – Rationale](https://clojure.org/about/rationale)
- [Clojure – Functional Programming](https://clojure.org/about/functional_programming)
- [Clojure – Higher Order Functions](https://clojure.org/guides/higher_order_functions)
- [Clojure – Sequences](https://clojure.org/reference/sequences)
- [Clojure – Destructuring](https://clojure.org/guides/destructuring)