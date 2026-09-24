(ns blackjack.core)

(def hand [10 4 5])

(defn hand-value [hand]
      (reduce + hand))

(defn -main []
      (println (hand-value hand)))