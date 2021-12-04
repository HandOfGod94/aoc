(ns clojure-aoc.dive
  (:require [clojure.string :as str]))

(defn final-coord [inputs]
  ())

(defn parse-line [line]
  (as-> line v
    (str/split v #" ")
    (list (keyword (first v)) (Integer/parseInt (second v)))))

(defn parse-input [& args]
  (->> args
       (map parse-line)))
