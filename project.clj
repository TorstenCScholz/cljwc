(defproject wc "0.0.1"
  :description "Counts the number of lines, words and characters."
  :url "https://github.com/TorstenCScholz/CmdClj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot wc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
