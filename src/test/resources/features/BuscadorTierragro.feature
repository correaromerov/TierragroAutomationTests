Feature: HU-001 Buscador Tierragro
  Yo como usuario de Tierragro
  Quiero buscar en el buscador el nombre de los productos
  Para ver cada producto

  Scenario: Buscar palabra en el buscador de Tierragro exitoso
    Given que me encuentro en la pagina de Tierragro
    When busco el nombre del producto en el buscador
    Then podre ver el producto
