package io.digitalmagic.example5

import io.digitalmagic.Api._
import io.digitalmagic.Order.{Action, Tradeable}
import io.digitalmagic.Order.Action._

object OrderApi {

  val I = OrderApi

  case class price(quantity: Double, currency: Currency)

  case class Item(action: Action, offer: TradeOffer) {
    def at(price: price): Order = Order(action, offer.quantity, offer.tradeable, price.quantity, price.currency)
  }

  def buy(quantity: Int, tradeable: Tradeable): Item = Item(BUY, TradeOffer(quantity, tradeable))
  def sell(quantity: Int, tradeable: Tradeable): Item = Item(SELL, TradeOffer(quantity, tradeable))

  object shares {
    def of(share: Share) = share
  }

}
