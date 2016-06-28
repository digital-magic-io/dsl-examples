package io.digitalmagic.example3

import OrderApi._
import io.digitalmagic.Api._

object Example {

  def main(args:Array[String]) = {

    process (
      I buy 300 currencyOf EUR atPrice 250.00 of USD,
      I sell 100 sharesOf Apple atPrice 10.35 of USD
    )

  }

}
