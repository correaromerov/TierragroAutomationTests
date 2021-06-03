Feature: HU-001 Buscador Tierragro
  Yo como usuario de Tierragro
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario Outline: <Escenario>
    Given que me encuentro en la pagina de Tierragro con la url <Url>
    When busco el producto en el buscador
    Then podre ver el producto en pantalla

    Examples: 
      | Escenario                       	         			    | Url                  		   |
      | Buscar palabra en el buscador de Tierragro exitoso	| https://www.tierragro.com/ |