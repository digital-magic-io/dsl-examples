package io.digitalmagic

import io.digitalmagic.Order.Tradeable

sealed trait Share extends Tradeable
sealed trait Currency extends Tradeable

case object Apple extends Share
case object IBM extends Share

case object USD extends Currency
case object EUR extends Currency
