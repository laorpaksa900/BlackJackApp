(ns blackjack.cards)
(def card-numbers
  [["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]
   ["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]
   ["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]
   ["A" 2 3 4 5 6 7 8 9 10 "J" "Q" "K"]])

(defn create-deck []
  (flatten card-numbers))

(defn shuffle-deck [deck]
  (shuffle deck))

(defn draw-hand [deck]
  [(take 2 deck)
   (drop 2 deck)])
