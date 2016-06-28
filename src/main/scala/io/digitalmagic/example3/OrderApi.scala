package io.digitalmagic.example3

import io.digitalmagic.Order.Action
import io.digitalmagic.Api._

object OrderApi {

  def I = OrderApi

  private def buildOrder(quantity: Int, action: Action) = Order(action, quantity = quantity, null, limitPrice = 0.0, null, all = false)
  def buy(quantity: Int): Order = buildOrder(quantity, Action.BUY)
  def sell(quantity: Int): Order = buildOrder(quantity, Action.SELL)

  implicit class OrderEnchaser(order: Order) {
    def sharesOf(share: Share): Order = order.copy(tradeable = share)
    def currencyOf(currency: Currency): Order = order.copy(tradeable = currency)
    def atPrice(price: Double): Order = order.copy(limitPrice = price)
    def of (currency: Currency): Order = order.copy(currency = currency)
  }

}
