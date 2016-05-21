import scala.collection.mutable.ArrayBuffer;
import scala.collection.Searching._

object Solution {

    def main(args: Array[String]) {
        var med = new MedianUpdates()
        for (line <- scala.io.Source.stdin.getLines.drop(1)) {
            println(med.processLine(line))
        }
    }
    
    class MedianUpdates {
        var ab = new ArrayBuffer[Int]();
        
        def insert(v: Int) : Unit = {
            ab.search(v) match {
                case Found(i) =>
                    ab.insert(i, v)
                case InsertionPoint(i) =>
                    ab.insert(i, v)
            }            
        }
        
        def remove(v: Int) : Boolean = {
            ab.search(v) match {
                case Found(i) =>
                    ab.remove(i)
                    true
                case InsertionPoint(i) =>
                    false  
            }
        }
        
        def format(d: Double) : String = {
            if (d == d.toInt) "%d".format(d.toInt)
                else "%f".format(d).replaceAll("0+$","")
        }
        
        def median() : String = {
            ab.length match {
                case 0 => "Wrong!";
                case n if n % 2 == 1 =>
                    val m = n / 2;
                    format(ab(m).toDouble)
                case n  =>
                    val m = n / 2;
                    val r = ((ab(m-1) + ab(m)).toDouble / 2.0);
                    format(r)
            }
        }

        def processLine(line: String) : String = {
            line.split(" ") match {
                case Array("r", nstr) =>
                    if (remove(nstr.toInt)) median else "Wrong!"
                case Array("a", nstr) =>
                    insert(nstr.toInt)
                    median
            }
        }
    }
}
