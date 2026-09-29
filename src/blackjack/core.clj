(ns blackjack.core (:require [blackjack.cards :as cards]))

(defn cards-value [card]
  (case card
    "J" 10
    "Q" 10
    "K" 10
    "A" 1
    card))

(defn hand-value [hand]
  (let [value (reduce + (map cards-value hand))]
    (if (and (contains? (set hand) "A")
             (<= value 11))
      (+ value 10)
      value)))

(defn calculate-bust-cards [hand first-row]
  ;maakt een functie aan die de hand mee krijgt en een vector aan kaarten
  (if (empty? first-row)
    []
    ;zorgt ervoor dat als de vector leeg is de functie stopt en een lege vector terug geeft.
    (let [card (first first-row)]
      ;slaat tijdelijk de eerste kaart van de vector op in een variable.
      (if (> (hand-value (conj (vec hand) card)) 21)
        ; maakt van de hand een vector en voegt de card toe aan de hand. vervolgens gaat het door de hand-value functie heen en kijkt of het groter dan 21 is.
        (conj (calculate-bust-cards hand (rest first-row)) card)
        ; Als de kaart een bust veroorzaakt: controleer recursief de overige kaarten en voeg deze kaart toe aan
        (calculate-bust-cards hand (rest first-row))))))
        ; Als de kaart geen bust veroorzaakt: controleer alleen de overige kaarten.

(let [deck (cards/shuffle-deck (cards/create-deck))
      [current-hand] (cards/draw-hand deck)]


  (println "Hand:" current-hand)
  (println "Waarde:" (hand-value current-hand))
  (println "Bust kaarten:" (calculate-bust-cards current-hand (first cards/card-numbers))))