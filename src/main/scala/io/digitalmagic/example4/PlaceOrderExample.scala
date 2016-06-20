package io.digitalmagic.example4
import OrderApi._
import io.digitalmagic.example3.OrderApi.{Premium, Standard}

object PlaceOrderExample {

  def main(args:Array[String]) = {

    process (
      Buy a 100 tk shares of "Apple" at_limit_price 12.54 value_as Standard all_Or_None,
      Sell a 50 tk shares of "IBM" at_limit_price 11.45 value_as Premium,

      Buy a 30 tk currency of "USD" at_limit_price 10.00 value_as Standard,
      Sell a 20 tk currency of "EUR" at_limit_price 11.00 value_as Standard
    )

  }
}
