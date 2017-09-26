package com.phamluu.design_ptt.creational.factoryptt.factory;

import com.phamluu.design_ptt.creational.factoryptt.product.BigUFOEnemyShip;
import com.phamluu.design_ptt.creational.factoryptt.product.EnemyShip;
import com.phamluu.design_ptt.creational.factoryptt.product.RocketEnemyShip;
import com.phamluu.design_ptt.creational.factoryptt.product.UFOEnemyShip;

public class EnemyShipFactory{

  // This could be used as a static method if we
  // are willing to give up subclassing it

  public EnemyShip makeEnemyShip(String newShipType){


    if (newShipType.equals("U")){

      return new UFOEnemyShip();

    } else

    if (newShipType.equals("R")){

      return new RocketEnemyShip();

    } else

    if (newShipType.equals("B")){

      return new BigUFOEnemyShip();

    } else return null;

  }

}