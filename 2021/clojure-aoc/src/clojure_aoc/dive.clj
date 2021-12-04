(ns clojure-aoc.dive
  (:require [clojure.string :as str]
            [clojure.core.match :refer [match]]))

(defn- coord-product [final-coord]
  (* (first final-coord) (second final-coord)))

(defn final-coord [inputs]
  (->> inputs
       (reduce (fn [position command]
                 (match command
                   [:forward x] [(+ (first position) x) (second position)]
                   [:down y] [(first position) (+ (second position) y)]
                   [:up y] [(first position) (- (second position) y)]
                   :else position))
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
