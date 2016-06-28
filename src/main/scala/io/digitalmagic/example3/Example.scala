package io.digitalmagic.example3

import OrderApi._
import io.digitalmagic._

object Example {

  def main(args:Array[String]) = {

    process (
      I buy 300 currency EUR atPrice 250.00 allOrNone,
      I sell 100 sharesOf Apple atPrice 10.35
    )

  }

}
