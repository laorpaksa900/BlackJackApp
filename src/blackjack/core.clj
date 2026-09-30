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

(defn count-used-bust-cards [hand bust-cards]
  ;maakt een functie aan die de hand mee krijgt en de bust-cards vector
  (if (empty? hand)
    0
    ;zorgt ervoor dat als de hand leeg is de functie stopt en 0 terug geeft.
    (let [card (first hand)]
      ;slaat tijdelijk de eerste kaart van de hand op in een variable.
      (if (contains? (set bust-cards) card)
        ;veranderd de bust-cards vector in een set en kijkt of de kaart in de set zit.
        (+ 1 (count-used-bust-cards (rest hand) bust-cards))
        ;als de kaart in de set zit: tel 1 op bij het resultaat.
        (count-used-bust-cards (rest hand) bust-cards)))))
        ;als de kaart niet in de set zit: ga verder met de rest van de hand.

(defn calculate-bust-count [hand bust-cards]
  (- (* (count bust-cards) 4) (count-used-bust-cards hand bust-cards)))

(let [deck (cards/shuffle-deck (cards/create-deck))
      [current-hand deck-after-draw] (cards/draw-hand deck)
      busted-cards (calculate-bust-cards current-hand (first cards/card-numbers))]


  (println "Hand:" current-hand)
  (println "Waarde:" (hand-value current-hand))
  (println "Bust kaarten:" (calculate-bust-cards current-hand (first cards/card-numbers)))
  (println "Aantal bust kaarten:" (calculate-bust-count current-hand busted-cards))
  (println "Deck na draw:" deck-after-draw)
  (println "kans op busten:" (float (*(/ (calculate-bust-count current-hand busted-cards) (count deck-after-draw))100))))
;final calculation to calculate the chance of busting by dividing the amount of bust cards left in the deck by the amount of cards left in the deck and multiplying it by 100 to get a percentage.