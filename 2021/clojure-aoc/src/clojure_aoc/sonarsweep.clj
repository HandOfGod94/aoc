(ns clojure-aoc.sonarsweep)

(defn calc-increment [& depths]
  (->> depths
       (flatten)
       (map #(Integer/parseInt %))
       (partition 2 1)
       (filter #(< (first %) (second %)))
       count))
