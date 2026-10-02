(ns blackjack.cards)
(def card-numbers
  [["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]
   ["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]
   ["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]
   ["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]])

(defn create-deck []
  (flatten card-numbers))
;maakt de vier vectors met kaarten in card-numbers tot één lijst met alle 52 kaarten.
(defn shuffle-deck [deck]
  (shuffle deck))
;shuffled het deck zodat de kaarten in een random volgorde komen te staan.
(defn draw-hand [deck]
  [(take 2 deck)
   (drop 2 deck)])
;haalt de eerste 2 kaarten uit het deck en geeft de rest van het deck terug.