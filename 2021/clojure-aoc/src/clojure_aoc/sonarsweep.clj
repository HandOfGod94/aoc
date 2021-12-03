(ns clojure-aoc.sonarsweep)

(defn calc-increment [depths]
  (->> depths
       (partition 2 1)
       (filter #(< (first %) (second %)))
       count))

(defn calc-increment-window [depths]
  (->> depths
       (partition 3 1)
       (reduce #(conj %1 (reduce + %2)) [])
       calc-increment))

(defn parse-input [& depths]
  (->> depths
       (flatten)
       (filter #(not= "" %))
       (map #(Integer/parseInt %))))
