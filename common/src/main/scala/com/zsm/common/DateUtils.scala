package com.zsm.common

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

/**
  * @Author: zengsm.
  * @Description: TODO( )
  * @Date:Created in 2019-01-01.
  * @Modified By: 
  */
object DateUtils {

  val TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  val TIME_FORMAT_SHORT = new SimpleDateFormat("yyyy-MM-dd")
  val DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd")
  val DATE_FORMAT_KEY = new SimpleDateFormat("yyyyMMdd")
  val DATE_FORMAT_STRING = new SimpleDateFormat("yyyyMMddHHmm")

  /**
    * 判断一个时间是否在另一个时间之前
    *
    * @param time1 第一个时间
    * @param time2 第二个时间
    * @return 判断结果
    */
  def before(time1: String, time2: String, formatter: SimpleDateFormat): Boolean = {
    val dateTime1 = formatter.parse(time1)
    val dateTime2 = formatter.parse(time2)
    if (dateTime1.before(dateTime2)) {
      return true
    }
    false
  }

  /**
    * 判断一个时间是否在另一个时间之后
    *
    * @param time1 第一个时间
    * @param time2 第二个时间
    * @return 判断结果
    */
  def after(time1: String, time2: String, formatter: SimpleDateFormat): Boolean = {
    val dateTime1 = formatter.parse(time1)
    val dateTime2 = formatter.parse(time2)
    if (dateTime1.after(dateTime2)) {
      return true
    }
    false
  }

  /**
    * 计算时间差值（单位为秒）
    *
    * @param time1 时间1
    * @param time2 时间2
    * @return 差值
    */
  def minus(time1: String, time2: String, formatter: SimpleDateFormat) {
    val datetime1 = formatter.parse(time1)
    val datetime2 = formatter.parse(time2)
    val millisecond = datetime1.getTime() - datetime2.getTime()
    java.lang.Long.valueOf(String.valueOf(millisecond / 1000))
  }

  /**
    * 获取年月日和小时
    *
    * @param datetime 时间（yyyy-MM-dd HH:mm:ss）
    * @return 结果（yyyy-MM-dd_HH）
    */
  def getDateHour(datetime: String): String = {
    val date = datetime.split(" ")(0)
    val hourMinuteSecond = datetime.split(" ")(1)
    val hour = hourMinuteSecond.split(":")(0)
    date + "_" + hour
  }

  /**
    * 获取当天日期（yyyy-MM-dd）  TIME_FORMAT_SHORT
    *
    * @return 当天日期
    */
  def getTodayDate(formatter: SimpleDateFormat): String = {
    formatter.format(new Date())
  }

  /**
    * 获取昨天的日期（yyyy-MM-dd） TIME_FORMAT_SHORT
    *
    * @return 昨天的日期
    */
  def getYesterdayDate(formatter: SimpleDateFormat): String = {
    val cal = Calendar.getInstance()
    cal.setTime(new Date())
    cal.add(Calendar.DAY_OF_YEAR, -1)
    val date = cal.getTime()
    formatter.format(date)
  }

  /**
    * 格式化日期（yyyy-MM-dd） TIME_FORMAT_SHORT
    *
    * @param date Date对象
    * @return 格式化后的日期
    */
  def formatDate(date: Date, formatter: String): String = {
    if (formatter != null) {
      new SimpleDateFormat(formatter).format(date)
    } else {
      DATE_FORMAT.format(date)
    }
  }

  /**
    * 格式化时间（yyyy-MM-dd HH:mm:ss）
    *
    * @param date Date对象
    * @return 格式化后的时间
    */
  def formatTime(date: Date, formatter: String): String = {
    if (formatter != null) {
      new SimpleDateFormat(formatter).format(date)
    } else {
      TIME_FORMAT.format(date)
    }
  }

  /**
    * 解析时间字符串
    *
    * @param time 时间字符串
    * @return Date
    */
  def parseTime(time: String, formatter: String): Date = {
    if (formatter != null) {
      new SimpleDateFormat(formatter).parse(time)
    } else {
      TIME_FORMAT.parse(time)
    }
  }

  /**
    * 格式化日期key  DATE_FORMAT_KEY
    *
    * @param date
    * @return
    */
  def formatDateKey(date: Date, formatter: SimpleDateFormat) {
    formatter.format(date)
  }

  /**
    * 格式化日期key  DATE_FORMAT_KEY
    *
    * @param datekey
    * @return
    */
  def parseDateKey(datekey: String, formatter: SimpleDateFormat) {
    formatter.parse(datekey)
  }

  /**
    * 格式化时间，保留到分钟级别
    * yyyyMMddHHmm
    *
    * @param date
    * @return
    */
  def formatTimeMinute(date: Date) {
    DATE_FORMAT_STRING.format(date)
  }

  /**
    * 组合时间，为空时默认返回当前时间
    */
  def verdict(year: String, month: String, day: String, hour: String): String = {
    var out_year: String = ""
    var out_month: String = ""
    var out_day: String = ""
    var out_hour: String = ""
    if (year == "" || month == "" || day == "" || hour == "") {
      val out_date = new Date().getTime()
      val fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val str = fm.format(out_date)
      val arrays = str.split(" ")
      val ymd = arrays(0).split("-")
      val time = arrays(1).split(":")
      out_year = ymd(0)
      out_month = ymd(1)
      out_day = ymd(2)
      out_hour = time(0)
    } else {
      out_year = year
      out_month = month
      out_day = day
      out_hour = hour
    }
    return out_year + "," + out_month + "," + out_day + "," + out_hour
  }

  def date_first(date: String): String = {
    val fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val str = fm.format(new Date(date.toLong))
    val split = str.split(" ")
    val time = split(1).split(":")
    val ymd = split(0).split("-")
    ymd(0) + "," + ymd(1) + "," + ymd(2) + "," + time(0)
  }

  /**
    * 时间字符串转 年,月,日,小时
    */
  def Date_YMDH(date: String): String = {
    val ymrh = TIME_FORMAT.format(new Date(date.toLong))
    val split = ymrh.split(" ")
    val time = split(1).split(":")
    val ymd = split(0).split("-")
    return ymd(0) + "," + ymd(1) + "," + ymd(2) + "," + time(0)
  }
}
