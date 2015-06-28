package com.undercurrentapp.web {
  trait Request[ResponseClass[_]] {
    def complete[T : ResponseClass](response : T) : Unit; 
  }
}
