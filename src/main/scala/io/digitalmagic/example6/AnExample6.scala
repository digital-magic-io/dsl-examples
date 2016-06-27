package io.digitalmagic.example6

import OrderApi._
import scala.language.postfixOps

object AnExample6 {

  def main(args: Array[String]): Unit = {
    process(
      to buy 300 EUR at price 250 USD,
      to sell 100 USD at price 200 EUR,
      to sell 200 shares of APPLE at price 100 EUR,
      to buy 500 shares of IBM at price 10 USD
    )
  }
}
