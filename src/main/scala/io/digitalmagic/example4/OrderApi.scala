package io.digitalmagic.example4

import io.digitalmagic.Order.Action
import io.digitalmagic.example3.OrderApi.{OrderValuer, Premium, Standard}

object OrderApi {

  case class Order(
    securityName: String,
    securityType: SecurityType,
    value: Double,
    allOrNone: Boolean,
    quantity: Int,
    action: Action,
    limitPrice: Double,
    currency: String
  ) {
    def all_Or_None = copy(allOrNone = true)
  }

  object Order {
    def build(action: Action, quantity: Int): Order = Order(null, null, 0, allOrNone = false, quantity, action, 0, null)
  }

  trait SecurityType
  case object shares extends SecurityType
  case object currency extends SecurityType

  trait TheAction {
    def a(quantity: Int): Quantity
  }

  case object Sell extends TheAction {
    override def a(quantity: Int): Quantity = Quantity(Order.build(Action.SELL, quantity))
  }

  case object Buy extends TheAction {
    override def a(quantity: Int): Quantity = Quantity(Order.build(Action.BUY, quantity))
  }

  case class Quantity(order: Order) {
    def tk(st: SecurityType): TheSecurityType = TheSecurityType(order.copy(securityType = st))
  }

  case class TheSecurityType(order: Order) {
    def of(name: String): SecurityName = SecurityName(order.copy(securityName = name))
  }

  case class SecurityName(order: Order) {
    def at_limit_price(price: Double): LimitPrice = LimitPrice(order.copy(limitPrice = price))
  }

  case class LimitPrice(order: Order) {
    def value_as(valuer: OrderValuer): Order = order.copy(value = valuer.valueAs(order.quantity, order.limitPrice))
  }

  def process(order: Order*) = {
    order foreach System.out.println
  }
}
