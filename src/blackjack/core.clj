(ns blackjack.core (:require [blackjack.cards :as cards]))

(defn cards-value [card]
  (case card
    "J" 10
    "Q" 10
    "K" 10
    "A" 1
    card))
;veranderd de kaarten in hun waarde, zodat de kaarten in de hand opgeteld kunnen worden.
(defn hand-value [hand]
  ;maakt een functie aan die de totale waarde van de hand berekent.
  (let [value (reduce + (map cards-value hand))]
    ;zet elke kaart om naar zijn waarde met cards-value en telt daarna alle waardes bij elkaar op.
    (if (and (contains? (set hand) "A")
             (<= value 11))
      ;controleert of er een aas in de hand zit en of de aas als 11 gebruikt kan worden zonder boven de 21 te komen.
      (+ value 10)
      ;als de aas als 11 gebruikt kan worden, wordt er 10 bij de waarde opgeteld omdat de aas eerst als 1 is berekend.
      value)))
;als de aas niet als 11 gebruikt kan worden, wordt de normale waarde van de hand teruggegeven.

(defn calculate-bust-cards [hand first-row]
  ;maakt een functie aan die de hand mee krijgt en een vector aan kaarten
  (loop [remaining-row first-row
         bust-cards []]
    ;maakt een loop met de kaarten en een lege bust-cards vector, zodat recur met nieuwe waarden terug naar dit punt kan gaan.
    (if (empty? remaining-row)
      bust-cards
      ;zorgt ervoor dat als de vector leeg is de functie stopt en de bust-cards vector terug geeft.
      (let [card (first remaining-row)]
        ;slaat tijdelijk de eerste kaart van de vector op in een variable.
        (if (> (hand-value (conj (vec hand) card)) 21)
          ;maakt van de hand een vector en voegt de card toe aan de hand. vervolgens gaat het door de hand-value functie heen en kijkt of het groter dan 21 is.
          (recur (rest remaining-row) (conj bust-cards card))
          ;als de kaart een bust veroorzaakt: voeg de kaart toe aan bust-cards en controleer de overige kaarten.
          (recur (rest remaining-row) bust-cards))))))
          ;als de kaart geen bust veroorzaakt: controleer alleen de overige kaarten.

(defn count-used-bust-cards [hand bust-cards]
  ;maakt een functie aan die de hand mee krijgt en de bust-cards vector
  (loop [remaining-hand hand
         counter 0]
    ;maakt een loop met de hand en een counter die bij 0 begint, zodat recur met nieuwe waarden terug naar dit punt kan gaan.
    (if (empty? remaining-hand)
      counter
      ;zorgt ervoor dat als de hand leeg is de functie stopt en de counter terug geeft.
      (let [card (first remaining-hand)]
        ;slaat tijdelijk de eerste kaart van de hand op in een variable.
        (if (contains? (set bust-cards) card)
          ;veranderd de bust-cards vector in een set en kijkt of de kaart in de set zit.
          (recur (rest remaining-hand) (inc counter))
          ;als de kaart in de set zit: ga verder met de rest van de hand en tel 1 op bij de counter.
          (recur (rest remaining-hand) counter))))))
          ;als de kaart niet in de set zit: ga verder met de rest van de hand zonder de counter te verhogen.

(defn calculate-bust-count [hand bust-cards]
  (- (* (count bust-cards) 4) (count-used-bust-cards hand bust-cards)))
;vermenigvuldigt het aantal bust-cards met 4 (omdat er 4 van elke kaart in het deck zitten) en trekt daar het aantal kaarten dat al in de hand zit vanaf als de hand bust-kaarten bezit.


(let [deck (cards/shuffle-deck (cards/create-deck))
      [current-hand deck-after-draw] (cards/draw-hand deck)
      busted-cards (calculate-bust-cards current-hand (first cards/card-numbers))]


  (println "Hand:" current-hand)
  (println "Waarde:" (hand-value current-hand))
  (println "Bust kaarten:" (calculate-bust-cards current-hand (first cards/card-numbers)))
  (println "Aantal bust kaarten:" (calculate-bust-count current-hand busted-cards))
  (println "Deck na draw:" deck-after-draw)
  (println "kans op busten: %" (int (*(/ (calculate-bust-count current-hand busted-cards) (count deck-after-draw))100))))
;final calculation to calculate the chance of busting by dividing the amount of bust cards left in the deck by the amount of cards left in the deck and multiplying it by 100 to get a percentage.