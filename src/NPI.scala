import collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: Androw
 * Date: 19/02/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */


object NPI {
   def main(args: Array[String]) {
     val expr = args(0);
     val argsNb = args.length;
     val stack = new mutable.Stack[Double];

     var i = 0
     while (i < argsNb) {
       args(i) match {
         case "+" =>
           var a = stack.pop()
           var b = stack.pop()
           stack.push(b+a)
         case "-" =>
           var a = stack.pop()
           var b = stack.pop()
           stack.push(b-a)
         case "*" =>
           var a = stack.pop()
           var b = stack.pop()
           stack.push(b*a)
         case "/" =>
           var a = stack.pop()
           var b = stack.pop()
           stack.push(b/a)
         case _ => stack.push(args(i).toDouble)
       }
       i = i + 1
     }
     println(stack.pop())
   }
 }
