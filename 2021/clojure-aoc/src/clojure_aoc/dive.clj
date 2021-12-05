(ns clojure-aoc.dive
  (:require [clojure.string :as str]
            [clojure.core.match :refer [match]]))

(defn- coord-product [[x y _]]
  (* x y))

(defn final-coord [commands]
  (->> commands
       (reduce (fn [[curr-x curr-y aim] command]
                 (match command
                   [:forward x] [(+ curr-x x) (+ (* aim x) curr-y) aim]
                   [:down x] [curr-x curr-y (+ aim x)]
                   [:up x] [curr-x curr-y (- aim x)]
                   :else [curr-x curr-y aim]))
               [0 0 0])
       (coord-product)))

(defn parse-line [line]
  (as-> line v
    (str/split v #" ")
    (vector (keyword (first v)) (Integer/parseInt (second v)))))

(defn parse-input [& args]
  (->> args
       (flatten)
       (map parse-line)))
