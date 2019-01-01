package com.zsm

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * @Author: zengsm.
  * @Description: TODO( )
  * @Date:Created in 2019-01-01.
  * @Modified By: 
  */
object Main {
  val path:String="C:\\Users\\Administrator\\Desktop\\移动\\S1U-103-2018111705-109-0.txt";
  def main(args: Array[String]): Unit = {

    val writer = new PrintWriter(new File("C:\\Users\\Administrator\\Desktop\\移动\\result.txt"))

    val data=Source.fromFile(path);
    val lines=data.getLines();
    while (lines.hasNext)
    {
      val sp=lines.next()
      val str = sp.split("\\|")
      val val1 = str(72)
      val val2=str(73)
      //        if(val1)
      writer.append(val1+"|"+val2+"\n")
    }


    writer.close()
    println("end")
  }
}
