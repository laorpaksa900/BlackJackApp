(ns blackjack.core)
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

(let [deck (cards/shuffle-deck (cards/create-deck))
      [current-hand remaining-deck] (cards/draw-hand deck)]

  (println "Hand:" current-hand)
  (println "Waarde:" (hand-value current-hand))
  (println "Deck over:" remaining-deck))