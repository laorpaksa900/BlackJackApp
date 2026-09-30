## 1. Wat is Clojure?

Clojure is gebaseerd op Lisp, een oude programmeertaal. Clojure richt zich op functioneel programmeren en biedt hulpmiddelen om mutable state te vermijden. Daarnaast draait Clojure op de JVM en ondersteunt het samenwerking met Java. – [Rationale](https://clojure.org/about/rationale)

## 2. Zuiverheid (Pure Functions)

Een **pure function** geeft bij dezelfde input dezelfde output en veroorzaakt geen veranderingen buiten de functie.

```clojure
(defn add [a b]
  (+ a b))
```

`(add 5 10)` geeft steeds `15`.

Clojure biedt hulpmiddelen om mutable state te vermijden, maar verplicht programma's niet om volledig puur te zijn. – [Functional Programming](https://clojure.org/about/functional_programming)

## 3. First-class Functions

In Clojure zijn functies **first-class**. Dit betekent onder andere dat functies kunnen worden opgeslagen, meegegeven als argument en teruggegeven vanuit andere functies. – [First-class functions](https://clojure.org/about/functional_programming#_first_class_functions)

```clojure
(defn bereken [functie a b]
  (functie a b))

(bereken + 5 10)
;; 15

(bereken * 5 10)
;; 50
```

Hier worden `+` en `*` als waarden meegegeven aan de functie `bereken`. De parameter `functie` verwijst vervolgens naar de meegegeven functie en voert deze uit met `a` en `b`.
## 4. Higher-order Functions

Een **higher-order function** is een functie die een andere functie als argument ontvangt of een functie teruggeeft. – [Higher Order Functions](https://clojure.org/guides/higher_order_functions)

```clojure
(map inc [1 2 3])
;; (2 3 4)
```

Hier ontvangt `map` de functie `inc`. Clojure heeft verschillende functies voor het verwerken van sequences, waaronder `map`, `filter` en `reduce`. – [Sequences](https://clojure.org/reference/sequences)

## 5. Immutability

**Immutability** betekent dat een waarde na het aanmaken niet wordt veranderd. In plaats van bestaande data te wijzigen, wordt een nieuwe waarde gemaakt.

Clojure biedt immutable persistent datastructuren, waaronder lists, vectors, maps en sets. – [Immutable Data Structures](https://clojure.org/about/functional_programming#_immutable_data_structures)

```clojure
(def hand [10 5])

(conj hand 7)
;; [10 5 7]

hand
;; [10 5]
```

`conj` geeft hier een nieuwe vector terug. De originele `hand` blijft `[10 5]`.

## 6. Recursie

Bij **recursie** roept een functie zichzelf opnieuw aan om een berekening te herhalen.

Clojure ondersteunt recursieve herhaling met `recur`. Een `recur` naar een `loop` of functie gebruikt geen extra stackruimte. – [Recursive Looping](https://clojure.org/about/functional_programming#_recursive_looping)

```clojure
(defn countdown [n]
  (when (> n 0)
    (println n)
    (recur (dec n))))
```

De functie blijft zichzelf met een lagere waarde herhalen totdat `n` niet meer groter is dan `0`.

## 7. Lazy Evaluation

Bij **lazy evaluation** wordt een berekening uitgesteld totdat het resultaat nodig is.

Clojure ondersteunt lazy sequences. Functies zoals `map` en `filter` kunnen lazy sequences teruggeven. – [Sequences](https://clojure.org/reference/sequences)

```clojure
(take 5 (range))
;; (0 1 2 3 4)
```

`take` vraagt hier alleen de eerste vijf elementen van de sequence op.

## 8. Pattern Matching

**Pattern matching** wordt gebruikt om data te herkennen aan de hand van een bepaald patroon.

De officiële Clojure-documentatie die voor dit onderzoek is gebruikt beschrijft **destructuring**: hiermee kunnen waarden uit een datastructuur aan lokale namen worden gekoppeld. – [What is Destructuring?](https://clojure.org/guides/destructuring#_what_is_destructuring)

```clojure
(let [[soort waarde] ["Harten" 10]]
  (println soort waarde))
```

Hier koppelt destructuring `"Harten"` aan `soort` en `10` aan `waarde`.

## 9. Bronnen

- [Clojure – Rationale](https://clojure.org/about/rationale)
- [Clojure – Functional Programming](https://clojure.org/about/functional_programming)
- [Clojure – Higher Order Functions](https://clojure.org/guides/higher_order_functions)
- [Clojure – Sequences](https://clojure.org/reference/sequences)
- [Clojure – Destructuring](https://clojure.org/guides/destructuring)