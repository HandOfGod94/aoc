(ns clojure-aoc.dive
  (:require [clojure.string :as str]
            [clojure.core.match :refer [match]]))

(defn- coord-product [final-coord]
  (* (first final-coord) (second final-coord)))

(defn final-coord [commands]
  (->> commands
       (reduce (fn [[curr-x curr-y] command]
                 (match command
                   [:forward x] [(+ curr-x x) curr-y]
                   [:down y] [curr-x (+ curr-y y)]
                   [:up y] [curr-x (- curr-y y)]
                   :else [curr-x curr-y]))
               [0 0])
       (coord-product)))

(defn parse-line [line]
  (as-> line v
    (str/split v #" ")
    (vector (keyword (first v)) (Integer/parseInt (second v)))))

(defn parse-input [& args]
  (->> args
       (flatten)
       (map parse-line)))
