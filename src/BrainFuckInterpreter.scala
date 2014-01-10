/**
 * Created with IntelliJ IDEA.
 * User: Androw
 * Date: 19/02/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */

import scala.util.control.Breaks._

object BrainFuckInterpreter {
  def main(args: Array[String]) {
    var code = args(0);
    var codeLength = code.length;
    var mem = new Array[Int](256);

    var indiceMemoire: Int = 0;
    for (i <- 0 until mem.length){
      mem(i) = 0
    }
    var i = 0
    while (i < codeLength){
      if (mem(indiceMemoire)==0) mem(indiceMemoire)=0
      else {
        mem(indiceMemoire) = (256+mem(indiceMemoire))% 256
      }

      code(i) match {
        case '>' => indiceMemoire = 1 + indiceMemoire;
        case '<' => indiceMemoire = indiceMemoire - 1;
        case '.' => print(mem(indiceMemoire).toChar)
        case ',' => mem(indiceMemoire)=Console.in.read()
        case '+' => mem(indiceMemoire) = 1 + mem(indiceMemoire);
        case '-' => mem(indiceMemoire) = mem(indiceMemoire) -1;
        case ']' =>
          var n = 1
          while (n != 0) {
            i = i - 1
            if (code(i)==']')  n = n + 1
            else if (code(i)=='[') n = n - 1
          }
          i = i - 1
        case '[' =>
          if (mem(indiceMemoire) == 0) {
            var n = 1
            while (n != 0) {
              i = i + 1
              if (code(i)=='[') n = n + 1
              else if (code(i)==']') n = n - 1
            }
          }
      }
      i = i + 1
    }
  }
}
