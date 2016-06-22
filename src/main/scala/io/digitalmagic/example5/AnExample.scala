package io.digitalmagic.example5

import io.digitalmagic.example5.{Op, OrderApi}
import OrderApi._
import scala.language.postfixOps

/**
  * Created by Sergey on 6/22/2016.
  */
object AnExample extends Op {

  def main(args:Array[String]) = {
    process(
      sell (30 USD) at limit price (10.54 EUR),
      buy (30.1 USD) at limit price (10 EUR),
      sell (10 shares of APPLE) at limit price (10 EUR),
      buy (30 shares of IBM) at limit price (10 EUR)
    )
  }
}
