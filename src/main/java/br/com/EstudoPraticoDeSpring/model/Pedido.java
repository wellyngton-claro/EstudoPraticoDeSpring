package br.com.EstudoPraticoDeSpring.model;

import lombok.experimental.Accessors;
import javax.persistence.Entity;

@Accessors(chain = true)
@Entity
public class Pedido extends Carrinho{
}
