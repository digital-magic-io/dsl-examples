package io.digitalmagic.example5

import io.digitalmagic.Api._
import io.digitalmagic.example5.OrderApi._

object Example {

  def main(args:Array[String]) = {

    process (
      I buy (300, EUR) at price (250.00, USD),
      I sell (100, shares of Apple) at price (10.35, USD)
    )
  }
}
