(ns wc.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn extract-words [lines]
  (filter (complement empty?) (reduce #(apply conj %1 (str/split %2 #"\s+")) (empty lines) lines)))

(defn format-stats [{:keys [lines words characters] :as stats} filename]
  (format "%8d%8d%8d %s" lines words characters filename))

(defn print-stats
  ([{:keys [lines words characters] :as stats} filename]
    (println (format-stats stats filename)))
  ([stats]
    (print-stats stats "")))

(defn analyse [input]
  (let [content (slurp input)
        lines (str/split-lines content)
        words (extract-words lines)
        characters (seq content)]
    {:lines (count lines) :words (count words) :characters (count characters)}))

; TODO: Handle glob filenames
(defn -main
  "Returns statistics about the textual input."
  [& args]
  (if (seq args)
    (doseq [filename args] (print-stats (analyse filename) filename))
    (print-stats (analyse *in*))))
