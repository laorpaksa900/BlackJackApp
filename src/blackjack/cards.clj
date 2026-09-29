(ns blackjack.cards)
(def card-numbers
  [["A" "A" "A" "A"]
   [2 2 2 2]
   [3 3 3 3]
   [4 4 4 4]
   [5 5 5 5]
   [6 6 6 6]
   [7 7 7 7]
   [8 8 8 8]
   [9 9 9 9]
   [10 10 10 10]
   ["J" "J" "J" "J"]
   ["Q" "Q" "Q" "Q"]
   ["K" "K" "K" "K"]])

(defn create-deck []
  (flatten card-numbers))

(defn shuffle-deck [deck]
  (shuffle deck))

(defn draw-hand [deck]
  [(take 2 deck)
   (drop 2 deck)])
