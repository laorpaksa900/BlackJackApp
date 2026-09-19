# Wat voor methodes zijn er in Clojure waarvan ik denk dat het nodig is om ze te begrijpen?

## Define (`defn`)

Bron: https://clojuredocs.org/clojure.core/defn

`defn` wordt gebruikt om een functie te definiëren. Zover ik het begrijp is dit een manier om een functie aan te maken. In Java zou je hiervoor bijvoorbeeld een methode kunnen aanmaken.

Voorbeeld Clojure:

```clojure
(defn add [a b]
  (+ a b))
```

Voorbeeld Java:

```java
public int add(int a, int b) {
    return a + b;
}
```

Een verschil is dat Clojure niet op dezelfde manier `return` gebruikt als Java. De waarde van de laatste expressie van de functie wordt teruggegeven. In het voorbeeld is dit `(+ a b)`.

## Recursion (`recur`)

Bron: https://clojuredocs.org/clojure.core/recur

`recur` zorgt ervoor dat de parameters nieuwe waarden krijgen en dat de uitvoering verdergaat vanaf het recursion point.

```clojure
(defn countdown [n]
  (if (= n 0)
    0
    (recur (- n 1))))
```

In dit voorbeeld wordt eerst gecontroleerd of `n` gelijk is aan `0`.

Als `n` nog niet `0` is, wordt:

```clojure
(recur (- n 1))
```

uitgevoerd. `n` krijgt hierdoor bij het recursion point een nieuwe binding met een waarde die één lager is.

De `if (= n 0)` werkt hier als de **base case**. Wanneer `n` gelijk is aan `0`, wordt `recur` niet meer uitgevoerd en stopt de recursie.

Een verschil met normale recursie, bijvoorbeeld in Java, is dat `recur` geen nieuwe stack frame aanmaakt voor iedere herhaling. Hierdoor kan `recur` worden gebruikt voor recursie zonder dat de stack bij iedere herhaling groter wordt.

Voorbeeld Java met normale recursie:

```java
public int countdown(int n) {
    if (n == 0) {
        return 0;
    }

    return countdown(n - 1);
}
```

## Conditional (`cond`)

Bron: https://clojuredocs.org/clojure.core/cond

`cond` wordt gebruikt wanneer er meerdere condities gecontroleerd moeten worden. De condities worden van boven naar beneden gecontroleerd. Wanneer een conditie waar is, wordt de bijbehorende expressie uitgevoerd.

Voorbeeld Clojure:

```clojure
(defn check-score [score]
  (cond
    (> score 21) "Bust"
    (= score 21) "Blackjack"
    :else "Safe"))
```

Voorbeeld Java:

```java
public String checkScore(int score) {
    if (score > 21) {
        return "Bust";
    } else if (score == 21) {
        return "Blackjack";
    } else {
        return "Safe";
    }
}
```

## Local bindings (`let`)

Bron: https://clojuredocs.org/clojure.core/let

`let` wordt gebruikt om lokale waarden aan een naam te binden. Deze bindings kunnen vervolgens binnen de `let` worden gebruikt.

Voorbeeld Clojure:

```clojure
(defn calculate []
  (let [a 10
        b 5]
    (+ a b)))
```

## Map (`map`)

Bron: https://clojuredocs.org/clojure.core/map

`map` voert een functie uit op ieder element van een collection.

Voorbeeld Clojure:

```clojure
(map inc [1 2 3])
```

Resultaat:

```clojure
(2 3 4)
```

## Filter (`filter`)

Bron: https://clojuredocs.org/clojure.core/filter

`filter` wordt gebruikt om alleen de elementen uit een collection te behouden die aan een bepaalde conditie voldoen.

Voorbeeld Clojure:

```clojure
(filter even? [1 2 3 4 5 6])
```

Resultaat:

```clojure
(2 4 6)
```

## Reduce (`reduce`)

Bron: https://clojuredocs.org/clojure.core/reduce

`reduce` wordt gebruikt om de elementen van een collection te verwerken tot één resultaat.

Voorbeeld Clojure:

```clojure
(reduce + [10 5 3])
```

Resultaat:

```text
18
```

Bij Blackjack zou `reduce` bijvoorbeeld gebruikt kunnen worden om de totale waarde van een hand te berekenen.

```clojure
(defn hand-total [hand]
  (reduce + hand))
```

Als de hand `[10 5 3]` is, geeft `hand-total` als resultaat `18`.

## function (`fn`)

Bron: https://clojuredocs.org/clojure.core/fn

`fn` wordt gebruikt om een functie te maken zonder deze met `defn` een naam te geven.

Voorbeeld Clojure:

```clojure
(map (fn [x] (* x 2)) [1 2 3])
```

Resultaat:

```clojure
(2 4 6)
```

## Extra notes
Berekeningen in clojure beginnen met een operator, bijvoorbeeld `(+ 1 2)` in plaats van `1 + 2`.

