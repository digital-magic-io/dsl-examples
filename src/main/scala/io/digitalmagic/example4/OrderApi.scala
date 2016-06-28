package io.digitalmagic.example4

import io.digitalmagic.Api
import io.digitalmagic.Api._
import io.digitalmagic.Order.Action
import io.digitalmagic.Order.Action._

object OrderApi {

  val I = OrderApi

  def buy(quantity: Int): ActionWord = ActionWord(quantity, BUY)
  def sell(quantity: Int): ActionWord = ActionWord(quantity, SELL)

  case class ActionWord(quantity: Int, action: Action) {
    def EUR(a: AtWord) = PriceWord(action, TradeOffer(quantity, Api.EUR))
    def USD(a: AtWord) = PriceWord(action, TradeOffer(quantity, Api.USD))
    def shares(of: OfWord) = ShareWord(this)
  }

  case class ShareWord(word: ActionWord) {
    def Apple(a: AtWord) = PriceWord(word.action, TradeOffer(word.quantity, Api.Apple))
    def IBM(a: AtWord) = PriceWord(word.action, TradeOffer(word.quantity, Api.IBM))
  }

  case class PriceWord(action: Action, offer: TradeOffer) {
    def price(price: Double) = PriceLimitWord(action, offer, price)
  }

  case class PriceLimitWord(action: Action, offer: TradeOffer, price: Double) {
    def USD : Order = Order(action, offer.quantity, offer.tradeable, price, Api.USD)
    def EUR : Order = Order(action, offer.quantity, offer.tradeable, price, Api.EUR)
  }

}
