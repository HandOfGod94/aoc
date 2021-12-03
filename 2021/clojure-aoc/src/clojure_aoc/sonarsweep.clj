(ns clojure-aoc.sonarsweep)

(defn calc-increment [& depths]
  (->> depths
       (flatten)
       (map #(Integer/parseInt %))
       (partition 2 1)
       (filter #(< (first %) (second %)))
       count))

(defn calc-increment-window [& depths]
  (->> depths
       (flatten)
       (map #(Integer/parseInt %))
       (partition 3 1)
       (reduce #(conj %1 (reduce + %2)) [])
       (partition 2 1)
       (filter #(< (first %) (second %)))
       count))
