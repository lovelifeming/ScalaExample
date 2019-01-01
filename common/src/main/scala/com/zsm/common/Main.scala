package com.zsm.common

/**
  * @Author: zengsm.
  * @Description: TODO( )
  * @Date:Created in 2019-01-01.
  * @Modified By: 
  */
object Main {

  def main(args: Array[String]): Unit = {

    print(DateUtils.TIME_FORMAT_SHORT.toPattern)
    val bool = DateUtils.before("2018-12-1","2018-12-2",DateUtils.TIME_FORMAT_SHORT)
    print(bool)

  }
}
